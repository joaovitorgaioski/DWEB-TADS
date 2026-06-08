<h2>Estatísticas Totais da Competição</h2>

<div class="estatisticas">
    <div class="card">
        <h3>⚽ Quantidade total de gols</h3>
        <p><?= $estatisticas["total-gols"] ?></p>
    </div>

    <div class="card">
        <h3>🔥 Time que mais goleou</h3>
        <p><?= $estatisticas["time-mais-gols"]["time"] ?> (<?= $estatisticas["time-mais-gols"]["gols"] ?> gols)</p>
    </div>

    <div class="card">
        <h3>👥 Média de público</h3>
        <p><?= $estatisticas["media-publico"] ?></p>
    </div>

    <div class="card">
        <h3>🟨 Quantidade total de faltas</h3>
        <p><?= $estatisticas["total-faltas"] ?></p>
    </div>
</div>