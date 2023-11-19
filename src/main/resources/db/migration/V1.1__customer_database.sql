CREATE TABLE customers (
    id BIGSERIAL primary key not null,
    name varchar(255) not null,
    phone varchar(14) not null unique,
    obs varchar(255)
);