<?php

require_once "model/Produto.php";
require_once "core/View.php";

class ProdutoController
{
    public function listar()
    {
        $produtos = Produto::todos();

        View::render('produto/lista', ['produtos' => $produtos]);
    }
}
