<?php

require_once 'db.php';

$usuarios = [];
$message = '';

if (isset($_GET['message'])) {
    $message = htmlspecialchars($_GET['message']);
}

$sql = "SELECT id, nome, email FROM tb_usuarios";

// Consulta passando o SQL
$result = $conn->query($sql);

if ($result){
    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            $usuarios[] = $row;
        }
    }
} else {
    echo "Erro ao carregar usuários: " . $conn->error;
}

$conn->close();

?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Usuários</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <div class="container">
        <h2>Lista de Usuários</h2>

        <?php if($message) : ?>
            <div class="message <?php echo (strpos($message, 'sucesso') !== false) ? 'sucess' : 'error' ?>">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <a href="create.php" class="add-button">Adicionar Novo Usuários</a>

        <?php if(empty($usuarios)) : ?>
            <p>Nenhum usuário encontrado ainda.</p>
        <?php else: ?>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Ações</th>
                </tr>

                <?php foreach ($usuarios as $usuario) : ?>
                    <tr>
                        <td><?php echo htmlspecialchars($usuario["id"]); ?></td>
                        <td><?php echo htmlspecialchars($usuario["nome"]); ?></td>
                        <td><?php echo htmlspecialchars($usuario["email"]); ?></td>
                        <td>
                            <a href="update.php?id=<?php echo htmlspecialchars($usuario["id"]); ?>">Editar</a>
                            <a href="delete.php?id=<?php echo htmlspecialchars($usuario["id"]); ?>" onclick="return confirm('Têm certeza que deseja excluir esse usuário?');">Excluir</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </table>
        <?php endif; ?>
    </div>
</body>
</html>