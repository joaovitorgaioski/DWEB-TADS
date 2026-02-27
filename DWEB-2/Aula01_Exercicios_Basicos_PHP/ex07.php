<?php

$notas = [$argv[1] ?? 0, $argv[2] ?? 0, $argv[3] ?? 0];

$media = ($notas[0] + $notas[1] + $notas[2]) / 3;

echo "Média das notas: " . $media . "\n";

if($media >= 7){
    echo "Aprovado!";
}
elseif($media >= 5 && $media < 7){
    echo "Recuperação!";
}
else{
    echo "Reprovado!";
}

?>
