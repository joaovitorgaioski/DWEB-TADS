<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 6 - Livros</title>
    <style>
        .recente {
            color: green;
        }
        .antigo {
            color: red;
        }
    </style>

</head>
<body>
    <h3>Exercicio 6 - Livros</h3>

    <c:if test="${fn:length(livros) == 0}">
        <p>Não há nenhum livro</p>
    </c:if>

    <c:if test="${fn:length(livros) != 0}">
    <table border="1" cellpadding="5">
        <thead>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Ano</th>
                <th>Disponível?</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="qtdDisponiveis" value="0"/>
            <c:forEach var="livro" items="${livros}">
                <tr>
                    <td><c:out value="${livro.titulo}"/></td>
                    <td><c:out value="${livro.autor}"/></td>
                    <td>
                        <div class="${livro.anoPublicacao < 2000 ? "antigo" : "recente"}">
                            <c:out value="${livro.anoPublicacao}"/>
                        </div>
                    </td>
                    <td>${livro.disponivel == true ? "Disponível" : "Emprestado"}</td>
                </tr>
                <c:if test="${livro.disponivel == true}">
                    <c:set var="qtdDisponiveis" value="${qtdDisponiveis+1}"/>
                </c:if>
            </c:forEach>
        </tbody>
    </table>

    <br>

    Quantidade de livros cadastrados: <c:out value="${fn:length(livros)}"/>
        <br>
    Quantidade de livros disponíveis: <c:out value="${qtdDisponiveis}"/>
    </c:if>

</body>
</html>