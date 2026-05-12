<?php

require_once "model/Cliente.php";
require_once "core/View.php";

class ClienteController
{
    public function listar()
    {
        $clientes = Cliente::todos();

        View::render('cliente/lista', ['clientes' => $clientes]);
    }
}
