<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercício 34</title>
</head>
<body>
    <form action="script.php" method="get">
        <label for="capital">Capital (R$)</label>
        <input type="number" id="idCapital" name="capital" />
        <br>

        <label for="taxa">Taxa (%)</label>
        <input type="number" id="idTaxa" name="taxa" />
        <br>

        <label for="tempo">Tempo (meses)</label>
        <input type="number" id="idTempo" name="tempo" />
        <br>

        <input type="submit" id="idCalcular" name="calcular" value="Calcular" />
    </form>
</body>
</html>