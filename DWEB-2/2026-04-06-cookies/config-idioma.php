<?php

$idiomaEscolhido = $_POST["idioma"];

if (isset($idiomaEscolhido))
    setcookie("idioma", $idiomaEscolhido, time() + (60 * 5), "/");

header("Location: index.php");
