<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 1 - Moedas</title>
</head>
<body>
    <h3>Exercício 1 - Moedas</h3>

    <form action="converter" method="get">
        <label for="reais">R$:</label>
        <input type="text" name="reais">
        <input type="submit" value="Converter">
    </form>

    <br>

    <c:if test="${not empty param.reais}">
    <table border="1">
        <thead>
            <tr>
                <th>Moeda</th>
                <th>Cotação</th>
                <th>Valor Convertido</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="moeda" items="${moedas}">
                <tr>
                    <td>${moeda.nome}</td>
                    <td>${moeda.cotacao}</td>
                    <td>${empty param.reais ? 0 : param.reais / moeda.cotacao}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </c:if>
</body>
</html>