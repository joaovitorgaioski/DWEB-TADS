<?php

session_start();

require 'db.php';

$message = "";
$itens = [];
$total = 0;

if (isset($_POST['limpar_carrinho']) && $_POST['limpar_carrinho'] == 1)
    unset($_SESSION['carrinho']);

if (isset($_SESSION['carrinho']) && $_SESSION['carrinho'] != []) {
    $idItens = $_SESSION['carrinho'];
    $placeholder = rtrim(str_repeat('?,', count($idItens)), ',');
    $tipos = str_repeat('i', count($idItens));

    $stm = $conn->prepare("SELECT * FROM tbproduto WHERE id IN ($placeholder)");

    $stm->bind_param($tipos, ...$idItens);
    $stm->execute();
    $result = $stm->get_result();

    while ($linha = $result->fetch_assoc()) {
        $itens[] = $linha;
    }

    $stm->close();
    $conn->close();

    $separaPorQuantidade = array_count_values($idItens); // Quantidade de cada id no array
} else {
    $message = "Nenhum item no carrinho!";
}

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrinho</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <?php if ($message != "") : ?>
        <h2><?= htmlspecialchars($message) ?></h2>
    <?php endif ?>

    <div>
        <table>
            <tr>
                <th>Nome</th>
                <th>Preço</th>
                <th>Quantidade</th>
            </tr>

            <?php foreach ($itens as $item):
                $qtd = $separaPorQuantidade[$item['id']];
                $total += $item["preco"] * $qtd;
            ?>
                <tr>
                    <td><?= htmlspecialchars($item["nome"]); ?></td>
                    <td>R$ <?= htmlspecialchars($item["preco"]); ?></td>
                    <td><?= $qtd ?></td>
                </tr>
            <?php endforeach; ?>
        </table>

        <h3>Total: R$ <?= htmlspecialchars($total) ?></h3>
    </div>

    <form method="POST">
        <input type="hidden" name="limpar_carrinho" value="1">
        <input type="submit" value="Limpar Carrinho" class="btn">
    </form>

    <a href="index.php" class="btn">Voltar</a>
</body>

</html>