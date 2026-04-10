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
('Detergente Líquido', 2.45, 'Fragrância neutra, 500ml.'),
('Feijão Carioca 1kg', 8.90, 'Feijão tipo 1, grãos selecionados.'),
('Macarrão Espaguete 500g', 4.20, 'Massa de sêmola, cozimento rápido.'),
('Açúcar Refinado 1kg', 3.80, 'Açúcar branco, alta pureza.'),
('Sal Refinado 1kg', 2.10, 'Sal iodado, uso diário.'),
('Óleo de Soja 900ml', 6.75, 'Óleo vegetal para preparo de alimentos.'),
('Biscoito Recheado Chocolate 140g', 2.99, 'Biscoito crocante com recheio cremoso.'),
('Sabão em Pó 1kg', 12.50, 'Remove manchas difíceis, fragrância suave.'),
('Shampoo 350ml', 9.90, 'Para cabelos normais, uso diário.'),
('Coberta', 35.00, 'Ideal para os invernos mais rigorosos.'),
('Papel Higiênico 12 rolos', 16.80, 'Folha dupla, macio e resistente.'),
('Margarina 500g', 5.60, 'Com sal, ideal para pães e receitas.');