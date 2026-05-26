<?php

require_once "shared/ArquivoXML.php";

$produtoNovo[] = [
    (string) $_POST['nome'],
    (string) $_POST['peso'],
    (string) $_POST['preco']
];

ArquivoXML::escrever("../../listaProdutos.xml", $produtoNovo);

?>

<h3>Produto Cadastrado com Sucesso</h3>

<p>O Produto <strong><?= $_POST['nome'] ?></strong> foi registrado no XML.</p>

<a href="index.php">Voltar</a>