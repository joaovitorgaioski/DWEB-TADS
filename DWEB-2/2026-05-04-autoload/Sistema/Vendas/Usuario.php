<?php

class Usuario {
    public $nome, $idade;

    public function cadastrar($nome, $idade) {
        $this->nome = $nome;
        $this->idade = $idade;
    }

    public function imprimir() {
        $result = '<hr>Usuario: <br>Nome: ' . $this->nome . ' | ' . 'Idade: ' . $this->idade;

        return $result;
    }
}
