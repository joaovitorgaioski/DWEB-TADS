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

1. Criamos o _jwt.properties_ para salvar as configurações (senha do token e tempo de expiração) e a classe _JwtProperties_ para ler esse arquivo.
2. Criamos a classe _JwtUtils_ com dois métodos:
    - _generateToken_: cria o token com o email, perfil do usuário e tempo de expiração.
    - _validateToken_: verifica se o token é válido e recupera os dados dele.
3. No _LoginServlet_, após validar a senha, geramos o token JWT, salvamos ele no cookie e também salvamos o token no banco de dados.

### Filtro com JWT

1. No _AuthFilter_, criamos o método _validarToken_ que usa o _validateToken_ para ler o cookie e buscar o usuário no banco.
2. O filtro verifica se o token do cookie é igual ao token que está salvo no banco para aquele usuário.
3. Se o token for válido, ele salva o usuário na sessão e deixa navegar. Caso contrário, manda de volta para o _login.jsp_.

### Logout

1. Criamos o _LogoutServlet_ para fazer o logout do sistema.
2. Ele zera o cookie do _token_ (define o valor como null e tempo como 0) e invalida a sessão do usuário antes de redirecionar.
