<h2>Final</h2>

<?php

if (isset($jogo)) {

    echo '<div class="final">';
    
    include 'Partida.php';
    echo '<h1 class="placar">Viva o ' . (($jogo[4] > $jogo[5]) ? $jogo[2] : $jogo[3]) . '!</h1>';

    echo '</div>';
} else {
    echo "<h3>Final não encontrada!</h3>";
}

?>