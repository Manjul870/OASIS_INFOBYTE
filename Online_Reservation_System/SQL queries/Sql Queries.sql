Create Database OnlineReservationSystem; 
use OnlineReservationSystem;

-- create LoginDetails Table
create table LoginDetails(Login_Id varchar(255) primary key not null,Password varchar(255) not null);

select * from Logindetails;
insert into LoginDetails (Login_Id,password) Values ("Manjul","admin@123");
select * from trains;

-- create Train Table
create table trains(train_number int primary key,train_name varchar(100) not null);

-- Insert the Details of Trains
INSERT INTO Trains (train_number, train_name) VALUES
(12001, 'Shatabdi Express'),
(12002, 'Bhopal Shatabdi'),
(12295, 'Sanghamitra Express'),
(12951, 'Mumbai Rajdhani Express'),
(12952, 'New Delhi Rajdhani Express'),
(12622, 'Tamil Nadu Express'),
(12627, 'Karnataka Express'),
(12693, 'Pearl City Express'),
(12655, 'Navjeevan Express'),
(12657, 'Bangalore Mail'),
(12423, 'Rajdhani Express'),
(12802, 'Purushottam Express'),
(12721, 'Dakshin Express'),
(12780, 'Goa Express'),
(12302, 'Howrah Rajdhani Express'),
(12393, 'Sampoorna Kranti Express'),
(12565, 'Bihar Sampark Kranti Express'),
(12488, 'Seemanchal Express'),
(12650, 'Karnataka Sampark Kranti Express'),
(12953, 'August Kranti Rajdhani Express'),
(12269, 'Chennai Duronto Express'),
(12860, 'Gitanjali Express'),
(12616, 'Grand Trunk Express'),
(12647, 'Kongu Express'),
(12673, 'Cheran Express'),
(12839, 'Chennai Mail'),
(12601, 'Pallavan Express'),
(12296, 'Sanghamitra Express');

-- create Reservation Table
create table Reservation(
	id int auto_increment primary key,
	passenger_name varchar(100),
	age INT,
	gender varchar(10),
    train_number int,
    train_name varchar(100),
    class_type varchar(50),
    journey_date date,
    from_Station varchar(100),
    to_Station varchar(100)
);