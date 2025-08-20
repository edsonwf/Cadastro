-- V1: Criação das tabelas iniciais
CREATE TABLE IF NOT EXISTS tb_missoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    dificuldade VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS tb_cadastro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    img_url VARCHAR(500),
    idade INT,
    missoes_id BIGINT,
    FOREIGN KEY (missoes_id) REFERENCES tb_missoes(id)
);
