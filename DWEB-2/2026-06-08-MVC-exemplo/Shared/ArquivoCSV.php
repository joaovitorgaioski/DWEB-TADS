<?php

    require_once "Model/Jogo.php";

    class ArquivoCSV {

        public static function lerCSV($arquivo) {

            $jogos = [];

            if (($handle = fopen($arquivo, "r")) !== false) {

                fgetcsv($handle, 1000, ",");

                while (($dados = fgetcsv($handle, 1000, ",")) !== false) {
                    $jogos[] = new Jogo($dados);
                }

                fclose($handle);
            }
            return $jogos;
        }

    }

?>