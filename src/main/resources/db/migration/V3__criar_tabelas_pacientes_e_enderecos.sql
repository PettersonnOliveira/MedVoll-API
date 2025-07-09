CREATE TABLE pacientes (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Para MySQL, use SERIAL PRIMARY KEY para PostgreSQL
                           nome VARCHAR(100) NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE, -- E-mail deve ser único para evitar duplicidade
                           telefone VARCHAR(20) NOT NULL,
                           cpf VARCHAR(14) NOT NULL UNIQUE,     -- CPF deve ser único e com tamanho fixo
    -- Os campos de endereço serão embutidos diretamente aqui
                           logradouro VARCHAR(100) NOT NULL,
                           bairro VARCHAR(100) NOT NULL,
                           cep VARCHAR(9) NOT NULL,             -- Considerando formato '00000-000' ou '00000000'
                           cidade VARCHAR(100) NOT NULL,
                           uf VARCHAR(2) NOT NULL,              -- UF com 2 caracteres
                           numero VARCHAR(20),                  -- Opcional
                           complemento VARCHAR(100)             -- Opcional
);