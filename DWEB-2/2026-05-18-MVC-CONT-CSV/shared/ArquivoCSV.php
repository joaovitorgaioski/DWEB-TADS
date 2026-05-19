<?php

class ArquivoCSV
{

    public static function ler($arquivo)
    {
        $linhaAtual = 1;
        $lista = array();
        // Função para abrir um arquivo. Salvando ele dentro de $handle. Lemos cada linha salvando ela em $data
        if (($handle = fopen($arquivo, 'r')) !== FALSE) {
            while (($data = fgetcsv($handle, 1000, ';')) !== FALSE) {
                if ($linhaAtual > 1) {
                    $qtdColumns = count($data);

                    array_push($lista, $data);
                }

                $linhaAtual++;
            }
            fclose($handle);
        }


        return $lista;
    }

    public static function escrever($arquivo, $dados = [])
    {
        $handle = fopen($arquivo, 'r');

        fputcsv($handle, $dados, ';');

        fclose($handle);
    }
}
