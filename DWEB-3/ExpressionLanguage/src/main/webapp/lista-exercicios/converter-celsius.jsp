<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/taglibrary.tld" prefix="ct" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Exercicio 2 - Converter Celsius</title>
</head>
<body>
<h3>Exercício 2 - Converter Celsius</h3>

<form method="get">
    <input type="number" name="celsius">
    <label for="celsius">C°</label>
    <br><br>
    <input type="submit" value="Converter">
</form>

<br>

<c:if test="${not empty param.celsius}">
    <table border="1">
        <thead>
        <tr>
            <th>Celsius</th>
            <th>Fahrenheit</th>
            <th>Kelvin</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${param.celsius} °C</td>
            <td>${ct:celsiusParaFahrenheit(param.celsius)} °F</td>
            <td>${ct:celsiusParaKelvin(param.celsius)} K</td>
        </tr>
        </tbody>
    </table>
</c:if>
</body>
</html>