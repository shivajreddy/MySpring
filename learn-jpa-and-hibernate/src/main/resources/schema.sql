-- a simple course table
create table course
(
    id     bigint       not null,
    name   varchar(255) not null,
    author varchar(255) not null,
    primary key (id)

);

CREATE TABLE user_table
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NOT NULL,
    age        INT          NOT NULL,
    subscribed BIT          NOT NULL,
    PRIMARY KEY (id)
);
