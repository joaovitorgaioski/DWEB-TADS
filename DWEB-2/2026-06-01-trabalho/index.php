<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jogos da Copa</title>
    <link rel="stylesheet" href="assets/style.css">
</head>

<body>
    <header>
        <h1>Acompanhe os Dados de uma Copa</h1>
    </header>

    <?php

    require "controller/JogoController.php";

    JogoController::exibirTodos();

    JogoController::exibirBrasil();

    JogoController::exibirEstatisticasTotais();

    JogoController::exibirJogosMaisFaltas();

    JogoController::exibirClassificacaoFinal();

    JogoController::exibirFinal();

    ?>

    <footer>
        <h3>IFPR - 2026</h3>
    </footer>
</body>

</html>