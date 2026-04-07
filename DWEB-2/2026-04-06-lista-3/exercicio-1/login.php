<?php

session_start();

require 'db.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = trim($_POST["email"]);
    $senha = $_POST["senha"];

    // LIMIT 1 só garante que o banco retorne 1 resultado
    $stm = $conn->prepare("SELECT id, nome, senha FROM usuarios WHERE email = ? LIMIT 1");
    $stm->bind_param("s", $email);

    $stm->execute();
    $result = $stm->get_result();

    if ($result->num_rows === 1) {
        $usuario = $result->fetch_assoc();

        // Verificar a senha
        if (password_verify($senha, $usuario["senha"])) {

            session_regenerate_id(true);

            $_SESSION['id_usuario'] = $usuario['id'];
            $_SESSION['nome_usuario'] = $usuario['nome'];
            $_SESSION['logado'] = true;
            $_SESSION['contador'] = 0;

            header("Location: painel.php");
            exit();
        }
    }

    header("Location: index.php?erro=1");
    exit();
}
$stm->close();
$conn->close();
