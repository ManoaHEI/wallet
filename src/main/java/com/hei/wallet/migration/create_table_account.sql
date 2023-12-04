CREATE TABLE IF NOT EXISTS account (
    id_account SERIAL PRIMARY KEY,
    balance FLOAT NOT NULL,
    id_currency INT REFERENCES currency(id_currency)
);