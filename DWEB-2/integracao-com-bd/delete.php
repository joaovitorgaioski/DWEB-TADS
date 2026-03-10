<?php

require_once 'db.php';

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Prepared Statement
    $stm = $conn->prepare("DELETE FROM tb_usuarios WHERE id = ?");
    if ($stm === false) {
        header("Location: index.php?message=" . urlencode('Erro na preparação da query: ' . $conn->error));
        exit();
    } else {
        $stm->bind_param("i", $id);
        if ($stm->execute()) {
            header("Location: index.php?message=" . urlencode('Usuário excluido com sucesso.'));
            exit();
        } else {
            header("Location: index.php?message=" . urlencode('Não foi possível excluir o usuário.'));
            exit();
        }
    }
}

$conn->close();