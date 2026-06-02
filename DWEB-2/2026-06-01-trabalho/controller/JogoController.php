<?php

require "shared/ArquivoCSV.php";
require "core/View.php";

class JogoController
{
    public static function exibirTodos()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");
        
        View::render("jogos/Listar", ["jogos" => $jogos]);
    }
}
