<?php

class Compra {
    public $id, $produtos, $usuario;

    public function cadastrar(array $produtos, Usuario $usuario) {
        $this->id = rand(1, 1000);
        $this->produtos = $produtos;
        $this->usuario = $usuario;
    }

    public function imprimir() {
        $result = '<br>Compra: ID: ' . $this->id . '<hr>' . 'Produtos: ';

        // Imprime todos os usuários usando a função 'imprimir' da classe Produto
        foreach($this->produtos as $produto) {
            $result .= $produto->imprimir();
        }

        $result .= $this->usuario->imprimir();

        return $result;
    }
}