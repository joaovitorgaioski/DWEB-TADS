<?php

class Produto {
    public $id, $descricao;

    public function cadastrar($id, $descricao) {
        $this->id = $id;
        $this->descricao = $descricao;
    }

    public function imprimir() {
        $result = '<br>Produto: ID: ' . $this->id . ' | ' . 'Descrição: ' . $this->descricao;

        return $result;
    }
}
