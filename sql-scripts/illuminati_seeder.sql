USE illuminati_db;

INSERT INTO roles(role) VALUES
    ('Minerva'),
    ('Politician'),
    ('Scientist'),
    ('Actor'),
    ('Mercenary'),
    ('Black Ops'),
    ('Clergy'),
    ('Grunt');

INSERT INTO users(username, email, password, role_id) VALUES
    ('Adam Weishaupt', 'badpassword@gmail.com', '1234512345', 1),
    ('Brad Pitt', 'fightclub@gmail.com', 'abc', 4);

INSERT INTO contracts(title, description, country, reward, user_id) VALUES
    ('Blow Up Chinese Satellite', '...', 'China', 5.5, 1),
    ('Rig Election', '...', 'Guatemala', 1.5, 1),
    ('Eliminate Angelina Jolie', '...', 'USA', 2.5, 2);

INSERT INTO contracts_roles(contract_id, role_id) VALUES
    (1, 3), (1, 6), (2, 2), (2, 4),
    (2, 7), (3, 5), (3, 8);
