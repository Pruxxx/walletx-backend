CREATE TABLE transaction (
                             id BIGSERIAL PRIMARY KEY,
                             wallet_id BIGINT NOT NULL,
                             type VARCHAR(20) NOT NULL,
                             amount_cents BIGINT NOT NULL,
                             balance_after BIGINT NOT NULL,
                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT fk_transaction_wallet
                                 FOREIGN KEY (wallet_id)
                                     REFERENCES wallet(id)
);
