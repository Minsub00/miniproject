create table member_info(
	midx int unsigned auto_increment primary key,
	memail varchar(200) not null unique,
	mpass varchar(100) not null,
	mname varchar(10) not null,
	mphone varchar(11) not null,
	magree enum('Y','N') not null default 'N'
);


alter table member_info add join_date timestamp not null default current_timestamp;

desc member_info;

select * from member_info;

select memail from member_info where memail = "test@test.com"