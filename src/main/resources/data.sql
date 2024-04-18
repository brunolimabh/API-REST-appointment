INSERT INTO Medico
    (nome, crm)
VALUES
    ('Dr Hanchuscrut' , '1234'),
    ('Dr Erick' , '4321');

INSERT INTO Consulta
    (nome, data_agendamento, preco, local, medico_id)
VALUES
    ('Pediatra', '2024-04-18', 150.0, 'Hospital Albert Einstein', 1),
    ('Cirurgia do coração', '2024-05-10', 11150.0, 'Hospital Albert Einstein', 2);