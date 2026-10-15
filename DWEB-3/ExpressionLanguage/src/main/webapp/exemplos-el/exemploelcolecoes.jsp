<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Exemplo EL Coleções</title>
</head>
<body>
    <h3>EL: acesso a coleções</h3>

    <table border="1">
        <thead>
            <th>Listas(Frutas)</th>
            <th>Arrays(Carros)</th>
            <th>Mapas(Estados)</th>
        </thead>

        <tbody>
            <td>
                <ul>
                    <li>${frutas[0]}</li>
                    <li>${frutas[1]}</li>
                    <li>${frutas[2]}</li>
                    <li>${frutas[3]}</li>
                </ul>
            </td>
            <td>
                <ul>
                    <li>${carros[0]}</li>
                    <li>${carros[1]}</li>
                    <li>${carros[2]}</li>
                    <li>${carros[3]}</li>
                </ul>
            </td>

            <td>
                <ul>
                    <li>${estados["PR"]}</li>
                    <li>${estados["SC"]}</li>
                    <li>${estados["RS"]}</li>
                    <li>${estados["RJ"]}</li>
                    <li>${estados["SP"]}</li>
                    <li>${estados["MG"]}</li>
                </ul>
            </td>
        </tbody>
    </table>
</body>
</html>