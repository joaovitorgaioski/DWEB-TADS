<?php

require "controller/ProdutoController.php";
require "controller/ClienteController.php";

$pController = new ProdutoController();
$pController->listar();

$cController = new ClienteController();
$cController->listar();
