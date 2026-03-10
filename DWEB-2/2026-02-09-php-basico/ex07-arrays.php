<?php
// Vetores numéricos ou indexados

$frutas = ["Maça", "Uva"];
echo $frutas[0];

// Adiciona um elemento ao final do Array (2 jeitos)
$frutas[] = "Pera";
array_push($frutas, "Banana", "Melão");

// Adicionando ao início
array_unshift($frutas, "Ameixa", "Pêssego");

// Remove o último
array_pop($frutas);

// Remove a primeira
array_shift($frutas);

var_dump($frutas);

?>