<h2>Lista de Produtos</h2>
<ul>
    <?php foreach ($produtos as $p): ?>
        <li>
            <?= htmlspecialchars($p[0]) ?>
            - <?= htmlspecialchars($p[1]) ?>
            - R$ <?= htmlspecialchars($p[2]) ?>
        </li>
    <?php endforeach ?>
</ul>