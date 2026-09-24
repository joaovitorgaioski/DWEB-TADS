# Anotações da aula de Controle de Acesso

## Login com Sessão

1. Ao informar email e senha em _login.jsp_, envia para _login_, que fica no arquivo
_LoginServlet_.
2. _LoginServlet_ recebe os dados por POST com o método _doPost_. Ele verifica se existe 
um usuário com este email e verifica a senha com _BCrypt.checkpw_, se a senha bate, 
gera um cookie chamado _token_ e vai até a _home.jsp_, caso não, volta para _login.jsp_.
3. Se deu certo o valor de sessão _usuarioLogado_ se torna o objeto usuario, senão fica null.

### Filtro

1. Criamos um filtro _AuthFilter_. Esse arquivo implementa _Filter_, que exige os métodos 
_init_, _destroy_ e _doFilter_. _init_ e _destroy_ são mais específicos, mas para nosso 
caso foi usado apenas o _doFilter_.
2. O _doFilter_ recebe toda requisição e faz um processamento. No nosso caso, o _doFilter_
verifica se há um token, se houver ele permite a passagem, caso não, ele volta até 
_login.jsp_.
3. Para obter os cookies, criamos um método _getCookie_ que filtra os cookies para verificar 
o token.

## JWT

1. Criamos um _jwt.properties_ e usamos a classe _JwtProperties_ para salvar as propriedades
definidas dentro de um _properties_.
2. Criamos um _JwtUtils_ e dentro dele criamos dois métodos: _generateToken_ e _validateToken_. 
O primeiro faz a geração de um token. O segundo faz a validação de um token.
3. Após esta preparação, basta alterar o _LoginServlet_ para o cookie receber um token JWT, e
não um cookie qualquer.