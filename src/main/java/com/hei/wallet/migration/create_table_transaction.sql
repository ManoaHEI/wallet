CREATE TYPE TRANSACTION_TYPE AS ENUM('DEBIT', 'CREDIT');

CREATE TABLE IF NOT EXISTS transaction (
    id_transaction SERIAL PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    amount DECIMAL NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    transaction_type VARCHAR CHECK ( transaction_type IN ('DEBIT', 'CREDIT') )
);