<?php

require_once 'db-connection.php';

if (isset($_GET['id'])) {
    $id = $_GET['id'];
    $pedido_id = $_GET['pedido_id'];

    $stm = $conn->prepare("DELETE FROM itens_pedido WHERE id = ?");
    if ($stm === false) {
        header("Location: details.php?id=" . $pedido_id . "&message=" . urlencode('Erro na preparação da query: ' . $conn->error));
        exit();
    } else {
        $stm->bind_param("i", $id);
        if ($stm->execute()) {
            header("Location: details.php?id=" . $pedido_id . "&message=" . urlencode('Item excluido com sucesso.'));
            exit();
        } else {
            header("Location: details.php?id=" . $pedido_id . "&message=" . urlencode('Não foi possível excluir o item.'));
            exit();
        }
    }
}

$conn->close();
