<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page import="br.edu.ifpr.irati.ads.model.Endereco" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if(usuario == null) {
        response.sendRedirect("formusuario.jsp");
        return;
    }

        Endereco endereco = (Endereco) session.getAttribute("endereco");

        if (endereco == null) {
            endereco = usuario.getEndereco();

            if (endereco == null) {
                endereco = new Endereco();
            }
        }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Endereço</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script type="text/javascript">
                window.onload = () => {
                    const cadastroModal = new bootstrap.Modal('#cadastroModal');
                    cadastroModal.show();
                }

                document.addEventListener("DOMContentLoaded", function() {
                    const btnCancel = document.getElementById('cancel');
                    if (btnCancel) {
                        btnCancel.addEventListener('click', function() {
                            window.location.href = 'formusuario.jsp';
                        });
                    }
                });
    </script>
</head>

<body>
    <form action="endereco.jsp" method="post">
        <div class="modal" tabindex="-1" id="cadastroModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Endereço</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden"
                               class="form-control"
                               id="idUsuario"
                               name="idUsuario"
                               value="<%=usuario.getId()%>">
                        <div class="mb-3">
                            <label for="logradouro" class="form-label">Logradouro</label>
                            <input type="text"
                                   class="form-control"
                                   id="logradouro"
                                   aria-describedby="logradouroHelp"
                                   name="logradouro"
                                   value="<%=endereco.getLogradouro()%>">
                            <div id="logradouroHelp" class="form-text">Informe o logradouro.</div>
                        </div>
                        <div class="mb-3">
                            <label for="numero" class="form-label">Numero</label>
                            <input type="text"
                                   class="form-control"
                                   id="numero"
                                   aria-describedby="numeroHelp"
                                   name="numero"
                                   value="<%=endereco.getNumero()%>">
                            <div id="numeroHelp" class="form-text">Coloque seu número.</div>
                        </div>
                        <div class="mb-3">
                            <label for="bairro" class="form-label">Bairro</label>
                            <input type="text"
                                   class="form-control"
                                   id="bairro"
                                   name="bairro"
                                   aria-describedby="bairroHelp"
                                   value="<%=endereco.getBairro()%>">
                            <div id="bairroHelp" class="form-text">Informe uma bairro.</div>
                        </div>
                        <div class="mb-3">
                            <label for="cidade" class="form-label">Cidade</label>
                            <input type="text"
                                   class="form-control"
                                   id="cidade"
                                   name="cidade"
                                   aria-describedby="cidadeHelp"
                                   value="<%=endereco.getCidade()%>">
                            <div id="cidadeHelp" class="form-text">Informe sua cidade.</div>
                        </div>
                        <div class="mb-3">
                            <label for="estado" class="form-label">Estado</label>
                            <input type="text"
                                   class="form-control"
                                   id="estado"
                                   name="estado"
                                   aria-describedby="estadoHelp"
                                   value="<%=endereco.getEstado()%>">
                            <div id="estadoHelp" class="form-text">Informe seu estado.</div>
                        </div>
                        <div class="mb-3">
                            <label for="cep" class="form-label">CEP</label>
                            <input type="text"
                                   class="form-control"
                                   id="cep"
                                   name="cep"
                                   aria-describedby="cepHelp"
                                   value="<%=endereco.getCep()%>">
                            <div id="cepHelp" class="form-text">Informe o CEP.</div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="cancel">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
            </div>
        </div>
    </form>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
