<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Biblioteca</title>
</head>
<body>

<h1>Biblioteca</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Autor</th>
        <th>Categoria</th>
        <th>Ano</th>
        <th>Paginas</th>
    </tr>

    <?php foreach ($livros as $livro): ?>
    <tr>
        <td><?= $livro['id'] ?></td>
        <td><?= $livro['titulo'] ?></td>
        <td><?= $livro['autor'] ?></td>
        <td><?= $livro['categoria'] ?></td>
        <td><?= $livro['ano'] ?></td>
        <td><?= $livro['paginas'] ?></td>
    </tr>
    <?php endforeach; ?>

</table>

</body>
</html>
