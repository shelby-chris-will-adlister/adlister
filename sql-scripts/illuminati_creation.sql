CREATE DATABASE illuminati_db;
USE illuminati_db;

CREATE TABLE IF NOT EXISTS roles (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    role VARCHAR(255),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(255),
    email VARCHAR(320),
    password VARCHAR(255) NOT NULL,
    role_id INTEGER UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    CONSTRAINT uc_username UNIQUE (username),
    CONSTRAINT uc_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS contracts (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    description TEXT NOT NULL,
    country VARCHAR(255),
    reward FLOAT NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

/* Keeps track of the roles who can apply for each contract */
CREATE TABLE IF NOT EXISTS contracts_roles (
    contract_id INTEGER UNSIGNED NOT NULL,
    role_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY (contract_id) REFERENCES contracts(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);