<?php

function calcularDesconto ($valor, $desconto) {
    return $desconto ? $valor * (1 - ($desconto / 100)) : $valor * 0.95;
}

echo calcularDesconto(55, 20);