USE illuminati_db;

INSERT INTO roles(role) VALUES
    ('Minerva'),
    ('Politician'),
    ('Scientist'),
    ('Actor'),
    ('Mercenary'),
    ('Black Ops'),
    ('Clergy'),
    ('Grunt'),
    ('Hacker'),
    ('Banker');

INSERT INTO users(username, email, password, role_id) VALUES
    ('Adam Weishaupt', 'badpassword@gmail.com', '$2a$10$RQt2KJJ7zh9BfynID2r3WuSf3niZZOstch6gmSRj37GVs/J.WCWMK', 1),
    ('Brad Pitt', 'fightclub@gmail.com', '$2a$10$yJKOiEP3sPcnlIez/9vX3.PWSN/f2ySiAh4C1OrvAoSuqFb71Hng2', 4),
    ('David Rockefeller', 'oilmoney@gmail.com', '$2a$10$ilQzqh/S8hpuYvFqbCmQjeq83ehP3fylSRYJat/5jyyh5Apwctsme', 10),
    ('Dianne Feinstein', 'difi@gmail.com', '$2a$10$bDBIonr73.CBPScriBf1peuTx9hrmx0A37ZRPq6RA8ZES93JnOeBi', 2),
    ('Keanu Reeves', 'theone@gmail.com', '$2a$10$OXmCEoe/q8gKulL2WsBAN.95Cjb4OV4fG47JowYaYwbia7RUVQB9i', 9);

INSERT INTO contracts(title, description, country, reward, user_id) VALUES
    ('Blow Up Chinese Satellite', '...', 'China', 5.5, 1),
    ('Rig Election', '...', 'Guatemala', 1.5, 1),
    ('Clean Swimming Pool', 'It"s filthy', 'USA', 2.5, 2),
    ('Crash Stock Market', '...', 'Japan', 9.3, 3),
    ('Create Bioweapon', '...', 'Chile', 8.3, 5),
    ('Photograph Dark Side of Moon', '...', 7.7, 4),
    ('Flood Panama Canal', '...', 3.4, 1);

INSERT INTO contracts_roles(contract_id, role_id) VALUES
    (1, 3), (1, 6), (2, 2), (2, 4),
    (2, 7), (3, 5), (3, 8), (4, 9),
    (4, 10), (5, 3), (5, 6), (6, 3),
    (6, 6), (6, 9), (7, 5), (7, 3);
