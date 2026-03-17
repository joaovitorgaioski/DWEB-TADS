<?php
// Código para realizar update de um tarefa

require_once 'db-connection.php';

$message = '';
$tarefa = null;

// GET para obtenção dos valores do tarefa salvando eles em $tarefa
// Verificando existência de id
if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Prepared Statement, é o SQL que iremos executar, usamos o 'prepare' e o 'bind_param' pois eles evitam sql injection
    $stm = $conn->prepare("SELECT id, titulo, descricao, status FROM tb_tarefas WHERE id = ?");

    // Quando o $stm da erro
    if ($stm == false) {
        $message = 'Erro na preparação da query: ' . $conn->error;
    } else {
        // Execução do $stm e obtenção dos resultados
        $stm->bind_param("i", $id);
        $stm->execute();
        $result = $stm->get_result();

        // Colocando o $result da query em $tarefa
        $tarefa = $result->fetch_assoc();

        // Agora verificações caso não haja tarefas setadas
        if (!$tarefa) {
            $message = 'Tarefa não encontrada.';
        }
    }
} else {
    $message = 'ID da tarefa não fornecido';
}

// POST para realizar update dessa tarefa
if ($_SERVER['REQUEST_METHOD'] === 'POST' && $tarefa) {
    $id = $_POST['id'];
    $titulo = $_POST['titulo'];
    $descricao = $_POST['descricao'];
    $status = $_POST['status'];

    // Validação básica
    if (empty($titulo) || empty($descricao) || empty($status)) {
        $message = 'Por favor, preencha todos os campos.';
    }
    // Passou? -> Então podemos fazer o update no banco
    else {
        $stm = $conn->prepare("UPDATE tb_tarefas SET titulo = ?, descricao = ?, status = ? WHERE id = ?");

        // Quando o $stm da erro
        if ($stm == false) {
            $message = 'Erro na preparação da query.' . $conn->error;
        } else {
            // bind_param é quem de fato garante que não haja SQL injection
            $stm->bind_param("sssi", $titulo, $descricao, $status, $id);

            // Caso de bom
            if ($stm->execute()) {
                $message = 'Tarefa atualizada com sucesso.';
                $tarefa['titulo'] = $titulo;
                $tarefa['descricao'] = $descricao;
                $tarefa['status'] = $status;
            } else {
                if ($conn->errno == 1062) {
                    $message = 'Esta tarefa já está cadastrado.';
                } else {
                    $message = 'Erro ao editar a tarefa.' . $conn->error;
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
    <title>Atualizar tarefa</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Editar tarefa</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <?php if ($tarefa) : ?>
            <form method="POST">
                <input type="hidden" name="id" value="<?php echo htmlspecialchars($tarefa['id']) ?>">

                <label for="titulo">Titulo</label>
                <input type="text" id="titulo" name="titulo" require value="<?php echo htmlspecialchars($tarefa['titulo']) ?>">

                <label for="descricao">Descrição</label>
                <input type="text" name="descricao" id="descricao" required value="<?php echo htmlspecialchars($tarefa['descricao']) ?>">

                <label for="status">Status</label>
                <select name="status" id="status">
                    <option value="Pendente">Pendente</option>
                    <option value="Em Andamento">Em Andamento</option>
                    <option value="Concluída">Concluída</option>
                </select>

                <input type="submit" value="Editar tarefa">
            </form>
        <?php else: ?>
            <p><?php echo $message ?></p>
        <?php endif; ?>

        <p><a href="index.php">Voltar para a lista de tarefas</a></p>
    </div>
</body>

</html>