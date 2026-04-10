<?php

require 'db.php';

session_start();

// Verificação para saber se o usuário esta logado. Se não estiver, volta para o index.php
if (!isset($_SESSION['logado']) || $_SESSION['logado'] != true) {
    header('Location: index.php');
    exit();
}

// Nome e Contador de SESSION
$nome_usuario = $_SESSION['nome_usuario'];
$contador = $_SESSION['contador']++;

// Tema
$temaPadrao = "claro";
$temaEscolhido = $temaPadrao;

if (isset($_COOKIE['tema'])) {
    $temaEscolhido = $_COOKIE["tema"];
} else {
    setcookie("tema", $temaPadrao, time() + (60 * 5), "/");
}

$temas = [
    "claro" => "style-painel-white.css",
    "escuro" => "style-painel-black.css"
];

// Último Acesso
$stm = $conn->prepare("SELECT ultimo_acesso FROM usuarios WHERE id = ? LIMIT 1");
$stm->bind_param("i", $_SESSION['id_usuario']);

$stm->execute();
$result = $stm->get_result();
$ultimoAcesso = $result->fetch_assoc();

$stm->close();
$conn->close();

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel</title>
    <link rel="stylesheet" href=<?= $temas[$temaEscolhido] ?>>
</head>

<body>
    <h1>Área Logada!</h1>
    <form action="toggle-tema.php" method="POST">
        <label for="claro">Claro</label>
        <input type="radio" id="claro" name="tema" value="claro">
        <br>

        <label for="escuro">Escuro</label>
        <input type="radio" id="escuro" name="tema" value="escuro">
        <br>

        <input type="submit" value="Alterar Tema">
    </form>
    <br>

    <div class="container">
        <div class="message success">
            Olá, <?php echo htmlspecialchars($nome_usuario); ?>
        </div>

        <h2>Contador: <?php echo htmlspecialchars($contador) ?></h2>
    </div>

    <i>Seu último acesso foi em: <?= htmlspecialchars($ultimoAcesso['ultimo_acesso']) ?>></i>
    <br>
    <i>Tema selecionado: <?= htmlspecialchars($temaEscolhido) ?></i>
    <br>
    <a href="logout.php">Sair</a>
</body>

</html>