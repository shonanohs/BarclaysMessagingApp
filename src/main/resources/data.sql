insert into Message (id, content) values (100, 'message 1');
insert into Message (id, content) values (200, 'message 2');
insert into Message (id, content) values (300, 'message 3');
insert into Message (id, content) values (400, 'message 4');

insert into Address (id, line_one, line_two, state, postal_code, country)
values (100, 'line one', 'line two', 'state', 'postcode', 'country');
insert into Phone_Number (id, country_code, number) values (100, '+44', '7469210907');

insert into Person (id, address_id, name) values (100, 100, 'Person 1');
insert into Person (id, name) values (200, 'Person 2');
insert into Person (id, name) values (300, 'Person 3');
insert into Person (id, name) values (400, 'Person 4');