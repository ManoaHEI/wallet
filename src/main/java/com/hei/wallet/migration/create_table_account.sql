CREATE TABLE IF NOT EXISTS Account (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance_amount DECIMAL(15, 2) NOT NULL,
    balance_last_update TIMESTAMP NOT NULL,
    currency_id INT REFERENCES Currency(id),
    type VARCHAR(20) CHECK (type IN ('Bank', 'Cash', 'Mobile Money'))
);