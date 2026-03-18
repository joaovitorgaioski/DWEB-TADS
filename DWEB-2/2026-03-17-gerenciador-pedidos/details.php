<?php

require_once 'db-connection.php';

$message = '';
$itens_pedido = [];
$total = 0;

// Obter os valores de itens_pedido
if (isset($_GET['id'])) {
    $pedido_id = $_GET['id'];

    $stm = $conn->prepare("SELECT * FROM itens_pedido WHERE pedido_id = ?");

    if ($stm == false) {
        $message = 'Erro na preparação da query: ' . $conn->error;
    } else {
        $stm->bind_param("i", $pedido_id);
        $stm->execute();
        $result = $stm->get_result();

        if ($result) {
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    $itens_pedido[] = $row;
                    $total += $row['quantidade'] * $row['preco_unitario'];
                }
            }
        } else {
            echo "Erro ao carregar pedidos: " . $conn->error;
        }
    }
    $stm->close();
} else {
    $message = 'ID para obter de itens_pedido não fornecido.';
}

// Adicionar item ao pedido
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $produto_nome = $_POST['produto_nome'];
    $quantidade = $_POST['quantidade'];
    $preco_unitario = $_POST['preco_unitario'];
    $pedido_id = $_POST['pedido_id'];

    if (empty($produto_nome) || empty($quantidade) || empty($preco_unitario)) {
        $message = "Por favor, preencha todos os campos.";
    } else {
        // Colocar o pedido_id
        $stm = $conn->prepare("INSERT INTO itens_pedido (produto_nome, quantidade, preco_unitario, pedido_id) VALUES (?, ?, ?, ?)");
        if ($stm == false) {
            $message = "Erro no statement." . $conn->error;
        } else {
            $stm->bind_param("sidi", $produto_nome, $quantidade, $preco_unitario, $pedido_id);
            if ($stm->execute()) {
                $message = "Item adicionado com sucesso.";
            } else {
                if ($conn->errno == 1062) {
                    $message = "Este item já está cadastrado.";
                } else {
                    $message = "Erro ao adicionar o item." . $stm->error;
                }
            }

            $stm->close();
        }
    }
    header("location:details.php?id=" . $pedido_id);
}

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes do Pedido</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <h2>Adicionar Item ao Pedido</h2>

        <form method="POST" style="display: flex; flex-direction: column; gap: 5px;">
            <input type="hidden" name="pedido_id" value="<?php echo htmlspecialchars($pedido_id) ?>">

            <label for="produto_nome">Nome do Produto</label>
            <input type="text" id="produto_nome" name="produto_nome" require placeholder="Digite o nome do produto">

            <label for="quantidade">Quantidade</label>
            <input type="number" id="quantidade" name="quantidade" require placeholder="Quantidade do produto">

            <label for="preco_unitario">Preço Unitario</label>
            <input type="number" id="preco_unitario" name="preco_unitario" require placeholder="Preço por unidade">

            <input type="submit" value="Adicionar Novo Item">
        </form>

        <hr>

        <h2>Total da Compra</h2>
        <h3>R$ <?php echo htmlspecialchars($total) ?></h3>

        <hr>

        <h2>Itens</h2>

        <?php if ($itens_pedido) : ?>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome do Produto</th>
                    <th>Quantidade</th>
                    <th>Preço Unitário</th>
                    <th>Total desse Item</th>
                    <th>Ações</th>
                </tr>

                <?php foreach ($itens_pedido as $item) : ?>
                    <tr>
                        <td><?php echo htmlspecialchars($item["id"]); ?></td>
                        <td><?php echo htmlspecialchars($item["produto_nome"]); ?></td>
                        <td><?php echo htmlspecialchars($item["quantidade"]); ?></td>
                        <td>R$<?php echo htmlspecialchars($item["preco_unitario"]); ?></td>
                        <td>R$<?php echo htmlspecialchars($item["preco_unitario"] * $item['quantidade']); ?></td>
                        <td>
                            <a href="delete-item.php?pedido_id=<?php echo htmlspecialchars($pedido_id) ?>&id=<?php echo htmlspecialchars($item["id"]); ?>"
                                onclick="return confirm('Têm certeza que deseja excluir esse item?');">Remover</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </table>
        <?php else: ?>
            <p>Não há nenhum item cadastrado ainda.</p>
        <?php endif; ?>

        <p><a href="index.php">Voltar para a lista de pedidos</a></p>
    </div>
</body>

</html>