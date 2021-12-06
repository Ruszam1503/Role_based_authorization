DROP TABLE IF EXISTS users_roles CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;

DROP TABLE IF EXISTS products;

CREATE TABLE users
(
    user_id             BIGSERIAL PRIMARY KEY,
    user_name           VARCHAR  NOT NULL,
    email          VARCHAR  NOT NULL,
    password          VARCHAR  NOT NULL,
    enabled          BOOLEAN  NOT NULL
);

CREATE TABLE products
(
    product_id             BIGSERIAL PRIMARY KEY,
    product_name           VARCHAR(60)  NOT NULL,
    category          VARCHAR(60)  NOT NULL,
    price  VARCHAR(60)  NOT NULL
);

CREATE TABLE roles
(
    role_id             BIGSERIAL PRIMARY KEY,
    role_name           VARCHAR(60)  NOT NULL
);

CREATE TABLE users_roles (
                              user_id    int REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE CASCADE
    , role_id int REFERENCES roles (role_id) ON UPDATE CASCADE ON DELETE CASCADE
    , CONSTRAINT user_roles PRIMARY KEY (user_id, role_id)
);

