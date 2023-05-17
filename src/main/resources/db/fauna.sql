create table fauna (
id serial primary key,
name text,
avg_age int,
discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('fish', 15000, date '1940-09-10');
insert into fauna(name, avg_age, discovery_date) values('fish2', 9000, null);
insert into fauna(name, avg_age, discovery_date) values('wolf', 50000, date '1940-09-10');
insert into fauna(name, avg_age, discovery_date) values('fox', 9000, null);

select * from fauna where name like '%fish%';
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';