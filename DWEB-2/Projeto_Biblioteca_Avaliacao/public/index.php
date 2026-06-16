<?php

require '../app/Core/Autoload.php';

use App\Controllers\LivroController;

$controller = new LivroController();
$controller->index();
