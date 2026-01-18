CREATE TABLE app_user (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(120) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE wallet (
                        id BIGSERIAL PRIMARY KEY,
                        user_id BIGINT NOT NULL UNIQUE REFERENCES app_user(id),
                        balance_cents BIGINT NOT NULL DEFAULT 0 CHECK (balance_cents >= 0),
                        currency VARCHAR(3) NOT NULL DEFAULT 'CAD',
                        created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE wallet_txn (
                            id BIGSERIAL PRIMARY KEY,
                            wallet_id BIGINT NOT NULL REFERENCES wallet(id),
                            type VARCHAR(20) NOT NULL,
                            amount_cents BIGINT NOT NULL CHECK (amount_cents > 0),
                            note VARCHAR(255),
                            related_wallet_id BIGINT,
                            created_at TIMESTAMP NOT NULL DEFAULT NOW()
);
