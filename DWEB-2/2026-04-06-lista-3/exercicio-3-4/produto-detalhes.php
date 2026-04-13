<?php

require 'db.php';

$message = "";

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    if (filter_var($id, FILTER_VALIDATE_INT) && $id > 0) {

        if (isset($_COOKIE['historico_vistos'])) {
            $ids = json_decode($_COOKIE['historico_vistos'], true);
        } else {
            $ids = [$id];
        }

        if (!in_array($id, $ids)) {
            $ids[] = $id;
        }

        $ids = array_slice($ids, -4);

        setcookie("historico_vistos", json_encode($ids), time() + (60 * 60 * 24 * 30), "/");

        // Query para o histórico (cookies)
        $placeholder = rtrim(str_repeat('?,', count($ids)), ',');
        $tipos = str_repeat('i', count($ids));

        $sql = "SELECT id, nome, preco FROM tbproduto WHERE id IN ($placeholder)";

        $stm = $conn->prepare($sql);
        $stm->bind_param($tipos, ...$ids);
        $stm->execute();

        $result = $stm->get_result();

        while ($linha = $result->fetch_assoc()) {
            $historico[] = $linha;
        }

        // Query para o produto em específico
        $stm = $conn->prepare("SELECT * FROM tbproduto WHERE id = ?");
        $stm->bind_param("i", $id);
        $stm->execute();

        $result = $stm->get_result();
        $produto = $result->fetch_assoc();

        $stm->close();
        $conn->close();
    } else {
        $message = "Identificador do produto invalidado!";
    }
} else {
    $message = "Nenhum produto encontrado!";
}

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes do Produto</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <?php if ($message != "") : ?>
        <h2><?= htmlspecialchars($message) ?></h2>
    <?php endif ?>

    <?php if (isset($produto)) : ?>
        <h1 style="border: 2px solid black; padding: 10px;"><?php echo htmlspecialchars($produto['nome']) ?></h1>
        <h3><?php echo htmlspecialchars($produto['descricao']) ?></h3>
        <h3 style="color: green;">R$ <?php echo htmlspecialchars($produto['preco']) ?></h3>
    <?php else : echo htmlspecialchars("Produto não existente") ?>
    <?php endif ?>

    <a href="index.php" class="btn">Voltar</a>

    <h2>Visto Recentemente</h2>

    <div class="historico">
        <?php foreach ($historico as $produto): ?>
            <div class="produto">
                <h2><?= htmlspecialchars($produto["nome"]); ?></h2>
                <p>R$ <?= htmlspecialchars($produto["preco"]); ?></p>
            </div>
        <?php endforeach; ?>
    </div>
</body>

</html>