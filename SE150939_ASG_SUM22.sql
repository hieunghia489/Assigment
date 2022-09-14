CREATE DATABASE SE150939_ASSIGMENT_SUM22;
USE [se150939_Assigment_sum22];
create table tblUsers(
username nvarchar(20) primary key,
password varchar(10) not null,
fullName Nvarchar(50) not null,
isAdmin bit
);
go
create table tblCourses(
courseName Nvarchar(20) primary key,
imageCourse Nvarchar(max),
description nvarchar(50),
tuitionFee money,
category varchar(20),
createDate date,
startDate date,
endDate date,
lastUpdateDate date,
lastUpdateUser nvarchar(20) foreign key references tblUsers(username),
createUser nvarchar(20) foreign key references tblUsers(username),
status bit default 1,
quantity int,
maxQuantity int
);
go
create table tblBooking(
ID int identity(1,1) primary key,
username nvarchar(20) foreign key references tblUsers(username),
bookDate date,
totalFee money,
);
go
create table tblBookingDetail(
ID int identity (1,1) primary key,
courseName Nvarchar(20) foreign key references tblCourses(courseName),
quantity int,
startDate date,
endDate date,
maxQuantity int,
status bit default 1,
bookingID int foreign key references tblBooking(ID),
fee int
);
go
insert into tblUsers (username,password,fullName,isAdmin) values (N'admin','123456',N'Lê Hiếu Nghĩa',1);
insert into tblUsers (username,password,fullName,isAdmin) values (N'user','123456',N'Thi Nhật Nam',0);
insert into tblUsers (username,password,fullName,isAdmin) values (N'nam123','123456',N'Mai Duy Nam',0);
insert into tblUsers (username,password,fullName,isAdmin) values (N'nghieu123','123456',N'Hàng Sở Nghiêu',0);
insert into tblUsers (username,password,fullName,isAdmin) values (N'duc123','123456',N'Trần Minh Đức',0);
go
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Piano001',	'https://bom.so/6MFXvP',	'Piano for beginner',	2000000.0000	,'Piano',	'2022-08-20',	'2022-08-20',	'2022-09-17',	'2022-08-20',	'admin',	'admin',	1	,0	,10);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Piano002',	'https://bom.so/GBHnRq',	'Piano for level 1',	4000000.0000	,'Piano',	'2022-08-20',	'2022-08-25',	'2022-09-22',	'2022-08-20',	'admin',	'admin',	1	,0	,10);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Piano003',	'https://bom.so/J4Q338',	'Piano for level 2',	5000000.0000	,'Piano',	'2022-08-20',	'2022-08-23',	'2022-09-20',	'2022-08-20',	'admin',	'admin',	1	,0	,10);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Guitar001',	'https://bom.so/fXIRle',	'Guitar for beginner',	3000000.0000	,'Guitar',	'2022-08-20',	'2022-08-20',	'2022-09-17',	'2022-08-20',	'admin',	'admin',	1	,0	,5);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Guitar002',	'https://bom.so/kaD2dF',	'Guitar for level 1',	4000000.0000	,'Guitar',	'2022-08-20',	'2022-08-25',	'2022-09-22',	'2022-08-20',	'admin',	'admin',	1	,0	,5);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Guitar003',	'https://bom.so/vwyrtv',	'Guitar for level 2',	5000000.0000	,'Guitar',	'2022-08-20',	'2022-08-23',	'2022-09-20',	'2022-08-20',	'admin',	'admin',	1	,0	,5);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Drawing001',	'https://bom.so/dzMf3s',	'Drawing for beginner',	1000000.0000	,'Drawing',	'2022-08-20',	'2022-08-20',	'2022-09-17',	'2022-08-20',	'admin',	'admin',	1	,0	,20);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Drawing002',	'https://bom.so/dw9ez3',	'Drawing for level 1',	1500000.0000	,'Drawing',	'2022-08-20',	'2022-08-22',	'2022-09-19',	'2022-08-20',	'admin',	'admin',	1	,0	,15);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Drawing003',	'https://bom.so/6tfoyH',	'Drawing for level 2',	2000000.0000	,'Drawing',	'2022-08-20',	'2022-08-24',	'2022-09-21',	'2022-08-20',	'admin',	'admin',	1	,0	,10);
insert into tblCourses (courseName,imageCourse,description,tuitionFee,category,createDate,startDate,endDate,lastUpdateDate,lastUpdateUser,createUser,status,quantity,maxQuantity) values ('Drawing004',	'https://bom.so/P2AFdc',	'Drawing for teacher',	2500000.0000	,'Drawing',	'2022-08-20',	'2022-08-26',	'2022-09-22',	'2022-08-20',	'admin',	'admin',	1	,0	,5);

go
select * from tblUsers
select * from tblBooking
select * from tblBookingDetail
select * from tblCourses

