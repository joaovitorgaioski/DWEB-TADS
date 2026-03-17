<?php

require_once 'db-connection.php';

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Prepared Statement
    $stm = $conn->prepare("DELETE FROM tb_tarefas WHERE id = ?");
    if ($stm === false) {
        header("Location: index.php?message=" . urlencode('Erro na preparação da query: ' . $conn->error));
        exit();
    } else {
        $stm->bind_param("i", $id);
        if ($stm->execute()) {
            header("Location: index.php?message=" . urlencode('Tarefa excluida com sucesso.'));
            exit();
        } else {
            header("Location: index.php?message=" . urlencode('Não foi possível excluir a tarefa.'));
            exit();
        }
    }
}

$conn->close();