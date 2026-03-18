<?php

require_once 'db-connection.php';
$message = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $cliente_nome = $_POST['cliente_nome'];

    if (empty($cliente_nome)) {
        $message = "Por favor, preencha todos os campos.";
    } else {
        // Criar um Prepared Statement para evitar SQL injection
        $stm = $conn->prepare("INSERT INTO pedidos (cliente_nome) VALUES (?)");
        if ($stm == false) {
            $message = "Erro na preparação da query." . $conn->error;
        } else {
            $stm->bind_param("s", $cliente_nome); //s é o tipo de dado dos parâmetros
            if ($stm->execute()) {
                $message = "Pedido adicionado com sucesso.";
            } else {
                if ($conn->errno == 1062) { // Erro de entrada duplicada
                    $message = "Esta pedido já está cadastrado.";
                } else {
                    $message = "Erro ao adicionar o pedido." . $stm->error;
                }
            }

            $stm->close();
        }
    }
}

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Pedido</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Iniciar Novo pedido</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <form method="POST">
            <label for="cliente_nome">Nome do Cliente</label>
            <input type="text" id="cliente_nome" name="cliente_nome" require placeholder="Digite o nome do cliente">

            <input type="submit" value="Adicionar Novo Pedido">
        </form>

        <p><a href="index.php">Voltar para a lista de pedidos</a></p>
    </div>
</body>

</html>