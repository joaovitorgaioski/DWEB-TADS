<?php
/*
Podemos definir cookies como quisermos. Este é um exemplo de um cookie para guardar um idioma.
Devemos verificar se o cookie ja existe.
Um cookie com o 'path' = '/' vai do path principal em diante.
Normalmente criptografamos os cookies, mas para dados não-sensíveis não é totalmente necessário.
*/
date_default_timezone_set('UTC');

$idiomaAtual = "";
$idiomaPadrao = "pt-br";

if (isset($_COOKIE["idioma"])) {
    $idiomaAtual = $_COOKIE["idioma"];
} else {
    setcookie("idioma", $idiomaPadrao, time() + (60 * 5), "/");
}

$idioma = [
    "pt-br" => "Painel de Administração",
    "en-us" => "Administration Panel",
    "it" => "Pannello di Amministrazione"
];

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <h1> <?= $idioma[$idiomaAtual] ?> </h1>

    <?= time() ?>
    <?= date("c") ?>

    <form action="config-idioma.php" method="POST">
        <label for="br">Brasil</label>
        <input type="radio" id="br" name="idioma" value="pt-br">
        <br>
        <label for="us">Estados Unidos</label>
        <input type="radio" id="us" name="idioma" value="en-us">
        <br>
        <label for="it">Italia</label>
        <input type="radio" id="it" name="idioma" value="it">
        <br>
        <input type="submit" value="Escolher">
    </form>

    <a href="produtos/index.php">Produtos</a>
    <a href="clientes/index.php">Clientes</a>
    <a href="sair.php">Sair</a>
</body>

</html>