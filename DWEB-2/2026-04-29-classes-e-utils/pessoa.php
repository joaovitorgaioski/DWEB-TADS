<?php

namespace CadastroLojinha;

class Pessoa
{
    private string $nome;
    private int $idade;

    // Construtor
    function __construct(string $nome, int $idade)
    {
        $this->nome = $nome;
        $this->idade = $idade;

        echo "Novo objeto instanciado!";
        echo "<br>Classe: " . __CLASS__;
    }

    function completouAniversario()
    {
        $this->idade++;

        echo "<br>Parabéns, " . $this->nome . " pelos " . $this->idade . " anos de vida!";
    }
}

// Herança
class Funcionario extends Pessoa {}

class Cliente extends Pessoa {}
