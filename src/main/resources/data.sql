INSERT INTO servicos_medicos(id, nome, descricao, preco, ativo, criado_em, atualizado_em)
VALUES
('550e8400-e29b-41d4-a716-446655440000', 'Manutenção', 'Manutenção de aparelho dentário', 60.00, TRUE, '2024-03-26T12:00:00', '2024-03-26T12:00:00'),
('551e8400-e29b-41d4-a716-446655440001', 'Limpeza Dental', 'Procedimento de limpeza dental dos resíduos superficiais', 86.00, TRUE, '2024-03-27T09:00:00', '2024-03-27T09:00:00');

INSERT INTO clinicas(id,cnpj,nome,endereco,ano_fundacao,ativo,criado_em, atualizado_em)
VALUES
('c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '1223-66','SorrindoBem','Rua Senador Pompeu',1956, TRUE , NOW(), NOW()),
('4749cee0-8f95-45b9-a27c-4e324300e7a2', '305-05','Clínica XYZ', 'Belo Horizonte, Avenida Secundária, 456, SC', 2019,TRUE, NOW(), NOW());


INSERT INTO admins(id, id_clinica, nome, data_nascimento, cpf, role, ativo, criado_em, atualizado_em)
VALUES
    ('551e8400-e29b-41d4-a716-446655440001','c5002457-4cd3-480c-85cf-fbcc9a35ae0e', 'Karina Silva', '2003-09-14','06524651314', 0, TRUE, NOW(), NOW()),
	('550e8400-e29b-41d4-a716-446655440000','4749cee0-8f95-45b9-a27c-4e324300e7a2', 'João Pedro', '2005-09-08','23594125402', 0, TRUE, NOW(), NOW()),
  	('87bdaca0-d08f-4450-9ace-20015babbd4a','4749cee0-8f95-45b9-a27c-4e324300e7a2', 'Carmen Miranda', '1995-02-16', '11155698877', 0, TRUE, NOW(), NOW()),
 	('a51d6e7b-9a3c-469c-87dd-0a6eb7447c9c','4749cee0-8f95-45b9-a27c-4e324300e7a2', 'Jack Black', '1986-11-15', '02788496314', 1, TRUE, NOW(), NOW());

 INSERT INTO pacientes (id, id_clinica, cpf, nome, data_nascimento, plano_de_saude, ativo, criado_em)
 VALUES
     ('b715073b-0d71-46b6-ad78-a46d600b778f', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '12345678901', 'Fulano da Silva', '1990-01-01', TRUE, TRUE, CURRENT_TIMESTAMP),
     ('7d1c122d-d113-4b7c-afe5-04b5cd334b98', '4749cee0-8f95-45b9-a27c-4e324300e7a2', '23456789012', 'Ciclano Souza', '1985-05-15', FALSE, TRUE,CURRENT_TIMESTAMP),
     ('0db1ebd5-dbf3-4f4e-af53-aa83ab972cf7', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '34567890123', 'Beltrano Oliveira', '1978-10-20', TRUE, TRUE,CURRENT_TIMESTAMP),
     ('69086bbb-30e9-4dff-b171-3b40a9993e7d', '4749cee0-8f95-45b9-a27c-4e324300e7a2', '45678901234', 'Maria Santos', '1982-03-30', FALSE, TRUE, CURRENT_TIMESTAMP),
     ('514d06c3-02ac-4325-bb87-eead4481f72a', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '56789012345', 'João Pereira', '1995-07-12', TRUE, TRUE,CURRENT_TIMESTAMP),
     ('1ef038f7-707a-4153-8d82-9d4c7f319053', '4749cee0-8f95-45b9-a27c-4e324300e7a2', '67890123456', 'Ana Silva', '1988-11-05', FALSE, TRUE,CURRENT_TIMESTAMP),
     ('5a17c2f8-d611-4b0e-9ac9-55b05147194c', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '78901234567', 'Pedro Oliveira', '1976-09-22', TRUE, TRUE,CURRENT_TIMESTAMP),
     ('9f47394f-a5dd-4676-8f73-f391db298cf5', '4749cee0-8f95-45b9-a27c-4e324300e7a2', '89012345678', 'Mariana Souza', '1992-04-18', FALSE, TRUE,CURRENT_TIMESTAMP),
     ('da0e8cce-1d05-4a42-811f-0fafff66cd1f', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '90123456789', 'José Almeida', '1980-06-08', TRUE, TRUE,CURRENT_TIMESTAMP),
     ('c9e6577e-952f-4072-96d1-a42a298fa6b8', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '01234567890', 'Carla Santos', '1998-02-25', FALSE, TRUE,CURRENT_TIMESTAMP);


INSERT INTO dentistas (id, id_clinica, cpf, cro, nome, data_nascimento, area, ativo, criado_em, atualizado_em)
VALUES
    ('d1a4f431-f34b-4c3b-a60d-6e5e3432d8a1', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '12345678914', 'CRONUMERO1', 'João Silva', '1990-05-15', 'Odontopediatria', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('e6b2dfe8-6da4-40c4-98e1-68418dcb18d6', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '98765432101', 'CRONUMERO2', 'Maria Souza', '1985-08-20', 'Ortodontia', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('b4a1c7d3-ec3f-4a9b-9f24-87c2b17e6d2e', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '45678912301', 'CRONUMERO3', 'Pedro Santos', '1978-03-10', 'Implantodontia', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('f5e6d7c8-9b0a-1c2d-3e4f-5a6b7c8d9e0a', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '78912345601', 'CRONUMERO4', 'Ana Oliveira', '1982-11-25', 'Endodontia', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('9a8b7c6d-5e4f-3a2b-1c0d-9e8f7a6b5c4d', 'c5002457-4cd3-480c-85cf-fbcc9a35ae0e', '65432198701', 'CRONUMERO5', 'Carlos Mendes', '1995-07-03', 'Periodontia', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
