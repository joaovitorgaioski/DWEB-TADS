<?php

require_once "model/Produto.php";
require_once "core/View.php";
require_once "shared/ArquivoCSV.php";

class ProdutoController
{
    public function listar()
    {
        // $produtos = Produto::todos();

        $produtos = ArquivoCSV::ler("listaProdutos.csv");

        View::render('produto/lista', ['produtos' => $produtos]);
    }
}
