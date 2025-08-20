--v2: Migration para adicionar a coluna de rank na tabela de cadatro
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
