<?php

require_once 'db-connection.php';

$pedidos = [];
$message = '';

if (isset($_GET['message'])) {
    $message = htmlspecialchars($_GET['message']);
}

$sql = "SELECT id, data_pedido, cliente_nome, total FROM pedidos";

// Consulta passando o SQL
$result = $conn->query($sql);

if ($result) {
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $pedidos[] = $row;
        }
    }
} else {
    echo "Erro ao carregar pedidos: " . $conn->error;
}

$conn->close();

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Lista de Pedidos</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <a href="create.php" class="add-button">Adicionar Novo Pedido</a>

        <?php if (empty($pedidos)) : ?>
            <p>Nenhum pedido encontrado.</p>
        <?php else: ?>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Data</th>
                    <th>Cliente</th>
                    <th>Total</th>
                    <th>Ações</th>
                </tr>

                <?php foreach ($pedidos as $pedido) : ?>
                    <tr>
                        <td><?php echo htmlspecialchars($pedido["id"]); ?></td>
                        <td><?php echo htmlspecialchars($pedido["data_pedido"]); ?></td>
                        <td><?php echo htmlspecialchars($pedido["cliente_nome"]); ?></td>
                        <td>R$<?php echo htmlspecialchars($pedido["total"]); ?></td>
                        <td>
                            <a href="details.php?id=<?php echo htmlspecialchars($pedido["id"]); ?>">Detalhes</a>
                            <a href="update.php?id=<?php echo htmlspecialchars($pedido["id"]); ?>">Editar Cliente</a>
                            <a href="delete.php?id=<?php echo htmlspecialchars($pedido["id"]); ?>" onclick="return confirm('Têm certeza que deseja excluir esse pedido?');">Excluir</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </table>
        <?php endif; ?>
    </div>
</body>

</html>