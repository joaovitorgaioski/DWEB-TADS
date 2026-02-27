<?php

$n = $argv[1] ?? 0; // Coalescência
$r = 1;

if ($n >= 0){
    for ($i = $n; $i > 0; $i--) {
        $r = $i * $r;
    }

    echo "Fatorial de " . $n . " é " . $r;
}
else{
    echo "Insira um número positivo!";
}


?>
