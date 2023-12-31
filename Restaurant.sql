create database Restaurant;
use Restaurant;


create table CUSTOMER
( Cust_id char(9) primary key NOT NUll, 
Name varchar(15) NOT NULL,
Phone_number char(12)
);

create table MENU
(Menu_id char(9) NOT NULL,
Category varchar(10),
primary key(Menu_id)
);

 create table STAFF
 (
 Id char(9)  primary key NOT NULL,
 Name varchar(15) NOT NULL,
 Phone_number char(12),
 Birth_date Date,
 Work_hours decimal(3,1),
 Role varchar(15) ,
 Monthly_salary decimal(10,2) , 
 Branch_id char(9),
 Super_id char(9)
 );

drop table IN_CHARGE_OF;
drop table STAFF;


alter table STAFF add Super_id char(9);
alter table STAFF add constraint  foreign key(Super_id) references STAFF(Id);

create table RESTORDER
(
Order_id char(9),
Cust_id char(9),
Num_of_items int,

primary key(Order_id)
);
drop table RECEIPT;

create table RECEIPT
(Receipt_number char(15),
Order_id char(9),
Order_type char(8),
Tax decimal(5,2) ,
Payment_method varchar(10),
Total_amount decimal(10,2),
Date date,

primary key(Receipt_number,Order_id),
foreign key(Order_id) references RESTORDER(Order_id)
);




create table RESTTABLE (
Table_num  int ,
Aval_status boolean NOT NULL,
Num_seats int NOT NULL,
primary key(Table_num)
);


create table IN_CHARGE_OF(
Staff_id char(9),
Table_num INT, 
primary key(Staff_id,Table_num),
foreign key(Staff_id) references STAFF (Id),
foreign key(Table_num) references RESTTABLE (Table_num)
);

create table item(
item_id char(9) ,
Menu_id char(9),
Name varchar(15),
Price decimal(5,2),
primary key(item_id),
foreign key(Menu_id) references MENU(Menu_id)
);

create table CONTAINED_BY(
Item_id char(9),
Order_id char(9),
Date Date,
Time Time,
primary key (Item_id,Order_id,Date,Time),
foreign key(Order_id) references RESTORDER(Order_id)
);

select * from RECEIPT;





create table SUPPLIER(
Id char(9) primary key NOT NULL,
Name varchar(15) NOT NULL,
Phone_number char(12)
);

create table BRANCH (
Id char(9) primary key NOT NULL,
Location varchar(25) NOT NULL,
Phone_number char(12)
);
alter table BRANCH drop column Working_hours;


create table CONTRACTS(
Sid char(9) ,
Bid char(9) ,
Start_date Date NOT NULL,
End_date Date NOT NULL,
foreign key(Sid) references SUPPLIER (Id),
foreign key(Bid) references BRANCH (id),
primary key(Sid,Bid)
);

create table TABLE_ORDER(
Table_num INT ,
Order_id char(9) ,
primary key(Table_num,Order_id),
foreign key(Table_num) references RESTTABLE (Table_num),
foreign key(Order_id) references BRANCH (Id));

create table RESERVED_BY(
Table_num INT ,
Cust_id char(9) ,
Date Date,
Time Time,
primary key(Table_num,Cust_id),
foreign key(Table_num) references RESTTABLE (Table_num),
foreign key(Cust_id) references CUSTOMER (Cust_id));

insert into STAFF values ('111222333', 'noura' , '966555555555' , '1980-09-12', '23.0' ,'chef'
 , 5000.00,null,null);

insert into STAFF values ('444222633', 'sarah' , '966655544455' , '2002-08-12', '26.0' ,'chef'
 , 50000.00,null,null);



select*from STAFF;

drop view MANAGER;



select * from CUSTOMER;

delete from STAFF where '111222633';

insert into STAFF values ('444222633', 'sarah' , '966655544455' , '2002-08-12', '26.0' ,'chef'
 , 50000.00,null,null);
select * from SUPPLIER;
update STAFF set Super_id='111222633' where Id='111222333'; 

insert into BRANCH values ( '000000001' , 'Riyadh' , '966557544455'   );
insert into SUPPLIER values('222222220' , 'ahmad', '966558544455');

select Name,Order_id,Num_of_items from CUSTOMER natural join RESTORDER ;

select s.Id as Supplier_id , b.Id as Branch_id , Name as Supplier_name from CONTRACTS, BRANCH as b , SUPPLIER as s where b.Id = Bid and s.Id = Sid ;


select s.Id, Location from STAFF as s , BRANCH as b where s.Branch_id = b.Id;
select c.Cust_id,Name,Payment_method , Total_amount from RECEIPT as r , RESTORDER as o, CUSTOMER as c where
r.Order_id = o.Order_id and c.Cust_id = o.Cust_id;

select Name from STAFF where Id = '444222633';
select avg (Monthly_salary) from STAFF where Role = 'Manager';
update STAFF set Monthly_salary = 7000 where Id = '444222633';
update STAFF set Phone_number = '966554455111' where Id = '444222633';
delete from STAFF where Id = '444222633';
delete from SUPPLIER where Id = '222222220';
select * from Table_order;

create view ORDER_OP as
select Table_num , Name as item_name , num_of_items , Order_id , Phone_number
from CONTAINED_BY natural join Table_order natural join ITEM natural join RESTORDER natural join Customer;

insert into MENU values ('987654321','sweets');
insert into ITEM value('123456780','987654321','chocolate',100);
insert into CUSTOMER values('442201375','noura',966590272822);

insert into ITEM value('123453780','987655321','burger',100);
insert into ITEM value('123453781','987655321','cheese',100);
insert into MENU values ('987655321','main');
select Category,count(*) as count_items_inmenu from ITEM natural join MENU group by Category;


update ITEM 
set  price = 40
where item_id = '123456780';


select s.Id,Location from STAFF as s,BRANCH as b where s.Branch_id=b.Id;

DELETE FROM MENU 
WHERE Menu_id = '987654321';

insert into ORDER_OP 
(Table_num , item_name , num_of_items , Order_id, Phone_number)
values (1 , 'burger' , 3 ,'100234567','0537576158');