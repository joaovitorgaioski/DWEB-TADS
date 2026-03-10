<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercício 42</title>
</head>

<body>
    <?php

    $produtos = array(
        "Detergente" => array(
            "preco" => 7,
            "categoria" => "Limpeza"
        ),
        "Tri Bala" => array(
            "preco" => 29.99,
            "categoria" => "Alimento"
        ),
        "Azeite" => array(
            "preco" => 5.90,
            "categoria" => "Alimento"
        ),
        "Refrigerante" => array(
            "preco" => 4.50,
            "categoria" => "Alimento"
        ),
        "Desinfetante" => array(
            "preco" => 10.90,
            "categoria" => "Limpeza"
        )
    );

    function filtrarCategoria($produtos, $categoria) {
        foreach($produtos as $produto) {
            var_dump($produto);
            echo "<br>";
        }
    }

    filtrarCategoria($produtos, "Limpeza");

    ?>
</body>

</html>