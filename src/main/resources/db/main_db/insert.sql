insert into role (name) values('customer');
insert into rules (name) values('common');
insert into state (name) values('processing');
insert into category (name) values('order');

insert into users(name, role_id) values('Ivan', 8);
insert into item(name, users_id, category_id, state_id)
values('request', 4, 5, 5);
insert into attache(name, item_id) values('photo', 5);
insert into role_rules (rules_id, role_id) values(8, 8);