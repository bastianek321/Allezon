CREATE TABLE parameter
(
    id   serial primary key,
    name text not null
);
CREATE TABLE section
(
    id   serial primary key,
    name text not null
);
CREATE TABLE category
(
    id          serial primary key,
    name        text not null,
    sectionId   int references section (id)
);
CREATE TABLE auction
(
    id          serial primary key,
    title       text   not null,
    description text   not null,
    price       float not null,
    categoryId  int references category (id),
    owner text references profile (username)
);
CREATE TABLE photos
(
    id        serial primary key,
    path      text not null,
    auctionId int REFERENCES auction (id)
);
CREATE TABLE auction_parameter
(
    value text  not null ,
    auctionId int references auction(id),
    parameterId int references parameter(id),

    PRIMARY KEY (parameterId, auctionId)
);