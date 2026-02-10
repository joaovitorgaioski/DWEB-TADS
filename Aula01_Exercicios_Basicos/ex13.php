<?php

$idade = $argv[1];
$anos = $argv[2];

echo "Idade: " . $idade . "\nContribuiu por: " . $anos . " anos.\n";

if ($idade > 65 || $anos > 30 || ($idade > 60 && $anos > 25)){
    echo "Requerer Aposentadoria.";
}
else{
    echo "Não Requerer.";
}

?>