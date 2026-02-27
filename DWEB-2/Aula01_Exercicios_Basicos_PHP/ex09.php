<?php

$n = $argv[1] ?? 1;

for ($i = 1; $i < 10; $i = $i + 2){    
    echo $n . " x " . $i . " = " . $n * $i . "\n";
}

?>
