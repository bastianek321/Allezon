CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    name varchar(50) not null,
    surname varchar(50) not null,
    password text not null,
    username varchar not null,
    email text not null,
    birthdate text not null,
    admin boolean ,

    primary key (username)
);