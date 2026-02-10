<?php

// A leitura é feita por meio de parâmetros na linha de comando
// [0] é o próprio nome do arquivo
$nome = $argv[1];
$sobrenome = $argv[2];

echo $nome . "." . $sobrenome . "@ifpr.edu.br";

?>