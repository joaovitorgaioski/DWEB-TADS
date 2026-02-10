<?php

$notas = [$argv[1], $argv[2], $argv[3]];
$media = 0;

for ($i = 0; $i < 3; $i++){
    $media = $notas[$i] + $media;
}

$media = $media / 3;
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