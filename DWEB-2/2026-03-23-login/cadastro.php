<?php

require 'db.php';

$message = "";

// Verifica se o script foi chamado pelo método POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = trim($_POST["nome"]);
    $telefone = trim($_POST["telefone"]);
    $nascimento = trim($_POST["nascimento"]);
    $email = trim($_POST["email"]);
    // hash é um mecanismo inicial de "criptografia"
    $senha = password_hash($_POST["senha"], PASSWORD_DEFAULT);

    // Verificar se o email ainda não está no banco de dados
    $checkEmail = $conn->prepare("SELECT id FROM usuarios WHERE email = ?");
    $checkEmail->bind_param("s", $email);

    $checkEmail->execute();
    $result = $checkEmail->get_result();

    // Se num_rows > 0, significa que encontrou aquele email no banco
    if ($result->num_rows > 0) {
        $message = "<div class='message error'>Este e-mail já está cadastrado!</div>";
    } else {
        $stm = $conn->prepare("INSERT INTO usuarios (nome, telefone, data_nascimento, email, senha) VALUES (?, ?, ?, ?, ?)");
        $stm->bind_param("sssss", $nome, $telefone, $nascimento, $email, $senha);

        if ($stm->execute()) {
            $message = "<div class='message success'>
            Usuário cadastrado com sucesso!
            <br>
            <a href='index.php'>Faça login agora.</a>
            </div>";
        } else {
            $message = "<div class='message error'>Erro ao cadastrar!" . $stm->error . "</div>";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <h2>Criar nova conta</h2>
        <p style="text-align: center; color: #666; margin-bottom: 20px;">
            Preencha os dados abaixo para se cadastrar!
        </p>

        <?php echo $message; ?>

        <form action="cadastro.php" method="POST">
            <label for="">Nome Completo:</label>
            <input type="text" name="nome" id="nome" placeholder="Nome Exemplo" required>

            <label for="">Telefone:</label>
            <input type="text" name="telefone" id="telefone" placeholder="(**)*****-****">

            <label for="">Data de Nascimento:</label>
            <input type="date" name="nascimento" id="nascimento">

            <label for="">E-mail:</label>
            <input type="email" name="email" id="email" placeholder="seu@email.com" required>

            <label for="">Senha:</label>
            <input type="password" name="senha" id="senha" placeholder="Crie uma senha" required>

            <input type="submit" value="Finalizar Cadastro">
        </form>

        <div class="actions">
            <span>Já possui uma conta?</span>
            <a href="index.php">Voltar para o login</a>
        </div>
    </div>
</body>

</html>