<?php

    require_once "Shared/ArquivoCSV.php";

    class JogoController {

        public function index() {

            $jogos = ArquivoCSV::lerCSV("jogos.csv");

            $totalGols = 0;
            $totalFaltas = 0;
            $totalPublico = 0;

            $timesGols = [];
            $jogosBrasil = [];
            $fases = [];

            $maiorFaltas = 0;
            $jogoMaisFaltas = null;

            $final = null;
            $campeao = '';

            foreach ($jogos as $jogo) {

                $fases[$jogo->fase][] = $jogo;

                if ($jogo->selecao1 == "Brasil" || $jogo->selecao2 == "Brasil") {
                    $jogosBrasil[] = $jogo;
                }

                $totalGols += $jogo->gols1 + $jogo->gols2;

                $timesGols[$jogo->selecao1] = ($timesGols[$jogo->selecao1] ?? 0) + $jogo->gols1;

                $timesGols[$jogo->selecao2] = ($timesGols[$jogo->selecao2] ?? 0) + $jogo->gols2;

                $faltasJogo = $jogo->faltas1 + $jogo->faltas2;
                $totalFaltas += $faltasJogo;

                if ($faltasJogo > $maiorFaltas) {
                    $maiorFaltas = $faltasJogo;
                    $jogoMaisFaltas = $jogo;
                }

                $totalPublico += $jogo->publico;

                if ($jogo->fase == "Final") {
                    $final = $jogo;

                    $campeao = ($jogo->gols1 > $jogo->gols2) ? $jogo->selecao1 : $jogo->selecao2;
                }
            }

            arsort($timesGols);
            $timeMaisGols = array_key_first($timesGols);

            $mediaPublico = $totalPublico / count($jogos);

            require_once "View/jogo/lista.php";
        }
    }
?>