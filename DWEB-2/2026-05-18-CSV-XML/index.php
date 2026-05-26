<?php

/*
require "controller/ProdutoController.php";

$controller = new ProdutoController();
$controller->listar();
*/

require "core/View.php";
require "controller/ProdutoController.php";

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $produtoNovo[] = [
        (string) $_POST['nome'],
        (string) $_POST['peso'],
        (string) $_POST['preco']
    ];

    $controller = new ProdutoController();

    $controller->cadastrar($produtoNovo);
} else {
    View::render("produto/formulario", []);
}
