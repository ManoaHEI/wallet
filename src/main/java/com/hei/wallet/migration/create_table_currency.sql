CREATE TABLE IF NOT EXISTS currency (
    id_currency SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    code VARCHAR(3)
);