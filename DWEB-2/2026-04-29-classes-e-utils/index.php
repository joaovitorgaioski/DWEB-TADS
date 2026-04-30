<?php

// Usado para impedir conversão automática de tipos, como somar(10, "10");
declare(strict_types=1);

/*
Importação de variáveis e funções do arquivo matematica.php
    require() -> Para a execução caso não encontre o arquivo
    include() -> Não para, manda um warning
    _once()   -> Requer apenas 1 vez, não permite importar novamente o mesmo arquivo
*/
include_once "matematica.php";

echo "Método somar de outro arquivo: " . somar(22, 5);
// echo somar(10, "10"); Conversão automática permitida, mas o declare() não permite

// Número mágicos. Alguns deles são:
echo "<br>Arquivo: ";
echo __FILE__; // Arquivo atual

echo "<br>Diretório: ";
echo __DIR__; // Diretório atual

echo "<br>Linha do código atual: ";
echo __LINE__; // Linha atual do código

echo "<br><br>";

require_once("pessoa.php");

// Instanciação de uma classe
$joao = new CadastroLojinha\Pessoa("João", 19);
$joao->completouAniversario();
