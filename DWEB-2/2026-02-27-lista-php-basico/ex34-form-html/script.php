<?php

function calcularJuros($c, $i, $t) {
    $i = $i ?? 0.01;
    $t = $t ?? 1;
    $c = $c ?? 0;
    
    return $c * (1 + $i * $t);
}

$capital = $_GET["capital"];
$taxa = $_GET["taxa"] / 100;
$tempo = $_GET["tempo"];

$montante = calcularJuros($capital, $taxa, $tempo);

echo "<h2>$montante</h2>";