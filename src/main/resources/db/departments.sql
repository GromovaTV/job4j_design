create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	dep_id int references departments(id)
);

insert into departments(name) values('IT');
insert into departments(name) values('Finance');
insert into departments(name) values('Security');

insert into employees(name, dep_id) values ('Jane', 1);
insert into employees(name, dep_id) values ('John', 1);
insert into employees(name, dep_id) values ('Mary', 1);

insert into employees(name, dep_id) values ('Courtney', 2);
insert into employees(name, dep_id) values ('Hannah', 2);


select * from employees e left join departments d on e.dep_id = d.id;
select * from departments d right join employees e on e.dep_id = d.id;
select * from employees e cross join departments d;
select * from departments d full join employees e on e.dep_id = d.id;

select * from employees e left join departments d on e.dep_id = d.id;
select * from employees e right join departments d on e.dep_id = d.id 
where e.name is not null;

select d.id, d.name from employees e right join departments d on e.dep_id = d.id
where e.name is null;
