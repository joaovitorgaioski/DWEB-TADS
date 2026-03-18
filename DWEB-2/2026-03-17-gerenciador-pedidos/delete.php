<?php

require_once 'db-connection.php';

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Prepared Statement
    $stm = $conn->prepare("DELETE FROM pedidos WHERE id = ?");
    if ($stm === false) {
        header("Location: index.php?message=" . urlencode('Erro na preparação da query: ' . $conn->error));
        exit();
    } else {
        $stm->bind_param("i", $id);
        if ($stm->execute()) {
            header("Location: index.php?message=" . urlencode('Pedido excluido com sucesso.'));
            exit();
        } else {
            header("Location: index.php?message=" . urlencode('Não foi possível excluir o pedido.'));
            exit();
        }
    }
}

$conn->close();