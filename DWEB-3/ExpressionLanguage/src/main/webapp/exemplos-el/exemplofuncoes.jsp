<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="/WEB-INF/tlds/taglibrary.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exemplo Funções</title>
</head>
<body>
    <h3>EL: exemplo funções</h3>
    <ul>
        <li><b>Soma:</b> ${f:soma(10,20)} </li>
        <li><b>Subtração:</b> ${f:subtracao(10,20)} </li>
        <li><b>Multiplicação</b> ${f:multiplicacao(10,20)} </li>
        <li><b>Divisão</b> ${f:divisao(10,20)} </li>
    </ul>
</body>
</html>