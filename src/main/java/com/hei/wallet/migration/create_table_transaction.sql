CREATE TABLE IF NOT EXISTS Transaction (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    transaction_type VARCHAR(10) CHECK (transaction_type IN ('Debit', 'Credit')),
    account_id INT REFERENCES Account(id)
);