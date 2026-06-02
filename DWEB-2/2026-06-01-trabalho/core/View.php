<?php

class View {
    public static function render($view, $dados = []) {
        extract($dados);

        ob_start();
        require "view/$view.php";
        $conteudo = ob_get_clean();

        require "index.php";
    }
}
