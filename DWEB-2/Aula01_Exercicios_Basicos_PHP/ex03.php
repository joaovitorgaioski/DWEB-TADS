<?php

$n1 = $argv[1];
$n2 = $argv[2];

echo "Soma: " . $n1 + $n2;
echo "\nSubtração: " . $n1 - $n2;
echo "\nMultiplicação: " . $n1 * $n2;
echo "\nDivisão: " . ($n2!=0 ? $n1 / $n2 : "Erro: Divisão por 0!");

?>
