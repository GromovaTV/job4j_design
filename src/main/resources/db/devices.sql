create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table devices_people(
	id serial primary key,
	device_id int references devices(id),
	people_id int references people(id)
);

insert into devices(name, price) values('phone', 20000);
insert into devices(name, price) values('headphones', 4000);
insert into devices(name, price) values('watch', 15000);
insert into devices(name, price) values('laptop', 50000);

insert into people(name) values('Petr');
insert into people(name) values('Pavel');
insert into people(name) values('Ivan');

insert into devices_people(people_id, device_id) values(1, 1);
insert into devices_people(people_id, device_id) values(1, 2);
insert into devices_people(people_id, device_id) values(1, 3);

insert into devices_people(people_id, device_id) values(2, 2);

insert into devices_people(people_id, device_id) values(3, 1);
insert into devices_people(people_id, device_id) values(1, 4);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;