<?php

class View
{
    public static function render($view, $dados = [])
    {
        // Extrai os dados
        extract($dados);

        // Inicia um Buffer
        ob_start();
        require "view/$view.php";
        $conteudo = ob_get_clean();

        require "template/Layout.php";
    }
}
