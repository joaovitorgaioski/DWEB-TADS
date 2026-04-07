<?php 

// Apagando o valor do cookie para então apagá-lo.
setcookie("idioma", "", time() - 1000, "/");

?>