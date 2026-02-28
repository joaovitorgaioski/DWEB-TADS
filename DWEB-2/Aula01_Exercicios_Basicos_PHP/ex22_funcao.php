<?php

function converterReaisParaDolares($valor, $cotacao) {
    return number_format(($valor / $cotacao), 2);
}

echo converterReaisParaDolares(200, 5);