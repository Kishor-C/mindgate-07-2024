DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    firstname VARCHAR(20),
    lastname VARCHAR(20)
);