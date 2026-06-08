<?php

class ArquivoCSV
{

    public static function ler($arquivo)
    {
        $row = 1;
        $lista = array();

        if (($handle = fopen($arquivo, 'r')) !== FALSE) {

            while (($data = fgetcsv($handle, 1000, ',')) !== FALSE) {
                if ($row != 1) array_push($lista, $data);
                $row++;
            }
            fclose($handle);
        }

        return $lista;
    }
}
