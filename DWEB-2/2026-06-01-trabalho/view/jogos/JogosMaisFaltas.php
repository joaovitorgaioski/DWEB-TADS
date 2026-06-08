<h2>Jogos com Maior Número de Faltas</h2>


<div class="jogos mais-faltas">

    <h3>Foi um total de <?= $faltas ?> acidentes!</h3>

    <?php
    foreach ($jogos as $jogo)
        include "Partida.php";
    ?>
</div>