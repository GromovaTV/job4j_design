create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	expired_date date, 
	price int,
	type_id int
);

insert into type(name) values('Сыр');
insert into type(name) values('Молоко');
insert into type(name) values('Творог');
insert into type(name) values('Мороженое');

insert into product(name, expired_date, price, type_id) 
values('Сыр моцарелла', date '2023-05-25', 150, 1);
insert into product(name, expired_date, price, type_id) 
values('Сыр моцарелла', date '2023-05-16', 150, 1);
insert into product(name, expired_date, price, type_id) 
values('Сыр пармезан', date '2023-06-25', 200, 1);
insert into product(name, expired_date, price, type_id) 
values('Сыр российский', date '2023-06-20', 150, 1);
insert into product(name, expired_date, price, type_id) 
values('Сыр российский', date '2023-05-15', 150, 1);
insert into product(name, expired_date, price, type_id) 
values('Сыр плавленный', date '2023-05-15', 100, 1);
insert into product(name, expired_date, price, type_id) 
values('Сыр плавленный', date '2023-06-15', 100, 1);

insert into product(name, expired_date, price, type_id) 
values('Молоко', date '2023-05-25', 90, 2);
insert into product(name, expired_date, price, type_id) 
values('Молоко', date '2023-05-16', 90, 2);

insert into product(name, expired_date, price, type_id) 
values('Творог домашний', date '2023-05-25', 90, 3);
insert into product(name, expired_date, price, type_id) 
values('Творог обезжиренный', date '2023-05-16', 90, 3);

insert into product(name, expired_date, price, type_id) 
values('Мороженое пломбир', date '2023-05-25', 50, 4);
insert into product(name, expired_date, price, type_id) 
values('Шоколадное мороженое', date '2023-05-25', 50, 4);

select * from product p join type as t 
on p.type_id = t.id and t.name = 'Сыр';

select * from product where LOWER(name) like '%мороженое%';
select * from product where expired_date < current_date;
select * from product where price = (select max(price) from product);

select *, t.name as Тип from product p join type as t on p.type_id = t.id;

select t.name as Тип, count(p.type_id) as Количество from product p
join type as t on p.type_id = t.id group by t.name;

select * from product p join type as t 
on p.type_id = t.id and (t.name = 'Сыр' or t.name = 'Молоко');

select t.name from type t join product as p 
on p.type_id = t.id
group by t.name 
having count(p.type_id) < 10;