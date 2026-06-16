<?php

class ArquivoCSV {

    public static function ler($arquivo) {
        $linhaAtual = 1;
        $lista = array();
        if (($handle = fopen($arquivo, 'r')) !== FALSE) {
            while (($data = fgetcsv($handle, 1000, ';')) !== FALSE) {
                if ($linhaAtual > 1)
                    array_push($lista, $data);

                $linhaAtual++;
            }
            fclose($handle);
        }


        return $lista;
    }
}
