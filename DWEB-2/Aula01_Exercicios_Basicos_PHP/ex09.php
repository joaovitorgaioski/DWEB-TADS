<?php

$n = $argv[1];

for ($i = 0; $i < 10; $i++){
    if($i % 2 != 0){
        echo $n . " x " . $i . " = " . $n * $i . "\n";
    }
}

?>