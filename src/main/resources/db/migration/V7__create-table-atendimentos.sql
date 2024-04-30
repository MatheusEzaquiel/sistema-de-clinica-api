CREATE TABLE atendimentos(
    id UUID PRIMARY key,
    id_dentista UUID REFERENCES dentistas(id) NOT NULL,
    id_paciente UUID REFERENCES pacientes(id) NOT NULL,
    id_servicos_medicos UUID  REFERENCES servicos_medicos(id) NOT NULL,
    id_pagamento UUID REFERENCES pagamento(id) NOT NULL,
    id_admin UUID  REFERENCES admins(id) NOT NULL,
    id_clinica UUID references clinica(id) NOT NULL,
    horario_inicio TIME(0) NOT NULL,
    horario_fim TIME(0) NOT NULL,
    data_atendimento VARCHAR(250) NOT NULL,
    ativo BOOLEAN NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    atualizado_em TIMESTAMP
);