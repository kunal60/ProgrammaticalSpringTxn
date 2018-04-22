create table Account
(
 AccNo int PRIMARY KEY,
BAL int NOT NULL
);

create table User_Table
(
user_Id int NOT NULL PRIMARY KEY,
Name varchar(30) NOT NULL,
Account_Id int,
CONSTRAINT FK_UserTable FOREIGN KEY (Account_Id)
    REFERENCES Account(AccNo)
);

create table Movie_Ticket
(
Ticket_Id int NOT NULL PRIMARY KEY,
Ticket_Price int NOT NULL ,
Ticket_Count int NOT NULL 
);


Insert into ACCOUNT values(1001,3000);
Insert into ACCOUNT values(1002,5000);

Insert into User_Table values(9001,'Sekhar',1001);
Insert into User_Table values(9002,'Somu',1002);

Insert into Movie_Ticket values(5001,45,300);
Insert into Movie_Ticket values(5002,30,150);

commit;


select * from ACCOUNT;
select * from User_Table;
select * from Movie_Ticket;

