CREATE TABLE tbusuario
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE tblivro
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    titulo  VARCHAR(150) NOT NULL,
    autores VARCHAR(200) NOT NULL,
    edicao  VARCHAR(30),
    editora VARCHAR(100),
    isbn    VARCHAR(20) UNIQUE
);

CREATE TABLE tbemprestimo
(
    id_usuario INT       NOT NULL,
    id_livro   INT       NOT NULL,
    data_hora  TIMESTAMP NOT NULL,
    PRIMARY KEY (id_usuario, id_livro, data_hora),
    FOREIGN KEY (id_usuario) REFERENCES tbusuario (id),
    FOREIGN KEY (id_livro) REFERENCES tblivro (id)
);
