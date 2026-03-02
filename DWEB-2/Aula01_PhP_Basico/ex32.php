<?php

$produtos = array(
    array(
        "nome" => "Aveia Fina",
        "estoque" => 20
    ),
    array(
        "nome" => "Grão de Bico",
        "estoque" => 9
    ),
    array(
        "nome" => "Sal do Himalaia",
        "estoque" => 6
    ),
    array(
        "nome" => "Desinfetante",
        "estoque" => 12
    ),
    array(
        "nome" => "Desengordurante",
        "estoque" => 3
    )
);

function emFalta($produtos) {
    echo "Produtos em falta: \n";

    foreach ($produtos as $produto) {
        if ($produto["estoque"] < 10) {
            echo $produto["nome"] . "\t\t" . $produto["estoque"] . " unidades\n";
        }
    }
}

emFalta($produtos);