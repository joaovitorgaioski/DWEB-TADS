<?php

$nome = $argv[1] ?? "";

$contatos = array(
    "João" => [
        "email" => 'joao.joao@vitor.com',
        "telefone" => '42999999999'
    ],
    "Estevan" => [
        "email" => 'estevan.estevan@gabriel.com',
        "telefone" => '42888888888'
    ],
    "Miguel" => [
        "email" => 'miguel.miguel@matheus.com',
        "telefone" => '42777777777'
    ],
    "Murilo" => [
        "email" => 'murilo.murilo@mirlo.com',
        "telefone" => '42666666666'
    ]
);


function obterEmail($contatos, $nome) {
    return $contatos[$nome]["email"] ?? "Desconhecido";
}

echo obterEmail($contatos, $nome);