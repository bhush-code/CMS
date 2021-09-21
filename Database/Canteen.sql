drop database if exists CMS61999;

create database CMS61999;

use CMS61999;


DROP TABLE IF EXISTS Vendor;
CREATE TABLE vendor (
  VEN_ID int(10) unsigned NOT NULL AUTO_INCREMENT primary key,
  VEN_NAME varchar(30) NOT NULL,
  VEN_NUMBER varchar(10) NOT NULL,
  VEN_USER_NAME varchar(15) NOT NULL,
  VEN_PASSWORD varchar(30) NOT NULL,
  VEN_EMAIL varchar(30) NOT NULL,
  VEN_ADDRESS varchar(50)
) ;
INSERT INTO VENDOR(VEN_ID,VEN_NAME,VEN_NUMBER,VEN_USER_NAME,VEN_PASSWORD,VEN_EMAIL,VEN_ADDRESS) 
values(1,"Mania","9999999999","mania","mania@123","mania@gmail.com","Jamshedpur"),
 (2,"Sparsha","9888888888","sparsha2","sparsha@123","sparsh@gmail.com","JAIPUR"),
 (3,"Vicky","9777777777","vicky3","vicky@123","vicky@gmail.com","Jodhpur"),
 (4,"Shilpa","9666666666","shilpa4","shilpa@123","shilpa@gmail.com","Bhubaneswar"),
(6,'Maggi',"9555555555",'maggi5','maggi@123','maggi@gmail.com','Bengaluru'),
(7,'Raj',"9571552655",'raj2','raj@011','rajj@gmail.com','Bengaluru'),
(8,'marry',"9985175465",'marry15','marrydit@23','marry123@gmail.com','Bihar'),
(9,'Tom',"915639283",'tomrage11','tomra@99','tomrage22@gmail.com','Maharastra'),
(10,'Sana',"782649611",'sanami7','sanam@79','sanami2@gmail.com','Kerala');
select * from vendor;



DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE Customer (
  CUS_ID int(10) NOT NULL AUTO_INCREMENT,
  CUS_NAME varchar(50) NOT NULL,
  CUS_PHNNO varchar(50) NOT NULL,
  CUS_USERNAME varchar(50) NOT NULL,
  CUS_PASSWORD varchar(50) NOT NULL,
  CUS_EMAIL varchar(50) NOT NULL,
  CUS_DOB date,
  CUS_ADDRESS varchar(100),
  PRIMARY KEY (CUS_ID),
  UNIQUE KEY CUS_PHNNO (CUS_PHNNO),
  UNIQUE KEY CUS_USERNAME (CUS_USERNAME)
);

INSERT INTO CUSTOMER(CUS_ID,CUS_NAME,CUS_PHNNO,CUS_USERNAME,CUS_PASSWORD,CUS_EMAIL,CUS_DOB,CUS_ADDRESS)
VALUES (1,'Nikitha','9000000009','nikhhi','nikhi@123', 'nikhi@gmail.com','1998-07-16','CHENNAI'),
       (2,'Arpita','9111111119','arpita2','arpita@123', 'arpita@gmail.com','1998-08-07','KOLKATA'),
       (3,'Ahalya','9222222229','ahalya3','ahalya@123', 'ahalya@gmmail.com','1996-02-14','BANGLORE'),
       (4,'Amulya','9333333339','amulya4','amulya@123', 'amulya@gmmail.com','1997-08-06','Jodhpur'),
	   (5,'Manya','9333333229','manya1','manya@123', 'manya@gmmail.com','1997-03-06','Bihar'),
	   (6,'Gopi','9333399339','gopi2','gopi@123', 'gopi@gmmail.com','1998-06-02','Mumbai'),
	   (7,'Nani','9333345639','nani','nani@123', 'nani@gmmail.com','1993-06-06','JAMSHEDPUR'),
	   (8,'Rukmini','9773333339','rukmini4','rukmini@123', 'rukmini@gmmail.com','1997-06-01','JAMSHEDPUR'),
	   (9,'Candy','7733333339','candy4','candy4@123', 'candy@gmmail.com','1992-03-06','RAJASTHAN'),
	   (10,'Yeshu','9322333339','yesu','yesu@123', 'yesu@gmmail.com','1997-05-06','Maharastra');
       
