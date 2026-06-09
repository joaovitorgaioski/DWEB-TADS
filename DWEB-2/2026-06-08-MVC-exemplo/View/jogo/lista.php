<?php ob_start(); ?>

<h1 class="titulo">
    Copa do Mundo
</h1>

<div class="card">

    <h2>Jogos por Fase</h2>

    <?php foreach ($fases as $fase => $lista): ?>

        <h3 class="fase">
            <?= $fase ?>
        </h3>

        <?php foreach ($lista as $jogo): ?>

            <div class="jogo">

                <?= $jogo->selecao1 ?>

                <strong>
                    <?= $jogo->gols1 ?>
                </strong>

                x

                <strong>
                    <?= $jogo->gols2 ?>
                </strong>

                <?= $jogo->selecao2 ?>

            </div>

        <?php endforeach; ?>

    <?php endforeach; ?>

</div>

<div class="card">

    <h2>Resultados do Brasil</h2>

    <?php foreach ($jogosBrasil as $jogo): ?>

        <div class="jogo">

            <?= $jogo->selecao1 ?>
            <strong><?= $jogo->gols1 ?></strong>

            x

            <strong><?= $jogo->gols2 ?></strong>
            <?= $jogo->selecao2 ?>

        </div>

    <?php endforeach; ?>

</div>

<div class="card estatisticas">

    <h2>Estatísticas</h2>

    <ul>
        <li>
            <strong>Total de gols:</strong>
            <?= $totalGols ?>
        </li>

        <li>
            <strong>Time com mais gols:</strong>
            <?= $timeMaisGols ?>
        </li>

        <li>
            <strong>Média de público:</strong>
            <?= number_format($mediaPublico, 0, ',', '.') ?>
        </li>

        <li>
            <strong>Total de faltas:</strong>
            <?= $totalFaltas ?>
        </li>
    </ul>

</div>

<div class="card">

    <h2>Jogo com Mais Faltas</h2>

    <p>
        <?= $jogoMaisFaltas->selecao1 ?>
        <?= $jogoMaisFaltas->gols1 ?>

        x

        <?= $jogoMaisFaltas->gols2 ?>
        <?= $jogoMaisFaltas->selecao2 ?>
    </p>

</div>

<div class="card final">

    <h2>FINAL</h2>

    <h3>
        <?= $final->selecao1 ?>
        <?= $final->gols1 ?>

        x

        <?= $final->gols2 ?>
        <?= $final->selecao2 ?>
    </h3>

    <h4>Faltas</h4>

    <p>
        <?= $final->selecao1 ?>:
        <?= $final->faltas1 ?>
    </p>

    <p>
        <?= $final->selecao2 ?>:
        <?= $final->faltas2 ?>
    </p>

    <h4>Cartões Amarelos</h4>

    <p>
        <?= $final->selecao1 ?>:
        <?= $final->cartoes_amarelos1 ?>
    </p>

    <p>
        <?= $final->selecao2 ?>:
        <?= $final->cartoes_amarelos2 ?>
    </p>

    <h4>Público</h4>

    <p>
        <?= number_format($final->publico, 0, ',', '.') ?>
    </p>

</div>

<div class="campeao">
    CAMPEÃO: <?= $campeao ?>
</div>

<?php
$conteudo = ob_get_clean();
require_once "Template/Layout.php";
?>