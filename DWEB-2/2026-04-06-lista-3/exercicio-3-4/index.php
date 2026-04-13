<?php

session_start();

require 'db.php';

$produtos = [];

$stm = $conn->prepare("SELECT * FROM tbproduto");

$stm->execute();
$result = $stm->get_result();

// fetch_assoc() retorna linha a linha
while ($linha = $result->fetch_assoc()) {
    $produtos[] = $linha;
}

if (!isset($_SESSION['carrinho']))
    $_SESSION['carrinho'] = array();

if (isset($_POST['id'])) {
    array_push($_SESSION['carrinho'], $_POST['id']);
    header("Location: index.php");
}

$qtdCarrinho = count($_SESSION['carrinho']);

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

    <div class="produtos">
        <?php foreach ($produtos as $produto): ?>
            <div class="produto">
                <h2><?= htmlspecialchars($produto["nome"]); ?></h2>
                <p><?= htmlspecialchars($produto["descricao"]); ?></p>
                <h3>R$ <?= htmlspecialchars($produto["preco"]); ?></h3>
                <a href="produto-detalhes.php?id=<?php echo htmlspecialchars($produto['id']); ?>">
                    Detalhes
                </a>
                <form method="POST">
                    <input type="hidden" name="id" value="<?= $produto['id'] ?>">
                    <input type="submit" value="Adicionar ao Carrinho">
                </form>
            </div>
        <?php endforeach; ?>
    </div>

    <a href="carrinho.php" class="btn">
        <h3>
            Carrinho de Compras
            <br>
            <?= $qtdCarrinho ?> Itens
        </h3>
    </a>

</body>

</html>