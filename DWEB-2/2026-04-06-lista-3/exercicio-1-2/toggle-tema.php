<?php 

$tema = $_POST["tema"];

if (isset($tema))
    setcookie("tema", $tema, time() + (60 * 5), "/");

header("Location: painel.php");

?>
