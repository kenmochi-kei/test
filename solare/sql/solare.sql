drop database if exists solare;

create database if not exists solare;
use solare;

drop table if exists customer_info;

create table user(
id int not null auto_increment,
user_id varchar(25) unique,
user_name varchar(255),
password varchar(255),
user_kana varchar(255),
gender enum('male','female'),
birthday date,
email varchar(255),
credit_number varchar(4),
credit_token varchar(255),
oauth_id varchar(50),
oauth_name varchar(50),
registration_date datetime,
updated_date datetime,
postal_code varchar(8),
address varchar(100),
cell_number varchar(15),
primary key(id)
);

insert into user values
(1,"kazami@internous.co.jp","風見顕","internous01","カザミ",'male',"2000-01-01 01:00:00","kazami@internous.co.jp","0000","","","","2016-03-14 01:00:00","2016-03-14 01:00:00","1111111","東京都文京区湯島1-1-1","08011111111"),
(2,"hyodo@internous.co.jp","兵藤慶征","internous01","ヒョウドウ",'male',"2000-01-02 01:00:00","hyodo@internous.co.jp","0001","","","","2016-03-14 01:00:01","2016-03-14 01:00:01","1111112","東京都文京区湯島1-1-2","08011111112"),
(3,"t.inoue@internous.co.jp","井上琢磨","internous01","イノウエ",'male',"2000-01-03 01:00:00","t.inoue@internous.co.jp","0002","","","","2016-03-14 01:00:02","2016-03-14 01:00:02","1111113","東京都文京区湯島1-1-3","08011111113");

create table customer_info(
account_number int(10) primary key auto_increment,
customer_id varchar(30) unique,
acc_password varchar(30),
user_uuid varchar(100),
last_name varchar(255),
first_name varchar(255),
customer_mailaddress varchar(255),
customer_gender int(1),
phone_number varchar(30),
register_date timestamp DEFAULT 0,
update_date timestamp DEFAULT current_timestamp on update current_timestamp
);

drop table if exists customerid_info;

create table customerid_info(
customerID_number int(10) primary key auto_increment,
customer_id varchar(30),
user_uuid varchar(100),
insert_date timestamp,
delete_date timestamp
);

drop table if exists reservation_info;

create table reservation_info(
reservation_number int(10) primary key auto_increment,
customer_reservation_number int(1),
account_number int(10),
course_number int(20),
number_of_ppl int(10),
full_name varchar(50),
phone_number varchar(30),
reservation_date timestamp default 0,
reservation_dayofweek int(5),
reservation_time int(5),
register_date timestamp default 0,
update_date timestamp default current_timestamp on update current_timestamp,
delete_date timestamp
);

drop table if exists seat_info;

create table seat_info(
date date,
dayofweek int(1),
max_number_of_ppl int(5),
remaining_seats int(5)
);