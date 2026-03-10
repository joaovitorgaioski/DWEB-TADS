USE crud_db;
 
CREATE TABLE tb_usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO tb_usuarios (nome, email) 
VALUES 
    ('Lucas Almeida', 'lucas.almeida@gmail.com'),
    ('Beatriz Rocha', 'beatriz.rocha@outlook.com'),
    ('Gabriel Souza', 'gabriel.souza@uol.com.br'),
    ('Fernanda Lima', 'fernanda.lima@hotmail.com'),
    ('Rafael Moreira', 'rafael.moreira@empresa.com'),
    ('Juliana Castro', 'ju.castro@gmail.com'),
    ('Thiago Mendes', 'thiago.mendes@yahoo.com'),
    ('Larissa Nunes', 'larissa.nunes@gmail.com'),
    ('Bruno Fernandes', 'bruno.f@provedor.net'),
    ('Camila Duarte', 'camila.duarte@icloud.com'),
    ('Felipe Ramos', 'felipe.ramos@gmail.com'),
    ('Amanda Vieira', 'amanda.v@empresa.com.br'),
    ('Rodrigo Silva', 'rodrigo.silva@outlook.com'),
    ('Patrícia Gomes', 'paty.gomes@gmail.com'),
    ('Henrique Santos', 'henrique.s@uol.com');