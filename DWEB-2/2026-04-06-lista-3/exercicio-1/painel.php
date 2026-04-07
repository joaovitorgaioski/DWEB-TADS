<?php

session_start();

// Verificar se não existe variável de controle de login ou se o login é false -> volta pro index. Senão, tá logado e executa de boa.
if (!isset($_SESSION['logado']) || $_SESSION['logado'] != true) {
    header('Location: index.php');
    exit();
}

$nome_usuario = $_SESSION['nome_usuario'];

$contador = $_SESSION['contador']++;

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel</title>
</head>

<body>
    <h1>Área Logada!</h1>

    <div class="container">
        <div class="message success">
            Olá, <?php echo htmlspecialchars($nome_usuario); ?>
        </div>

        <h2>Contador: <?php echo htmlspecialchars($contador) ?></h2>
    </div>

    <a href="logout.php">Sair</a>
</body>

</html>