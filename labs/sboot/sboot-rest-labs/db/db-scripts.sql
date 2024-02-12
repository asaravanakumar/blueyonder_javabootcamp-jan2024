--H2 DB Scripts
drop table greetings;
create table greetings(id bigint auto_increment, type varchar(50), message varchar(100), primary key(id));
select * from greetings;
--insert into greetings(type,message) values('farewell', 'Thank You!!!')

--Postgres DB Scripts
drop table greetings;
create table greetings(id bigint serial, type varchar(50), message varchar(100), primary key(id));
select * from greetings;
--insert into greetings(type,message) values('farewell', 'Thank You!!!')