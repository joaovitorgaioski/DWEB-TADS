<?php

require_once "model/Produto.php";
require_once "core/View.php";
require_once "shared/ArquivoCSV.php";
require_once "shared/ArquivoXML.php";

class ProdutoController {
    public function listar() {
        // $produtos = Produto::todos();

        // $lista = ["Farinha", "5kg", "11,30"];
        // ArquivoXML::escrever("listaProdutos.xml", $lista);

        // $produtos = ArquivoCSV::ler("listaProdutos.csv");
        $produtos = ArquivoXML::ler("listaProdutos.xml");

        View::render('produto/lista', ['produtos' => $produtos]);
    }

    public function cadastrar($dados) {
        ArquivoXML::escrever("listaProdutos.xml", $dados);
        View::render("produto/confirmacao", $dados);
    }
}
