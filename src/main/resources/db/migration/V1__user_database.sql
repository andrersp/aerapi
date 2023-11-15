CREATE TABLE users (
 id SERIAL primary key not null,
 username varchar(100) not null,
 password varchar(255) not null,
 create_on TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
 enable BOOLEAN default  true
);

INSERT into users (username, password) VALUES ('admin', '$2a$10$JTw1DDUAAJ4WenZctgPujui0oF3goyW2zygXtyH0Mk.9g6w6x67ie');