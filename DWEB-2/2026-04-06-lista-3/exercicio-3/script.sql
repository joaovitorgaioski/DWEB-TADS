DROP DATABASE IF EXISTS dbcompras;
CREATE DATABASE dbcompras;
USE dbcompras;

CREATE TABLE tbproduto (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(5,2) NOT NULL,
    descricao VARCHAR(200) NOT NULL
);

INSERT INTO tbproduto (nome, preco, descricao) VALUES 
('Arroz Integral 1kg', 7.50, 'Arroz tipo 1, rico em fibras.'),
('Leite Integral 1L', 5.29, 'Leite UHT de caixinha.'),
('Café Torrado 500g', 18.90, 'Café extra forte, moído na hora.'),
('Azeite de Oliva 500ml', 32.00, 'Extra virgem, acidez máxima 0,5%.'),
('Detergente Líquido', 2.45, 'Fragrância neutra, 500ml.');
