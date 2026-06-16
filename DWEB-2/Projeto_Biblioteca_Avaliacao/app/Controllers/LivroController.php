<?php
namespace App\Controllers;

use App\Models\LivroModel;

class LivroController
{
    public function index()
    {
        $model = new LivroModel();
        $livros = $model->listar();
        $estatisticas = $model->exibirEstatisticas();

        require __DIR__ . '/../Views/listaLivros.php';
        require __DIR__ . '/../Views/estatisticas.php';
    }
}
