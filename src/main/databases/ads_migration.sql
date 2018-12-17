USE adlister_db;

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS ads;

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username  VARCHAR(50) NOT NULL,
  email  VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email),
  UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED,
  description  TEXT NOT NULL,
  title VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);