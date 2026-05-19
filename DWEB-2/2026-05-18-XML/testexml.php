<?php
include 'simplexml-data.php';

$filmes = new SimpleXMLElement($xmlstr);

echo $filmes->filme[0]->resumo;
echo "<hr>";
echo $filmes->filme[0]->personagens->personagem->nome;
