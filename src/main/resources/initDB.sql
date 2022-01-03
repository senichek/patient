DROP TABLE IF EXISTS patients;

create table patients(
ID int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(25) NOT NULL,
last_name varchar(25) NOT NULL,
birthdate DATETIME NOT NULL,
sex varchar(25) NOT NULL,
address varchar(25) NOT NULL,
phone varchar(25) NOT NULL
);

insert into patients(first_name, last_name, birthdate, sex, address, phone) values('Test', 'TestNone', '1966-12-31', 'F', '1 Brookside St', '100-222-3333');
insert into patients(first_name, last_name, birthdate, sex, address, phone) values('Test', 'TestBorderline', '1945-06-24', 'M', '2 High St', '200-333-4444');
insert into patients(first_name, last_name, birthdate, sex, address, phone) values('Test', 'TestInDanger', '2004-06-18', 'M', '3 Club Road', '300-444-5555');
insert into patients(first_name, last_name, birthdate, sex, address, phone) values('Test', 'TestEarlyOnset', '2002-06-28', 'F', '4 Valley Dr', '400-555-6666');