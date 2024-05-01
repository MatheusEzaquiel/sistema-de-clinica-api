CREATE TABLE clinicas(
	id UUID PRIMARY KEY,
	cnpj VARCHAR(250) NOT NULL UNIQUE,
	nome VARCHAR(250) NOT NULL,
	endereco VARCHAR(250) NOT NULL,
	telefone VARCHAR(13),
	ano_fundacao INTEGER NOT NULL,
	ativo BOOLEAN NOT NULL,
	criado_em TIMESTAMP NOT NULL,	
	atualizado_em TIMESTAMP	
);