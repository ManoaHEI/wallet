CREATE TABLE IF NOT EXISTS account_transaction (
    id_account INT REFERENCES account(id_account),
    id_transaction INT REFERENCES transaction(id_transaction),
    PRIMARY KEY (id_account, id_transaction)
);