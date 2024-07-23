DROP TABLE people IF EXISTS;

CREATE TABLE people2  (
    person_id BIGINT PRIMARY KEY auto_increment,
    firstname VARCHAR(20),
    lastname VARCHAR(20)
);