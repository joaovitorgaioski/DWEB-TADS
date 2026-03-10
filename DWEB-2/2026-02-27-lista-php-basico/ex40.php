<?php

$compras = array(
    "Detergente" => array(
        "preco" => 7,
        "qtd" => 3
    ),
    "Tri Bala" => array(
        "preco" => 29.99,
        "qtd" => 2
    ),
    "Azeite" => array(
        "preco" => 5.90,
        "qtd" => 5
    ),
    "Refrigerante" => array(
        "preco" => 4.50,
        "qtd" => 3
    ),
    "Aveia" => array(
        "preco" => 10.90,
        "qtd" => 4
    )
);


function calcularValorTotal($compras) {
    $total = 0;
    foreach($compras as $item) {
        echo "<h2>Total do item: R$" . $item["preco"] * $item["qtd"] . "</h2>";
        $total += $item["preco"] * $item["qtd"];
    }

    echo "<h1>Total a pagar: R$" . $total . "</h1>";
}

calcularValorTotal($compras);