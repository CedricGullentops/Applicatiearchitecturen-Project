drop table Klanten purge;
drop table Groepen purge;
drop table Shows purge;
drop table Plaatsen purge;
drop table Reservaties purge;

create table Klanten(
    email       varchar2(50) primary key,
    naam 	varchar2(50),
    paswoord	varchar2(50)	
);

create table Groepen (
    gebruikersnaam varchar2(50) references Klanten primary key,
groep varchar2(50) );

create table Shows(
    showid     integer primary key,
    naam       varchar2(20),
    dag        date
);

create table Plaatsen(
    plaatsid    integer primary key,
    kolom	integer,
    rij		integer,
    prijs	integer 	
);


create table Reservaties(
    code        varchar2(12) primary key,
    locked      bool,    
    showid      integer references Shows,
    plaatsid    integer references Plaatsen,
    email       varchar2(50) references Klanten,
);

insert into Klanten values ('cedricgullentops@hotmail.com', 'Cédric Gullentops', 'admin');
insert into Klanten values ('jarritboons@gmail.be', 'Jarrit Boons', 'admin');
insert into Klanten values ('janjannsens@gmail.be', 'Jan Jannsens','test');

insert into Groepen values ('cedricgullentops@hotmail.com', 'Beheerders' );
insert into Groepen values ('jarritboons@gmail.be', 'Beheerders' );
insert into Groepen values ('janjannsens@gmail.be', 'Klanten' );
