create table address(
	id serial primary key,
	street varchar(255),
	house integer
);

create table person(
	id serial primary key,
	name varchar(255)
);

create table person_address(
	id serial primary key,
	person_id int references address(id),
	address_id int references person(id)
);