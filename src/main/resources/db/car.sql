create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table gearbox(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);

insert into body(name) values ('body1');
insert into body(name) values ('body2');
insert into body(name) values ('body3');

insert into engine(name) values ('A');
insert into engine(name) values ('B');
insert into engine(name) values ('C');

insert into gearbox(name) values ('gearbox1');
insert into gearbox(name) values ('gearbox2');
insert into gearbox(name) values ('gearbox3');

insert into car(name, body_id, engine_id, gearbox_id) 
values ('Audi', 1, 1, 2);

insert into car(name, body_id, engine_id, gearbox_id) 
values ('BMW', 2, 1, 2);

insert into car(name, body_id, gearbox_id) 
values ('Lada', 2, 1);

select c.name as Машина, b.name as Кузов, e.name as Двигатель,
gb.name as Коробка_передач from car c 
left join body b on c.body_id = b.id
left join engine e on c.engine_id = e.id
left join gearbox gb on c.gearbox_id = gb.id;

select b.name from body b left join car c on c.body_id = b.id
where c.id is null;

select e.name from engine e left join car c on c.engine_id = e.id
where c.id is null;

select gb.name from gearbox gb left join car c on c.gearbox_id = gb.id
where c.id is null;
