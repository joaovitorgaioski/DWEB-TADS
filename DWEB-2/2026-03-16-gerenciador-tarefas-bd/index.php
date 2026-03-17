<?php

require_once 'db-connection.php';

$tarefas = [];
$message = '';

if (isset($_GET['message'])) {
    $message = htmlspecialchars($_GET['message']);
}

$sql = "SELECT id, titulo, descricao, status FROM tb_tarefas";

// Consulta passando o SQL
$result = $conn->query($sql);

if ($result) {
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $tarefas[] = $row;
        }
    }
} else {
    echo "Erro ao carregar tarefas: " . $conn->error;
}

$conn->close();

?>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarefas</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Lista de Tarefas</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <a href="create.php" class="add-button">Adicionar Nova Tarefa</a>

        <?php if (empty($tarefas)) : ?>
            <p>Nenhuma tarefa encontrada ainda.</p>
        <?php else: ?>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Titulo</th>
                    <th>Descrição</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>

                <?php foreach ($tarefas as $tarefa) : ?>
                    <tr>
                        <td><?php echo htmlspecialchars($tarefa["id"]); ?></td>
                        <td><?php echo htmlspecialchars($tarefa["titulo"]); ?></td>
                        <td><?php echo htmlspecialchars($tarefa["descricao"]); ?></td>
                        <td><?php echo htmlspecialchars($tarefa["status"]); ?></td>
                        <td>
                            <a href="update.php?id=<?php echo htmlspecialchars($tarefa["id"]); ?>">Editar</a>
                            <a href="delete.php?id=<?php echo htmlspecialchars($tarefa["id"]); ?>" onclick="return confirm('Têm certeza que deseja excluir essa tarefa?');">Excluir</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </table>
        <?php endif; ?>
    </div>
</body>

</html>