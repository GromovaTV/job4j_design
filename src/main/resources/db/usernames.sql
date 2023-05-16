create table username(
	id serial primary key,
	name varchar(255)
);

create table url(
	id serial primary key,
	address varchar(255)
);

create table username_url(
	id serial primary key,
	username_id int references url(id) unique,
	url_id int references username(id) unique
);
