<h2>Jogos do Brasil</h2>

<?php

if (isset($jogos)) {
    echo '<div class="jogos-brasil">';

    foreach ($jogos as $jogo) {
        include "Partida.php";
    }

    echo '</div>';
} else {
    echo "<h3>Nenhum jogo encontrado!</h3>";
}

?>