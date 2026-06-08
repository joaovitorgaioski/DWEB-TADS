<?php

require "shared/ArquivoCSV.php";
require "core/View.php";

class JogoController
{
    public static function exibirTodos()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");

        View::render("jogos/ListarTodos", ["jogos" => $jogos]);
    }

    public static function exibirBrasil()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");
        $jogosBrasil =  array();

        foreach ($jogos as $jogo) {
            if ($jogo[2] === "Brasil")
                array_push($jogosBrasil, $jogo);
        }

        View::render("jogos/ListarBrasil", ["jogos" => $jogosBrasil]);
    }

    public static function exibirEstatisticasTotais()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");

        $golsPorTime = [];
        $totalGols = 0;
        $totalFaltas = 0;
        $totalPublico = 0;

        foreach ($jogos as $jogo) {
            $totalGols += $jogo[4] + $jogo[5];
            $totalFaltas += $jogo[6] + $jogo[7];
            $totalPublico += $jogo[12];

            $golsPorTime[$jogo[2]] = ($golsPorTime[$jogo[2]] ?? 0) + $jogo[4];
            $golsPorTime[$jogo[3]] = ($golsPorTime[$jogo[3]] ?? 0) + $jogo[5];
        }

        arsort($golsPorTime);

        $timeMaisGols = [
            "time" => array_key_first($golsPorTime),
            "gols" => reset($golsPorTime)
        ];

        $estatisticas = [
            "total-gols" => $totalGols,
            "time-mais-gols" => $timeMaisGols,
            "media-publico" => $totalPublico / count($jogos),
            "total-faltas" => $totalFaltas
        ];

        View::render("jogos/Estatisticas", ["estatisticas" => $estatisticas]);
    }

    public static function exibirClassificacaoFinal()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");

        $campeao = "";
        $vice = "";
        $terceiro = "";
        $quarto = "";

        foreach ($jogos as $jogo) {
            if ($jogo[0] === "Final") {
                if ($jogo[4] > $jogo[5]) {
                    $campeao = $jogo[2];
                    $vice = $jogo[3];
                } else {
                    $campeao = $jogo[3];
                    $vice = $jogo[2];
                }
            }

            if ($jogo[0] === "3º Lugar") {

                if ($jogo[4] > $jogo[5]) {
                    $terceiro = $jogo[2];
                    $quarto = $jogo[3];
                } else {
                    $terceiro = $jogo[3];
                    $quarto = $jogo[2];
                }
            }
        }

        $classificacao = [
            "campeao" => $campeao,
            "vice" => $vice,
            "terceiro" => $terceiro,
            "quarto" => $quarto
        ];

        View::render("jogos/Classificacao", ["classificacao" => $classificacao]);
    }

    public static function exibirFinal()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");

        $final = [];

        foreach ($jogos as $jogo)
            if ($jogo[0] === "Final")
                $final = $jogo;

        View::render("jogos/Final", ["jogo" => $final]);
    }

    public static function exibirJogosMaisFaltas()
    {
        $jogos = ArquivoCSV::ler("jogos.csv");

        $maiorQtdFaltas = 0;
        $jogosMaisFaltas = [];

        foreach ($jogos as $jogo) {
            $faltas = $jogo[6] + $jogo[7];

            if ($faltas > $maiorQtdFaltas) {
                $maiorQtdFaltas = $faltas;
                $jogosMaisFaltas = [$jogo];
            } elseif ($faltas === $maiorQtdFaltas) {
                $jogosMaisFaltas[] = $jogo;
            }
        }

        View::render("jogos/JogosMaisFaltas", ["jogos" => $jogosMaisFaltas, "faltas" => $maiorQtdFaltas]);
    }
}
