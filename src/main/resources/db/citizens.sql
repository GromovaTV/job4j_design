create table country(
	id serial primary key,
	name varchar(255)
);

create table citizen(
	id serial primary key,
	name varchar(255),
	country_id int references country(id)
);

insert into country(name) values ('USA');
insert into country(name) values ('Germany');
insert into country(name) values ('Italy');

insert into citizen(name, country_id) values ('Tom', 1);
insert into citizen(name, country_id) values ('Jane', 1);
insert into citizen(name, country_id) values ('Genry', 2);
insert into citizen(name, country_id) values ('Anna', 2);
insert into citizen(name, country_id) values ('Christina', 2);
insert into citizen(name, country_id) values ('Tyler', 3);
insert into citizen(name, country_id) values ('Paula', 3);

select pp.name as Имя, p.name as Страна from citizen as pp
join country as p
on pp.country_id = p.id;

select pp.name as Имя, p.name as Страна from citizen as pp
join country as p
on pp.country_id = p.id and p.id = 2;

select pp.name as Имя, p.name as Страна from citizen as pp
join country as p
on pp.country_id = p.id and pp.name like 'T%';