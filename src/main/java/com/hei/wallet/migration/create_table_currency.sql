CREATE TABLE IF NOT EXISTS Currency (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(3) NOT NULL
);

-- Insertion of the Euro and Ariary currencies
INSERT INTO Currency (name, code) VALUES
    ('Euro', 'EUR'),
    ('Ariary', 'MGA');