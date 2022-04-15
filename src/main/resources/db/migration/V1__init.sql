CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    user_name  VARCHAR(255) UNIQUE         NOT NULL,
    email      VARCHAR(255) UNIQUE         NOT NULL,
    password   VARCHAR(255)                NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    role       VARCHAR(255)                NOT NULL,
    locked     BOOLEAN                     NOT NULL,
    enabled    BOOLEAN                     NOT NULL,

    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE registration_confirm_token
(
    id         SERIAL PRIMARY KEY,
    user_id    SERIAL                      NOT NULL,
    token      VARCHAR(255) UNIQUE         NOT NULL,
    expires_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    CONSTRAINT fk_registration_confirm_token_users
         FOREIGN KEY (user_id)
         REFERENCES users (id)
);