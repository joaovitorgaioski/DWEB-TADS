<?php

function avaliarNota($nota) {
    return $nota >= 7.0 ? "Aprovado" : "Reprovado";
}

$estudantes = array(
    array(
        "nome" => "João",
        "nota" => 5
    ),
    array(
        "nome" => "Estevan",
        "nota" => 8
    ),
    array(
        "nome" => "Murilo",
        "nota" => 5.4
    ),
    array(
        "nome" => "Miguel",
        "nota" => 9
    ),
);

foreach ($estudantes as $estudante) {
    echo $estudante["nome"] . " está " . avaliarNota($estudante["nota"]) . "\n";
} 