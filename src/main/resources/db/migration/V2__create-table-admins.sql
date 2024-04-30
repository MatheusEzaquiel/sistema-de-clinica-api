CREATE TABLE admins(
    id UUID PRIMARY KEY,
    id_clinica UUID REFERENCES clinicas(id) NOT NULL,
    nome VARCHAR(250) NOT NULL,
    data_nascimento VARCHAR(250) NOT NULL,
    CPF VARCHAR(11) NOT NULL UNIQUE,
    role INTEGER,
    ativo BOOLEAN NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    atualizado_em TIMESTAMP
);