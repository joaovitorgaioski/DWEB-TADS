<?php

/*
include_once "Sistema/Vendas/Compra.php";
include_once "Sistema/Vendas/Produto.php";
include_once "Sistema/Vendas/Usuario.php";
*/

// Substituimos tudo pelo autoload
require_once 'autoload.php';

$u1 = new Usuario();
$u1->cadastrar("João", 20);

$p1 = new Produto();
$p1->cadastrar(10, "Sabão em Pó");

$p2 = new Produto();
$p2->cadastrar(20, "Arroz");

$c = new Compra();
$c->cadastrar(array($p1, $p2), $u1);

echo $c->imprimir();
