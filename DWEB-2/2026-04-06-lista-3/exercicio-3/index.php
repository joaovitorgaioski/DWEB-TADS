<?php

require 'db.php';

$stm = $conn->prepare("SELECT * FROM tbproduto");

$stm->execute();
$result = $stm->get_result();
$produtos = $result->fetch_all(MYSQLI_ASSOC);

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produtos</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <?php foreach ($produtos as $produto) : ?>
            <div class="produto">
                <h2><?= htmlspecialchars($produto["nome"]); ?></h2>
                <p><?= htmlspecialchars($produto["descricao"]); ?></p>
                <h3>R$ <?= htmlspecialchars($produto["preco"]); ?></h3>
            </div>
        <?php endforeach; ?>
    </div>
</body>

</html>