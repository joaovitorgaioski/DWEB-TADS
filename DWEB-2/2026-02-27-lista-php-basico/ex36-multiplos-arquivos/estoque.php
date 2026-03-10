<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercício 36</title>
</head>

<body>
    <?php

    require_once("dados.php");

    ?>

    <table border="1">
        <tr>
            <th>Produto</th>
            <th>Quantidade</th>
            <th></th>
        </tr>

        <?php
        foreach ($estoque as $item => $qtd) {
            echo "
            <tr>
            <td>$item</td>
            <td>$qtd</td>
            <td> <a href=\"controle_estoque.php?produto=$item\"> Diminuir </a> </td>
            </tr>
            ";
        }
        ?>
    </table>
</body>

</html>