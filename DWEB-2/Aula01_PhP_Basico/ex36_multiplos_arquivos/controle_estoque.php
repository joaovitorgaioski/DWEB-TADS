<?php

// Puxando $estoque de dados.php
require_once("dados.php");
$produto = $_GET["produto"];

// $estoque aqui na função é passado um array cópia. Não é passado uma referência
function diminuirEstoque($estoque, $produto)
{
    if (array_key_exists($produto, $estoque)) {
        if ($estoque[$produto] > 0) {
            $estoque[$produto]--;
        }
        if ($estoque[$produto] == 0) {
            echo "Produto esgotado";
        }
    }

    return $estoque;
}

$estoque = diminuirEstoque($estoque, $produto);
var_dump($estoque);

echo "<a href=\"estoque.php\">Ir para o estoque</a>";