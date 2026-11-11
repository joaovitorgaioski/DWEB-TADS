<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 4 - Produtos</title>
    <style>
        .verde {
            color: green;
        }
    </style>
</head>

<body>
<h3>Exercicio 4 - Produtos</h3>

<c:if test="${fn:length(produtos) == 0}">
    <p>Não há nenhum produto cadastrado</p>
</c:if>

<c:if test="${fn:length(produtos) != 0}">
    <table border="1" cellpadding="5">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Preço</th>
            <th>Desconto (%)</th>
            <th>Preço após Desconto</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="total" value="0"/>
        <c:forEach var="produto" items="${produtos}">
            <c:set var="valorDescontadoAtual" value="${produto.preco * (1 - (produto.percentualDesconto / 100))}"/>

            <tr <c:if test="${produto.percentualDesconto > 20}">class="verde"</c:if>>
                <td><c:out value="${produto.nome}"/></td>
                <td>
                    <fmt:formatNumber value="${produto.preco}"
                                      maxFractionDigits="2" minFractionDigits="2"
                                      type="currency"/>
                </td>
                <td><c:out value="${produto.percentualDesconto}"/></td>
                <td>
                    <fmt:formatNumber value="${valorDescontadoAtual}"
                                      maxFractionDigits="2" minFractionDigits="2"
                                      type="currency"/>
                </td>
            </tr>
            <c:set var="total" value="${total + valorDescontadoAtual}"/>
        </c:forEach>
        </tbody>
    </table>

    <br>
    Total: <fmt:formatNumber value="${total}"
                      maxFractionDigits="2" minFractionDigits="2"
                      type="currency"/>
</c:if>

</body>
</html>