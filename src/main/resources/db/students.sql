create table students(
	id serial primary key,
	name varchar(255),
	faculty text,
	year integer,
	score numeric
);
insert into students (name, faculty, year, score)
values ('Maria', 'Economy and finance', 2, 4.5);
update students set name = 'Maria Petrova';
delete from students;