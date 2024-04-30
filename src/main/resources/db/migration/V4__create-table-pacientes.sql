CREATE TABLE pacientes(
	id UUID PRIMARY KEY,
	id_clinica UUID references clinica(id) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	nome VARCHAR(250) NOT NULL,
	data_nascimento VARCHAR(250) NOT NULL,
	plano_de_saude BOOLEAN NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT TRUE,
	criado_em TIMESTAMP NOT NULL,
	atualizado_em TIMESTAMP	
);