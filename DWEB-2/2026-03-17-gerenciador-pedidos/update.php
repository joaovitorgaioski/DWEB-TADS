<?php

require_once 'db-connection.php';

$message = '';
$pedido = null;

// GET para obtenção dos valores do pedido salvando eles em $pedido
// Verificando existência de id
if (isset($_GET['id'])) {
    $id = $_GET['id'];

    $stm = $conn->prepare("SELECT id, data_pedido, cliente_nome, total FROM pedidos WHERE id = ?");

    // Quando o $stm da erro
    if ($stm == false) {
        $message = 'Erro na preparação da query: ' . $conn->error;
    } else {
        // Execução do $stm e obtenção dos resultados
        $stm->bind_param("i", $id);
        $stm->execute();
        $result = $stm->get_result();

        // Colocando o $result da query em $pedido
        $pedido = $result->fetch_assoc();

        // Agora verificações caso não haja pedidos setados
        if (!$pedido) {
            $message = 'Pedido não encontrado.';
        }
    }
} else {
    $message = 'ID do pedido não fornecido';
}

// POST para realizar update desse pedido
if ($_SERVER['REQUEST_METHOD'] === 'POST' && $pedido) {
    $id = $_POST['id'];
    $cliente_nome = $_POST['cliente_nome'];
    
    // Validação básica
    if (empty($cliente_nome)) {
        $message = 'Por favor, preencha todos os campos.';
    }
    // Passou? -> Então podemos fazer o update no banco
    else {
        $stm = $conn->prepare("UPDATE pedidos SET cliente_nome = ? WHERE id = ?");

        // Quando o $stm da erro
        if ($stm == false) {
            $message = 'Erro na preparação da query.' . $conn->error;
        } else {
            // bind_param é quem de fato garante que não haja SQL injection
            $stm->bind_param("si", $cliente_nome, $id);

            // Caso de bom
            if ($stm->execute()) {
                $message = 'Pedido atualizado com sucesso.';
                $pedido['cliente_nome'] = $cliente_nome;
            } else {
                if ($conn->errno == 1062) {
                    $message = 'Esta pedido já está cadastrado.';
                } else {
                    $message = 'Erro ao editar o pedido.' . $conn->error;
                }
            }
        }
    }
}

$stm->close();

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atualizar Pedido</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Editar Nome do Cliente</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <?php if ($pedido) : ?>
            <form method="POST">
                <input type="hidden" name="id" value="<?php echo htmlspecialchars($pedido['id']) ?>">

                <label for="cliente_nome">Nome do cliente</label>
                <input type="text" id="cliente_nome" name="cliente_nome" require value="<?php echo htmlspecialchars($pedido['cliente_nome']) ?>">

                <input type="submit" value="Editar cliente">
            </form>
        <?php else: ?>
            <p><?php echo $message ?></p>
        <?php endif; ?>

        <p><a href="index.php">Voltar para a lista de pedidos</a></p>
    </div>
</body>

</html>