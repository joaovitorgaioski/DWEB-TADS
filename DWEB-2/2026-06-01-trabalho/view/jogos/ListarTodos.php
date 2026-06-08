<h2>Lista de Todos os Jogos</h2>

<?php

if (isset($jogos)) {
    $faseAnterior = null;
    $faseAtual = 1;

    foreach ($jogos as $jogo) {
        $fase = $jogo[0];

        if ($fase !== $faseAnterior) {

            if ($faseAnterior !== null) {
                echo '</div>';
                echo '</div>';
            }

            echo '<div class="fase fase' . $faseAtual . '">';
            echo '<h3>' . $fase . '</h3>';
            echo '<div class="jogos">';

            $faseAtual++;
            $faseAnterior = $fase;
        }

        include "Partida.php";
    }

    echo '</div></div>';
} else {
    echo "<h3>Nenhum jogo encontrado!</h3>";
}

?>