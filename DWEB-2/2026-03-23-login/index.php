<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <h2>Acesse sua conta</h2>

        <?php
        if (isset($_GET["erro"]) && $_GET["erro"] == 1) {
            echo "<div class='message error'> E-mail ou senha incorretos!</div>";
        }
        ?>

        <form action="login.php" method="POST">
            <label for="email">E-mail:</label>
            <input type="email"
                name="email"
                id="email"
                placeholder="seu@email.com"
                required>

            <label for="senha">Senha:</label>
            <input type="password"
                name="senha"
                id="senha"
                placeholder="Senha"
                required>

            <input type="submit" value="Entrar">
        </form>

        <div class="actions">
            <span>Ainda não tem uma conta?</span>
            <a href="cadastro.php">Cadastre-se na plataforma</a>
        </div>
    </div>
</body>

</html>