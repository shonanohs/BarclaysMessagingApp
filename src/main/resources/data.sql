insert into Message (id, content) values (100, 'first message');
insert into Message (id, content) values (200, 'second message');
insert into Message (id, content) values (300, 'third message');
insert into Message (id, content) values (400, 'fourth message');

insert into Address (id, line_one, line_two, state, postal_code, country)
values (100, 'line one', 'line two', 'state', 'postcode', 'country');
insert into Phone_Number (id, country_code, number) values (100, '+44', '7469210907');

insert into Person (id, address_id, name) values (100, 100, 'first person');
insert into Person (id, name) values (200, 'second person');
insert into Person (id, name) values (300, 'third person');
insert into Person (id, name) values (400, 'fourth person');