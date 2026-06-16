<?php

namespace App\Models;

include __DIR__ . "/../Shared/ArquivoCSV.php";

class LivroModel {
    public function listar() {
        $dados = \ArquivoCSV::ler('../data/livros.csv');
        $livros = array();

        foreach ($dados as $linha) {
            $livro = [
                "id" => $linha[0],
                "titulo" => $linha[1],
                "autor" => $linha[2],
                "categoria" => $linha[3],
                "ano" => $linha[4],
                "paginas" => $linha[5],
            ];

            $livros[] = $livro;
        }

        return $livros;
    }

        public function exibirEstatisticas() {
        $dados = \ArquivoCSV::ler('../data/livros.csv');

        $qtdTotal = 0;
        $livrosPorCategoria = [];
        $mediaPaginas = 0;
        $livroMaisAntigo = null;

        foreach ($dados as $linha) {
            $qtdTotal++;
            $categoria = $linha[3];

            if (!isset($livrosPorCategoria[$categoria])) 
                $livrosPorCategoria[$categoria] = 0;
            
            $livrosPorCategoria[$categoria]++;

            $mediaPaginas += $linha[5];

            if ($livroMaisAntigo === null || $linha[4] < $livroMaisAntigo[4]) {
                $livroMaisAntigo = $linha;
            }
        }

        $mediaFinal = $qtdTotal > 0 ? ($mediaPaginas / $qtdTotal) : 0;

        $estatisticas = [
            'qtdTotal' => $qtdTotal,
            'livrosPorCategoria' => $livrosPorCategoria,
            'mediaPaginas' => $mediaFinal,
            'livroMaisAntigo' => $livroMaisAntigo
        ];

        return $estatisticas;
    }

}
