<?php

$produtos = [
    "Alface" => 2.0,
    "Picanha" => 90.99,
    "Refrigerante" => 4.99,
    "Carvão" => 20.2,
    "Pão de Alho" => 12.45,
    "Fósforo" => 4.5
];

foreach ($produtos as $produto => $preco) {
    echo $produto . "\t\t R$" . number_format($preco, 2) . "\n";
}