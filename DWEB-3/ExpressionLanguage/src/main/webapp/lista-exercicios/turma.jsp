<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 3 - Turma</title>
</head>
<body>
<h3>Exercício 3 - Turma</h3>

<table border="1">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Nota</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="aluno" items="${alunos}">
        <tr>
            <td>${aluno.nome}</td>
            <td align="center">
                <c:choose>
                    <c:when test="${aluno.nota < 70}">
                        * <fmt:formatNumber value="${aluno.nota}" maxFractionDigits="2" minFractionDigits="2"/> *
                    </c:when>
                    <c:otherwise>
                        <fmt:formatNumber value="${aluno.nota}" maxFractionDigits="2" minFractionDigits="2"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>