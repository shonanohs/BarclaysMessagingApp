insert into Address (id, line_one, line_two, state, postal_code, country)
values (1000, 'line one', 'line two', 'state', 'postcode', 'country');

insert into Person (id, address_id, name) values (100, 1000, 'first person');
insert into Person (id, name) values (200, 'second person');
insert into Person (id, name) values (300, 'third person');
insert into Person (id, name) values (400, 'fourth person');

insert into Message (id, content, sender_id) values (150, 'first message', 100);
insert into Message (id, content, sender_id) values (250, 'second message', 100);
insert into Message (id, content, sender_id) values (350, 'third message', 200);
insert into Message (id, content, sender_id) values (450, 'fourth message', 200);

