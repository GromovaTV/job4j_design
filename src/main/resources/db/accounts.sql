create table client(
  id serial primary key,
  name varchar(255)
);

create table account(
  id serial primary key,
  number integer,
  position_id int references client(id)
);

insert into client(name) values ('Ivan Petrov');
insert into account(number, position_id) VALUES (123456, 1);
