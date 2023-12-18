CREATE TABLE IF NOT EXISTS transaction (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    transaction_type VARCHAR(10) NOT NULL,
    account_id BIGINT NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES transaction_category(id)
);