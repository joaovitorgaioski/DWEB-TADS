<h2>Estatísticas</h2>

<h3>Quantidade Total de Livros: <?= $estatisticas['qtdTotal'] ?></h3>

<h3>Quantidade por Categoria:</h3>
<ul>
    <?php foreach ($estatisticas['livrosPorCategoria'] as $categoria => $quantidade): ?>
        <li><strong><?= htmlspecialchars($categoria) ?>:</strong> <?= $quantidade ?></li>
    <?php endforeach; ?>
</ul>

<h3>Quantidade média de páginas: <?= $estatisticas['mediaPaginas'] ?></h3>

<h3>Livro mais antigo:</h3>
<p>
    "<?= htmlspecialchars($estatisticas['livroMaisAntigo'][1]) ?>"
    (Autor: <?= htmlspecialchars($estatisticas['livroMaisAntigo'][2]) ?> - Ano: <?= $estatisticas['livroMaisAntigo'][4] ?>)
</p>