CREATE TABLE categories (
 id SERIAL primary key not null,
 name varchar(100) not null
);

INSERT INTO categories(name) VALUES
('caneca'),
('camisa');

CREATE TABLE products (
   id SERIAL primary key not null,
   name varchar(255) not null,
   sale_value NUMERIC(6,2) not null,
   minimum_stock INTEGER not null default 0,
   category_id INTEGER not null,
   CONSTRAINT fk_category
     FOREIGN KEY(category_id)
       REFERENCES categories(id)
);