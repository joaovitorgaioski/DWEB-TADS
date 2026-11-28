# Anotações das Aulas de Spring

## Beans e Configurations

1. Configurations podem ser usadas para, entre outras coisas, configurar parâmetros para serviços externos, usuários e
   senhas para bancos de dados, etc.
2. A anotação é `@Configuration`. Dentro dela pode haver métodos com a anotação `@Bean`.
3. Beans são informações que podem ser chamadas em qualquer parte do sistema.

```
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema da Biblioteca";
    }
```

4. Para usar um bean usamos `@Autowired` e `@Qualifier`:

```
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;
    }
```

## Injeção de Dependência

<img src="src/main/resources/ioc.png" width="450">

* @Component contém métodos e anotações úteis para a aplicação.
* @Controller é o mesmo controller do modelo MVC.
* @Repository responsável por acesso a dados (é um singleton).
* @Service indica as classes que implementam as regras de negócio.

1. Quando as classes são anotadas, suas instâncias ficam dentro do container e podem ser injetadas em partes do código.
2. Para obter os valores de componentes, usamos `@Autowired`.
3. Para indicar explicitamente quais pacotes devem ser mapeados, usa-se a anotação
   `@ComponentScan`. Senão, ele mapeia todo o projeto.

## `application.properties`

1. <a href="https://docs.spring.io/spring-boot/appendix/application-properties/index.html">Lista de propriedades usadas
   pelo Spring</a> .
2. Também podemos obter valores diretamente do `application.properties`, usando a anotação `@Value()`.
3. Podemos ter diferentes `application.properties` para diferentes contextos, como para desenvolvimento e para produção.
4. Para alternar entre os perfis de contexto, colocamos `spring.profiles.active=[nome]`
   no `application.properties`, alterando nome.
5. A anotação `@Profile()` define qual perfil tem acesso às configurações de uma classe `@Configuration`.

## Anotações Customizadas

1. Podemos criar uma anotação customizada.
2. Por exemplo, uma anotação chamada `@Development` que define configurações no perfil desenvolvedor.
3. Usamos algumas anotações e o tipo `@interface`.

```
   @Target(ElementType.TYPE)
   @Retention(RetentionPolicy.RUNTIME)
   @Configuration
   @Profile("development")
   public @interface Development {
   }
```

## Spring Boot Data

### Bancos em Memória

Bancos de dados em memória são recursos utilizados para aplicações que demandam extrema velocidade, tanto para escrita
quanto para leitura de dados. Em geral, aplicações de tempo real. Alguns exemplos são: Redis, Amazon MemoryDB,
ElastiCache.

1. No exemplo desse projeto, usamos o banco de dados h2.
2. Definimos as configurações de acesso no `application.properties`.
3. Por meio do h2 console, conseguimos abrir a interface do banco no navegador.
4. SQL inserido no `resources` é automaticamente executado na inicialização, ou seja, podemos colocar SQLs para criar ou
   popular o banco. O Spring procura por arquivos `data.sql` ou `schema.sql`.
5. Agora criamos um `repository` para o modelo de dados.
6. Esse `repository` usa da classe `JdbcTemplate` com a anotação `@Autowired` para interagir com o banco.
7. Criamos os diferentes métodos: `salvar`, `obterTodos`, etc.

### JPA

1. Colocar as anotações nos modelos de dados. `@Entity`, `@Table`, etc.
2. Criar o repositório.
3. Este repositório usa a classe `EntityManager` para manipular o banco também com o componente `@Autowired`.
4. Alguns dos métodos do `EntityManager` são `persist`, `merge`, `find`, `createQuery`, `getResultList`, etc.
5. Sempre usar a anotação `@Transactional` para garantir que sejam feitas transações no banco.

### Spring Data

1. Podemos simplesmente criar uma interface com o nome da classe + repository.
2. Essa interface deve extender de `JpaRepository<Classe, TipoId>`.

```
   @Repository
   public interface UsuarioSpringDataRepository extends JpaRepository<Usuario, Integer> {}
```

3. Para os métodos, basta colocar nome específicos. Exemplo: `List<Usuario> findByNomeLike(String nome);`.
4. <a href="https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html">São conhecidos como Query
   Methods</a>.

## API Restful

### Controller

1. As requisições chegam em um Controller anotado com `@Controller`.
2. Para ler as chamadas, usamos anotações em métodos como `@PostMapping`, `@GetMapping`,
   `@DeleteMapping`, etc.
3. Os métodos devolvem uma resposta, um `ResponseEntity`.
4. Podemos obter dados da requisição usando, por exemplo `@RequestBody`, `@PathVariable()`,
   `@RequestParam`, etc.
5. Exemplo de GET:

```
@GetMapping("/api/usuarios/{id}")
    public ResponseEntity getUsuarioById(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isPresent()) return ResponseEntity.ok(usuario.get());
        return ResponseEntity.notFound().build();
    }
```

6. Caminhos podem ser os mesmos, mas devem haver verbos HTTP diferentes.
7. `ResponseEntity` possui diversos códigos HTTP disponíveis para retornar.
8. Exemplo de PUT:

```
@PutMapping("/api/usuarios/{id}")
    @ResponseBody
    public ResponseEntity update(@RequestBody Usuario usuario, @PathVariable("id") Integer id) {
        return repository
                .findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setId(id);
                    repository.save(usuario);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
```

### RestController

Semelhante, mas usamos técnicas que deixam o trabalho mais fácil.

1. As requisições chegam em `@RestController`.
2. A anotação `@RequestMapping()` indica um caminho padrão para aquele controlador.
3. A anotação `@ResponseStatus(HttpStatus.[tipo])` define o tipo de retorno quando há sucesso.
4. Exemplo de GET:

```
   @GetMapping("{id}")
   public Usuario getUsuarioById(@PathVariable("id") Integer id) {
       return repository
               .findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
   }
```