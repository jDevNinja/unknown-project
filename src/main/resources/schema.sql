CREATE TABLE IF NOT EXISTS app_users
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    login    VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);
