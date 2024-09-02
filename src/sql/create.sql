create table person(
    id serial primary key,
    "name" varchar(200),
    age int
)

insert into person("name", age)
values
('Tom', 20),
('Jerry', 30),
('Jack', 25),
('Jim', 23),
('Jane', 27)

create table person2(
    id int primary key,
    "name" varchar(200),
    age int
)

create sequence person2_id_seq
