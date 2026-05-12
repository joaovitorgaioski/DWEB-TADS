<h2>Lista de Clientes</h2>
<ul>
    <?php foreach ($clientes as $c): ?>
        <li><?= htmlspecialchars($c['nome']) ?> - CPF: <?= $c['cpf'] ?></li>
    <?php endforeach ?>
</ul>