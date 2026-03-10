<?php

function verificarBissexto($ano) {
    return (($ano % 4 == 0 && $ano % 100 != 0) || ($ano % 400 == 0));
}

$ano = $_POST["ano"] ?? 0;

echo verificarBissexto($ano) ? "É bissexto!" : "Não é bissexto!";