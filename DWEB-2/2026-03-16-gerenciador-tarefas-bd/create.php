<?php

require_once 'db-connection.php';
$message = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $titulo = $_POST['titulo'];
    $descricao = $_POST['descricao'];
    $status = $_POST['status'];

    if (empty($titulo) || empty($descricao) || empty($status)) {
        $message = "Por favor, preencha todos os campos.";
    } else {
        // Criar um Prepared Statement para evitar SQL injection
        $stm = $conn->prepare("INSERT INTO tb_tarefas (titulo, descricao, status) VALUES (?, ?, ?)");
        if ($stm == false) {
            $message = "Erro na preparação da query." . $conn->error;
        } else {
            $stm->bind_param("sss", $titulo, $descricao, $status); //sss é o tipo de dado dos parâmetros
            if ($stm->execute()) {
                $message = "Tarefa adicionada com sucesso.";
            } else {
                if ($conn->errno == 1062) { // Erro de entrada duplicada
                    $message = "Esta tarefa já está cadastrado.";
                } else {
                    $message = "Erro ao adicionar a tarefa." . $stm->error;
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
    <title>Criar Tarefa</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Criar Novo Tarefa</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <form method="POST">
            <label for="titulo">Titulo</label>
            <input type="text" id="titulo" name="titulo" require placeholder="Digite um titulo">

            <label for="descricao">Descrição</label>
            <input type="text" name="descricao" id="descricao" required placeholder="Digite uma descrição">

            <label for="status">Status</label>
            <select name="status" id="status">
                <option value="Pendente">Pendente</option>
                <option value="Em Andamento">Em Andamento</option>
                <option value="Concluída">Concluída</option>
            </select>

            <input type="submit" value="Adicionar Tarefa">
        </form>

        <p><a href="index.php">Voltar para a lista de tarefas</a></p>
    </div>
</body>

</html>