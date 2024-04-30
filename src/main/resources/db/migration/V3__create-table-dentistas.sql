CREATE TABLE dentistas(
	id UUID PRIMARY KEY,
	id_clinica UUID references clinicas(id) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	cro VARCHAR(11) NOT NULL UNIQUE,
	nome VARCHAR(250) NOT NULL,
	data_nascimento VARCHAR(250) NOT NULL,
	area VARCHAR(250) NOT NULL,
	ativo BOOLEAN NOT NULL,
	criado_em TIMESTAMP NOT NULL,	
	atualizado_em TIMESTAMP	
);