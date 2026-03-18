DROP DATABASE IF EXISTS db_pedidos;
CREATE DATABASE db_pedidos;
USE db_pedidos;

CREATE TABLE pedidos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
	cliente_nome VARCHAR(100) NOT NULL,
	total DECIMAL(10, 2) DEFAULT 0.00
);
 
CREATE TABLE itens_pedido (
	id INT AUTO_INCREMENT PRIMARY KEY,
	pedido_id INT NOT NULL,
	produto_nome VARCHAR(255) NOT NULL,
	quantidade INT NOT NULL,
	preco_unitario DECIMAL(10, 2) NOT NULL,
	FOREIGN KEY (pedido_id) REFERENCES pedidos(id) ON DELETE CASCADE
);

