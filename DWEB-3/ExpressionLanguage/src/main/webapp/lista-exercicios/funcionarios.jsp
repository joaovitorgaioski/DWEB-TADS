<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 8 - Funcionários</title>
    <style>
        .vermelho {
            color: red;
        }
        .azul {
            color: blue;
        }
    </style>

</head>
<body>
    <h3>Exercício 8 - Funcionários</h3>

    <c:if test="${fn:length(funcionarios) == 0}">
        <p>Não há nenhum funcionário</p>
    </c:if>

    <c:if test="${fn:length(funcionarios) != 0}">
    <table border="1" cellpadding="5">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Departamento</th>
                <th>Salário</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="soma" value="0"/>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td><c:out value="${funcionario.nome}"/></td>
                    <td><c:out value="${funcionario.departamento}"/></td>
                    <td>
                        <div class="${funcionario.salario > 5000 ? "vermelho" : "azul"}">
                            <fmt:formatNumber value="${funcionario.salario}"
                                    maxFractionDigits="2"
                                    minFractionDigits="2"
                                    type="currency"/>
                        </div>
                    </td>
                </tr>
                <c:set var="soma" value="${soma + funcionario.salario}"/>
            </c:forEach>
        </tbody>
    </table>

    <br>

    Salário: <c:out value="${soma / fn:length(funcionarios)}"/>
    <br>
    Quantidade: <c:out value="${fn:length(funcionarios)}"/>
    </c:if>

</body>
</html>