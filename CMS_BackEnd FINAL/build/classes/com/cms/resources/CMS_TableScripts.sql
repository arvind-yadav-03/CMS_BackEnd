drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 1000 increment by 1;


Drop table Customer_Details cascade constraints;
CREATE TABLE Customer_Details(
	custId NUMBER(10)NOT NULL,
    customerName VARCHAR2(30) NOT NULL,
    address VARCHAR2(40) NOT NULL,
    contactNumber NUMBER(10) NOT NULL,
    email VARCHAR2(30) NOT NULL,
    feedback VARCHAR2(50),
    message varchar2(25),
    CONSTRAINT pk_Customer_Details_custId PRIMARY KEY(custId)
);
insert into Customer_Details values(1234,'Vaibhav','Delhi',9582020900,'v@gmail','good','hiiii');
insert into Customer_Details values(1241,'Divya','Kanpur',9410465897,'d@gmail','very good',null);
insert into Customer_Details values(3334,'Kansa','Lucknow',9837006058,'ka@gmail','bad',null);
insert into Customer_Details values(4434,'Krishna','Dwarika',9837307605,'kr@gmail','nice',null);
insert into Customer_Details values(5534,'Gopal','Srinagar',8171593909,'g@gmail','excellent',null);

select * from Customer_Details;

Drop table Employee_Details cascade constraints;
CREATE TABLE Employee_Details
(
	eId NUMBER(10),
    employeeName VARCHAR2(30) NOT NULL,
    address VARCHAR2(40) NOT NULL,
    contactNumber NUMBER(10) unique,
    email VARCHAR2(30) unique,
    password VARCHAR2(20) NOT NULL,
    designation VARCHAR(10) NOT NULL,
    rating NUMBER(2,1) default 0.0,
--    numberofOrders NUMBER(4),
    -- to include rating number of orders will also come into play
    dateOfJoining date default trunc(sysdate),
    message varchar2(25),
    CONSTRAINT pk_Employee_Details_empId PRIMARY KEY(eId)
);

select * from Employee_Details;
--select trunc(sysdate) from dual;
insert into Employee_Details(eId,employeeName,address,contactNumber,email,password,designation,dateOfJoining) 
values(5628231,'Arvind Yadav','ECC-84',9897564789,'arvid','abc@123','SDE','05-Aug-2009');

insert into Employee_Details(eId,employeeName,address,contactNumber,email,password,designation,dateOfJoining) 
values(562826,'Garvit Pathak','ECC-83',8171593909,'garvit','gar@123','Manager','08-Jul-2009');

insert into Employee_Details(eId,employeeName,address,contactNumber,email,password,designation,dateOfJoining) 
values(562827,'Divyansh Bhatnagar','ECC-82',9876544563,'divyansh','div@123','Sales','05-Aug-2010');

insert into Employee_Details(eId,employeeName,address,contactNumber,email,password,designation,dateOfJoining) 
values(562823,'Akash Nigam','ECC-96',9874561456,'akash','ak@123','SDE','14-Aug-2009');

insert into Employee_Details(eId,employeeName,address,contactNumber,email,password,designation,dateOfJoining) 
values(562828,'Manisha Dhyani','ECC-66',7859856598,'manisha','man@123','Manager','22-Jan-2009');

--insert into Employee_Details values (563104,'vaibhav', 'kashipur', '8449411118', 'vaibhav@gmail.com', 'srm123', 'sde', null, null);

Drop table Booking_Details cascade constraints;
CREATE TABLE Booking_Details(
  	billId VARCHAR(10),
  	customerId NUMBER(10) ,
--  	default(3334) REFERENCES Customer_Details(custId),
--  	customerName VARCHAR2(30) NOT NULL,
  	source VARCHAR2(15) NOT NULL, 
  	destination VARCHAR2(15) NOT NULL,
  	sourceDate date default sysdate,
  	destinationDate date default sysdate,
  	status VARCHAR2(20) default('SOURCE'),
  	courierDescription VARCHAR2(30),
  	weight NUMBER(5,2) NOT NULL,
  	amount NUMBER(6,2) NOT NULL,
  	type_package VARCHAR(20),
  	rating NUMBER(2,1) default 0.0,
  	contactNo NUMBER(10) NOT NULL,
    message varchar2(25),
    eId NUMBER(10) REFERENCES Employee_Details(eId),
  	CONSTRAINT pk_Booking_Details_billId PRIMARY KEY(billId), 
  	CONSTRAINT chk_Booking_details_status CHECK (status in ('SOURCE','TRANSIT','DISPATCHED','OUT FOR DELIVERY','DELIVERED')),
  	CONSTRAINT chk_Booking_Details_amount CHECK (amount > 0)
);

--insert into Booking_Details(billId,customerId,customerName,source,destination,status,weight,amount,type_package,contactNo)
--values (1001,1234,'vaibhav','Delhi','Mysore','SOURCE',2,500,'abcd',9582020900);
--
--insert into Booking_Details(billId,customerId,customerName,source,destination,status,weight,amount,type_package,contactNo)
--values (1002,1241,'divya','Kanpur','Chennai','SOURCE',4,1500,'bcde',9410465897);
--
--insert into Booking_Details(billId,customerId,customerName,source,destination,status,weight,amount,type_package,contactNo)
--values (1003,3334,'kansa','Lucknow','Kanyakumari','SOURCE',6,5500,'asdf',9837006058);
--
--insert into Booking_Details(billId,customerId,customerName,source,destination,status,weight,amount,type_package,contactNo)
--values (1004,4434,'krishna','Dwarika','Rampur','SOURCE',3,540,'vbnm',9837307605);
--
--insert into Booking_Details(billId,customerId,customerName,source,destination,status,weight,amount,type_package,contactNo)
--values (1005,5534,'gopal','Srinagar','Meerut','SOURCE',2,5500,'hjkl',8171593909);
--
--
select * from Booking_Details;

Drop table Admin_Details cascade constraints;
CREATE TABLE Admin_Details(
	eId NUMBER(10) primary key NOT NULL references Employee_Details(eId),
	password VARCHAR2(20) NOT NULL
);
insert into Admin_Details(eId,password)values(5628231,'abc@123');
insert into Admin_Details(eId,password)values(562826,'gar@123');
insert into Admin_Details(eId,password)values(562827,'div@123');
insert into Admin_Details(eId,password)values(562823,'ak@123');
insert into Admin_Details(eId,password)values(562828,'man@123');

select * from Admin_Details;

Drop table Contact_Details cascade constraints;
CREATE TABLE Contact_Details(
	contactId NUMBER(5) primary key,
	customerName VARCHAR2(30) NOT NULL,
	employeeAssigned NUMBER(10) default(562823) references Employee_Details(eId),
	contactNumber NUMBER(10)NOT NULL,
	email VARCHAR2(30) NOT NULL,
	description VARCHAR2(30) NOT NULL,
	doj DATE default TRUNC(sysdate),
	location VARCHAR2(30),
	message varchar2(25)
	
);

insert into Contact_Details(contactId,customerName,employeeAssigned,contactNumber,email,description,doj,location)
values(10001,'Cassie',562826,8171593909,'c@gmail.com','bgyhujki g','08-Jul-2009','delhi');

select * from Booking_Details;
--delete from booking_details;
select * from Employee_Details;
Select * from Admin_Details;
select * from Contact_Details;
select * from Customer_Details;
-- need to convert this to api and execute each time a order is placed ;

--update  Employee_Details set rating=(
--select avg(rating) from Booking_details where eId=    5628231) where eId=      5628231;


