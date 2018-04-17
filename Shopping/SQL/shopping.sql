create database shopping;

use shopping;

create table user
(
id int primary key auto_increment,
username varchar(40) unique,
password varchar(16) not null,
phone varchar(40),
addr varchar(255),
rdate datetime
);

create table category
(
id int primary key auto_increment,
name varchar(255) unique,
descr varchar(255),
pid int,
isleaf int, #0表示leaf,1表示非
grade int
);

create table product
(
id int primary key auto_increment,
name varchar(255) unique,
descr varchar(255),
normalprice double not null,
memberprice double not null,
pdate datetime,
categoryid int references category(id)
);

create table salesOrder
(
id int primary key auto_increment,
userid int not null,
addr varchar(255) not null,
odate datetime not null,
status int not null
);

create table salesitem
(
id int primary key auto_increment,productID int not null,
unitprice int not null,
pcount int not null,
orderid int not null
)