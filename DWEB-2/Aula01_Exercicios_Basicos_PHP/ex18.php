<?php

// Array Associativo
$carro = [
    "marca" => "Fiat",
    "modelo" => "Uno Mille",
    "ano" => "2012",
    "cor" => "Branco"
];

echo $carro["marca"]. "\n";
echo $carro["cor"] . "\n\n";

echo $carro["modelo"] . " " . $carro["cor"] . " do ano " . $carro["ano"] . " da marca " . $carro["marca"] . "\n\n";

foreach ($carro as $chave => $valor) {
    echo $chave . " " . $valor . "\n";
}