CREATE TABLE pagamentos(
    id UUID PRIMARY key,
    id_servicos_medicos UUID REFERENCES servicos_medicos(id) NOT NULL,
    id_paciente UUID REFERENCES pacientes(id) NOT NULL,
    valor_total FLOAT NOT NULL,
    forma_de_pagamento VARCHAR(250) NOT NULL,
    situacao BOOLEAN NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    atualizado_em TIMESTAMP
);