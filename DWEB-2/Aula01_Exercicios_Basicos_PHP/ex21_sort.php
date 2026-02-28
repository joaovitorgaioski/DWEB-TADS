<?php

$numeros = [2, 7, 3, 9, 0, 5, 1, -2, -654, 34, 63, 437];

sort($numeros);

foreach ($numeros as $numero) {
    echo $numero . " ";
}