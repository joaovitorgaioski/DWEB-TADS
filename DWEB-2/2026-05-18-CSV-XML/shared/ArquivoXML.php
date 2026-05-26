<?php

class ArquivoXML {
    public static function ler($arquivo) {
        $xml = simplexml_load_file($arquivo);

        $lista = [];

        foreach ($xml->produto as $produto) {
            $lista[] = [
                (string) $produto->nome,
                (string) $produto->peso,
                (string) $produto->preco
            ];
        }

        return $lista;
    }

    public static function escrever($arquivo, $dados = []) {
        if (!empty($dados) && isset($dados) && !is_array($dados[0])) {
            $dados = [$dados];
        }

        if (file_exists($arquivo)) {
            $xml = simplexml_load_file($arquivo);
        } else {
            $xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><lista></lista>');
        }

        foreach ($dados as $item) {
            $produto = $xml->addChild('produto');
            $produto->addChild('nome', htmlspecialchars($item[0]) ?? "Nome não definido");
            $produto->addChild('peso', htmlspecialchars($item[1]) ?? 0);
            $produto->addChild('preco', htmlspecialchars($item[2]) ?? 0);
        }

        $xml->asXML($arquivo);
    }
}
