create table teens(
	id serial primary key,
	name varchar(255),
	gender boolean
);

insert into teens(name, gender) values ('Jane', true);
insert into teens(name, gender) values ('John', false);
insert into teens(name, gender) values ('Mave', true);
insert into teens(name, gender) values ('Tom', false);

select t1.name as a, t2.name as b from teens t1 cross join numbers t2;
select * from teens e cross join teens d where e.gender != d.gender and e.gender = true;

