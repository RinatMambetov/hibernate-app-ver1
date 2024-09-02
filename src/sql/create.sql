create table person(
    id serial primary key,
    "name" varchar(200),
    age int
)

insert into person(id, "name", age)
values
(1, 'Tom', 20)

create table person2(
    id int primary key,
    "name" varchar(200),
    age int
)

create sequence person2_id_seq
