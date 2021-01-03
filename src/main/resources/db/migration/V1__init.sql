CREATE TABLE user_account
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL
);

INSERT INTO user_account VALUES (1, 'dmitri');
SELECT setval('user_account_id_seq', 1, true);