<?php

// Namespace servem para organizar arquivos, de forma que a organização é feita através deles ao invés de somente diretórios
namespace LojinhaDoJoao;

function vender() {
    echo "<br> Código que faz a venda!";
}

function addCarrinho() {
    echo "<br> Código que adiciona no carrinho!";
}

function listarCarrinho() {
    echo "<br> Código lista os itens do carrinho!";
}

listarCarrinho();

include_once("pessoa.php");

$joao = new \CadastroLojinha\pessoa("João", 19);
