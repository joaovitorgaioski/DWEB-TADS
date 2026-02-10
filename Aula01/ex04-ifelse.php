<?php

$hora = $argv[1];
echo "Agora são " . $hora . "hrs.\n";

if ($hora < 12){
    echo "Bom dia!";
}elseif($hora < 18) {
    echo "Boa tarde!";
}else {
    echo "Boa noite!";
}

?>