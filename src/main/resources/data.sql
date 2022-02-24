INSERT INTO users VALUES (1, '22', 'admin@mail.ru', 'admin' ,'adminov', '$2a$12$VQTz1QnJyFhMtGtRug.AA.ZGFqWSzixTvZAfY76TH52lupe8vVUne');
INSERT INTO users VALUES (2, '33', 'user@mail.ru', 'user', 'userov', '$2a$12$qy9dv4QEXV2TQB7IbkMn6.O/cfH5Ba4yxx95OX/QCd0Mr25PQgQG.');


INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_USER');

INSERT INTO users_roles VALUES (1, 1);
INSERT INTO users_roles VALUES (1, 2);
INSERT INTO users_roles VALUES (2, 2);
