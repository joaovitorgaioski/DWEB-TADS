<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 7 - Carrinho de Itens</title>
    <style>
        .verde {
            color: green;
        }
        .laranja {
            color: darkorange;
        }
    </style>

</head>
<body>
    <h3>Exercicio 7 - Carrinho de Itens</h3>

    <c:if test="${fn:length(carrinho) == 0}">
        <p>Seu carrinho está vazio!</p>
    </c:if>

    <c:if test="${fn:length(carrinho) != 0}">
    <table border="1" cellpadding="5">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Preço Unitário</th>
                <th>Quantidade</th>
                <th>Subtotal</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="total" value="0"/>
            <c:forEach var="item" items="${carrinho}">
                <tr>
                    <td><c:out value="${item.nomeProduto}"/></td>
                    <td>
                        <fmt:formatNumber value="${item.precoUnitario}"
                                          maxFractionDigits="2"
                                          minFractionDigits="2"
                                          type="currency"/>
                    </td>
                    <td>
                        <div class="${item.quantidade >= 5 ? "laranja" : "verde"}">
                            <c:out value="${item.quantidade}"/>
                        </div>
                    </td>
                    <td>
                        <fmt:formatNumber value="${item.precoUnitario * item.quantidade}"
                                          maxFractionDigits="2"
                                          minFractionDigits="2"
                                          type="currency"/>
                    </td>
                    <c:set var="total" value="${total +(item.precoUnitario * item.quantidade)}"/>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>

    Valor total da compra: R$ <c:out value="${total}"/>
    </c:if>

</body>
</html>