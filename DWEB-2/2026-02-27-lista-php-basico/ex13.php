<?php

$idade = $argv[1] ?? 15;
$anos = $argv[2] ?? 0;

echo "Idade: " . $idade . "\nContribuiu por: " . $anos . " anos.\n";

if ($idade > 65 || $anos > 30 || ($idade > 60 && $anos > 25)){
    echo "Requerer Aposentadoria.";
}
else{
    echo "Não Requerer.";
}

?>
