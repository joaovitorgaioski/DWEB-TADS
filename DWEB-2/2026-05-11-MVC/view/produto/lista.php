<h2>Lista de Produtos</h2>
<ul>
    <?php foreach ($produtos as $p): ?>
        <li><?= htmlspecialchars($p['nome']) ?> - R$ <?= number_format($p['preco'], 2, ',', '.'); ?></li>
    <?php endforeach ?>
</ul>