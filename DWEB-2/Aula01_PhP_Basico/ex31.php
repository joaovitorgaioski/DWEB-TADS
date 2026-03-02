<?php

$numeros = [2, 6, 6, 7, 3];

function somarElementos($numeros) {
    $s = 0;
    for ($i = 0; $i < sizeof($numeros); $i++) {
        $s += $numeros[$i];
    }
    
    return $s;
}

echo somarElementos($numeros);