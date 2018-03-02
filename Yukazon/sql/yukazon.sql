-- SQLを日本語で表示させる
set names utf8;
-- 外部キー制約,=0で子テーブルからしか削除できない設定
set foreign_key_checks = 0;

-- もし"yukazon"というデータベースがあったら削除
drop database if exists yukazon;
-- もし"yukazon"というデータベースが存在しないなら作成
create database if not exists yukazon;
-- 作成した"yukazon"を使用する
use yukazon;

-- もし"login_user_transaction"というテーブルがあったら削除
drop table if exists login_user_transaction;
-- "login_user_transaction"というテーブルを作成
create table login_user_transaction(
-- 外部キー制約を設定したのでprimary keyと同時にnot nullも設定する(重複しては×な為)
-- テーブルの中でprimary keyは1つしか設定できない。
-- このテーブルではidをMySQLが自動にint値を割り当てるように設定
id int not null primary key auto_increment,
-- "login_id"は文字列30字制限,uniqueを付けると重複する値は格納できなくなる
login_id varchar(30) unique,
login_pass varchar(30),
seacret_question varchar(30),
seacret_answer varchar(30),
-- "insert_date"にdatetime(フォーマット"YYYY-MM-DD HH:MM:SS")を入れる
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);


-- insert into テーブル名(カラム名, カラム名, カラム名)
--     values(“挿入するデータ”, ”挿入するデータ”, ”挿入するデータ”);
INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES
("ギフトカード1000円分", 1000, 10),
("ギフトカード3000円分", 3000, 10),
("ギフトカード5000円分", 5000, 10),
("NoteBook", 30000, 5),
("Charger", 1000, 50),
("Case", 5000, 10);
-- 管理者設定
INSERT INTO login_user_transaction(login_id, login_pass, seacret_question,seacret_answer) VALUES
("internous", "internous01", "好きな食べ物は？","いちご"),
("yukazon", "123123", "好きな食べ物は？","いちご");