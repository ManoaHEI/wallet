CREATE TABLE IF NOT EXISTS transaction (
    id_transaction SERIAL PRIMARY KEY,
    transaction transaction_type NOT NULL,
    amount FLOAT NOT NULL,
    id_receiver INT REFERENCES account(id_account),
    id_receiver_currency INT REFERENCES currency(id_currency),
    id_sender INT REFERENCES account(id_account),
    id_sender_currency INT REFERENCES currency(id_currency)
);
