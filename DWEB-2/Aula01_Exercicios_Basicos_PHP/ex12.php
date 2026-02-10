<?php

$idade = $argv[1];

if (($idade >= 16 && $idade < 18) || $idade > 65) {
    echo "Eleitor Facultativo!";
}
elseif ($idade < 16) {
    echo "Não Eleitor!";
}
else {
    echo "Eleitor Obrigatório!";
}

?>