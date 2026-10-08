<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
    <div class="row justify-content-center align-items-center" style="min-height: 100vh;">
        <div class="col-12 col-sm-8 col-md-5 col-lg-4">

            <div class="card shadow-sm">
                <div class="card-body p-4">
                    <h3 class="card-title text-center mb-4">Entrar</h3>

                    <form id="loginForm" action="login" method="POST" novalidate>

                        <div class="mb-3">
                            <label for="email" class="form-label">E-mail</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="voce@exemplo.com" required>
                            <div class="invalid-feedback">Informe um e-mail válido.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Senha</label>
                            <input type="password" class="form-control" id="password" name="senha" placeholder="Digite sua senha" required minlength="6">
                            <div class="invalid-feedback">A senha deve ter ao menos 6 caracteres.</div>
                        </div>

                        <div class="mb-3 text-end">
                            <a href="#" id="forgotLink">Esqueceu a senha?</a>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Entrar</button>
                            <button type="button" id="cancelBtn" class="btn btn-secondary">Cancelar</button>
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    const form = document.getElementById('loginForm');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');
    const cancelBtn = document.getElementById('cancelBtn');
    const forgotLink = document.getElementById('forgotLink');

    form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
        }
        form.classList.add('was-validated');
    });

    cancelBtn.addEventListener('click', function () {
        form.reset();
        form.classList.remove('was-validated');
    });

    // Link de recuperação de senha: por enquanto não leva a lugar nenhum.
    forgotLink.addEventListener('click', function (event) {
        event.preventDefault();
    });
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>