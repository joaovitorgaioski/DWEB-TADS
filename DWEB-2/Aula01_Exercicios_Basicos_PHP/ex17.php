<?php

for ($f = 0; $f <= 150; $f++) {
    echo $f . "° F = " . number_format(((5/9) * ($f-32)), 2) . "° C\n";
}

?>
