CREATE TABLE servicos_medicos(
	id UUID PRIMARY KEY,
	id_dentista UUID REFERENCES dentistas(id) NOT NULL,
	nome VARCHAR(250) NOT NULL,
	descricao VARCHAR(250) NOT NULL,
	preco FLOAT NOT NULL,
	ativo BOOLEAN NOT NULL,	
	criado_em TIMESTAMP NOT NULL,
	atualizado_em TIMESTAMP
);