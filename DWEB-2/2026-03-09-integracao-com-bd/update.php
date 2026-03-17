<?php
// Código para realizar update de um usuário

require_once 'db.php';

$message = '';
$usuario = null;

// GET para obtenção dos valores do usuário salvando eles em $usuario
// Verificando existência de id
if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Prepared Statement, é o SQL que iremos executar, usamos o 'prepare' e o 'bind_param' pois eles evitam sql injection
    $stm = $conn->prepare("SELECT id, nome, email FROM tb_usuarios WHERE id = ?");

    // Quando o $stm da erro
    if ($stm == false) {
        $message = 'Erro na preparação da query: ' . $conn->error;
    } else {
        // Execução do $stm e obtenção dos resultados
        $stm->bind_param("i", $id);
        $stm->execute();
        $result = $stm->get_result();

        // Colocando o $result da query em $usuario
        $usuario = $result->fetch_assoc();

        // Agora verificações caso não haja usuários setados
        if (!$usuario) {
            $message = 'Usuário não encontrado.';
        }
    }
} else {
    $message = 'ID do usuário não fornecido';
}

// POST para realizar update desse usuário
if ($_SERVER['REQUEST_METHOD'] === 'POST' && $usuario) {
    $id = $_POST['id'];
    $nome = $_POST['nome'];
    $email = $_POST['email'];

    // Validação básica
    if (empty($nome) || empty($email)) {
        $message = 'Por favor, preencha todos os campos.';
    }
    // Passou? -> Valida se tem características de email
    elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $message = 'Formato de email inválido.';
    }
    // Passou? -> Então podemos fazer o update no banco
    else {
        $stm = $conn->prepare("UPDATE tb_usuarios SET nome = ?, email = ? WHERE id = ?");

        // Quando o $stm da erro
        if ($stm == false) {
            $message = 'Erro na preparação da query.' . $conn->error;
        } else {
            // bind_param é quem de fato garante que não haja sql injection
            $stm->bind_param("ssi", $nome, $email, $id);

            // Caso de bom
            if ($stm->execute()) {
                $message = 'Usuário atualizado com sucesso.';
                $usuario['nome'] = $nome;
                $usuario['email'] = $email;
            } else {
                if ($conn->errno == 1062) {
                    $message = 'Este email já está cadastrado.';
                } else {
                    $message = 'Erro ao cadastrar usuário.' . $conn->error;
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
    <title>Atualizar Usuário</title>
    <link rel="stylesheet" href="style.css" />
</head>

<body>
    <div class="container">
        <h2>Editar Usuário</h2>

        <?php if ($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <?php if ($usuario) : ?>
            <form method="POST">
                <input type="hidden" name="id" value="<?php echo htmlspecialchars($usuario['id']) ?>">

                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" require value="<?php echo htmlspecialchars($usuario['nome']) ?>">

                <label for="email">Email</label>
                <input type="email" name="email" id="email" required value="<?php echo htmlspecialchars($usuario['email']) ?>">

                <input type="submit" value="Editar Usuário">
            </form>
        <?php else: ?>
            <p><?php echo $message ?></p>
        <?php endif; ?>

        <p><a href="index.php">Voltar para a lista de usuários</a></p>
    </div>
</body>

</html>