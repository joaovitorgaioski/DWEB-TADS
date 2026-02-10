<?php

$nota = $argv[1];

if ($nota > 0 && $nota < 60) {
    echo "D";
}
elseif ($nota >= 60 && $nota < 80){
    echo "C";
}
elseif ($nota >= 80 && $nota < 90){
    echo "B";
}
elseif ($nota >= 90 && $nota <= 100){
    echo "A";
}
else{
    echo "Nota inváida!";
}

?>