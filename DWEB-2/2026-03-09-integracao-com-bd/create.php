<?php

require_once 'db.php';
$message = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['nome'];
    $email = $_POST['email'];

    if (empty($nome) || empty($email)) {
        $message = "Por favor, preencha todos os campos.";
    } elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $message = "Formato de email inválido.";
    } else {
        // Criar um Prepared Statement para evitar SQL injection
        $stm = $conn->prepare("INSERT INTO tb_usuarios (nome, email) VALUES ($, $)");
        if ($stm == false) {
            $message = "Erro na preparação da query." . $conn->error;
        } else {
            $stm->bind_param("ss", $nome, $email); //ss é o tipo de dado dos parâmetros
            if ($stm->execute()) {
                $message = "Usuário adicionado com sucesso.";
            } else {
                if ($conn->errno == 1062) { // Erro de entrada duplicada
                    $message = "Este email já está cadastrado.";
                } else {
                    $message = "Erro ao adicionar o usuário." . $stm->error;
                }
            }

            $stm->close();
        }
    }
}

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Usuário</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Criar Novo Usuário</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <form method="POST">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" require placeholder="Digite um nome">

            <label for="email">Email</label>
            <input type="email" name="email" id="email" required placeholder="Digite um e-mail">

            <input type="submit" value="Adicionar Usuário">
        </form>

        <p><a href="index.php">Voltar para a lista de usuários</a></p>
    </div>
</body>

</html>