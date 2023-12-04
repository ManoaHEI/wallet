CREATE TABLE IF NOT EXISTS currency (
    id_currency SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    value FLOAT NOT NULL -- value against the dollar
);