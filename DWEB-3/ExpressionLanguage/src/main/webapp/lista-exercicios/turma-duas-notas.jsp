<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 5 - Médias de Turma</title>
</head>
<body>
<h3>Exercício 5 - Médias de Turma</h3>

<table border="1">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Nota 1</th>
        <th>Nota 2</th>
        <th>Média</th>
        <th>Situação</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="aluno" items="${alunos}">
        <c:set var="mediaAlunoAtual" value="${(aluno.nota1 + aluno.nota2) / 2}"/>
        <tr>
            <td>${aluno.nome}</td>
            <td><fmt:formatNumber value="${aluno.nota1}" maxFractionDigits="2" minFractionDigits="2"/></td>
            <td><fmt:formatNumber value="${aluno.nota2}" maxFractionDigits="2" minFractionDigits="2"/></td>
            <td><fmt:formatNumber value="${mediaAlunoAtual}" maxFractionDigits="2" minFractionDigits="2"/></td>
            <td>
                <c:choose>
                    <c:when test="${mediaAlunoAtual >= 70}">
                        Aprovado
                    </c:when>
                    <c:when test="${mediaAlunoAtual >= 40 && mediaAlunoAtual < 70}">
                        Recuperação
                    </c:when>
                    <c:otherwise>
                        Reprovado
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>