select * from customer;


create table Menu(
mid int auto_increment primary key,
MenuName varchar(30),
MenuPrice int,
Rating int);
insert into Menu(Menuname,MenuPrice, Rating)
values("IDLI",40,4),

("Samosa",12,5),
("Dosa",45,3),
("Sambar",33,5),
("Tea",10,4),
("hot coffee",12,4),
("Cold Coffee",25,4),
("Medu Vada",30,2),
("Sandwich",50,4);

Select* from menu;

drop table if exists wallet;
CREATE TABLE WALLET
(
Cus_Id int(10) unsigned DEFAULT NULL references customer(Cus_Id),
Wal_Id int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
Wal_Amount double unsigned NOT NULL,
WalSource Enum('AMAZONPAY','PHONEPAY','GOOGLEPAY','CREDITCARD','DEBITCARD','PAYTM'),
UNIQUE KEY(Cus_Id,WalSource)
);

INSERT INTO WALLET(Cus_Id,Wal_Id,Wal_Amount,WalSource)
values
(1,1,2000,'PAYTM'),
(2,2,8000,'CREDITCARD'),
(3,3,5000,'DEBITCARD'),
(4,4,1500,'GOOGLEPAY'),
(5,5,4500,'DEBITCARD'),
(6,6,6000,'AMAZONPAY'),
(7,7,6000,'PHONEPAY'),
(8,8,6000,'GOOGLEPAY'),
(9,9,6000,'AMAZONPAY');
select* from wallet;


drop table if exists Orders;
create table Orders(
ORD_ID INT (10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
CUS_ID INT(10) unsigned NOT NULL REFERENCES CUSTOMER(CUS_Id),
VEN_ID INT(10) unsigned NOT NULL REFERENCES VENDOR(VEN_ID),
MENU_ID INT(10) NOT NULL REFERENCES MENU(MEN_ID),
ORD_DATE date,
ORD_QTY INT,
ORD_BILLAMOUNT double,
ORD_STATUS ENUM('ACCEPTED','DENIED','PENDING','CANCELLED') DEFAULT 'PENDING',
ORD_COMMENTS varchar(50) DEFAULT NULL);

insert into Orders(ORD_ID,
CUS_ID,VEN_ID,MENU_ID,ORD_DATE,ORD_QTY,ORD_BILLAMOUNT,ORD_STATUS,ORD_COMMENTS)
values(1,1,1,1,"2021-01-22",3,700,"DENIED","Nill"),
(2,1,1,1,"2021-08-22",1,1200,"DENIED","Not ready"),
(3,3,1,2,"2021-01-22",2,5000,"DENIED","Nill"),
(4,4,3,3,"2021-01-22",1,1000,"ACCEPTED","Nill"),
(5,5,5,5,"2021-01-22",7,1000,"ACCEPTED","Nill"),
(6,6,6,3,"2021-01-22",2,1000,"ACCEPTED","Nill"),
(7,7,7,7,"2021-01-22",1,1000,"DENIED","Nill"),
(8,8,8,8,"2021-01-22",1,1000,"ACCEPTED","Nill"),
(9,9,9,7,"2021-01-22",1,1000,"ACCEPTED","Nill"),
(10,8,10,10,"2021-01-22",1,1000,"ACCEPTED","Nill"),
(11,8,10,10,"2021-01-22",1,1000,"PENDING","Nill"),
(12,8,10,10,"2021-01-22",1,1000,"PENDING","Nill");
select* from orderS;
select *from  menu;
select *from wallet;