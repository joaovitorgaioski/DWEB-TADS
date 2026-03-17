DROP DATABASE IF EXISTS db_tarefas;
CREATE DATABASE db_tarefas;
USE db_tarefas;

CREATE TABLE tb_tarefas (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(255) NOT NULL,
	descricao TEXT,
	status ENUM("Pendente", "Em Andamento", "Concluída") DEFAULT "Pendente"
);

INSERT INTO tb_tarefas (titulo, descricao, status) VALUES
("Criar drag-and-drop", "Implementar dnd para facilitar o uso do site", "Em Andamento"),
("Formatar notebook", "Foi pedido para formatar, devo ajudar o solicitante", "Concluída");