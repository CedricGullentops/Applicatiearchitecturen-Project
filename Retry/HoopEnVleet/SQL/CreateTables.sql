/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jarrit
 * Created: 07-Nov-2018
 */

drop table Reservaties purge;
drop table Plaatsen purge;
drop table Klanten purge;
drop table Shows purge;

create table Klanten(
    email         varchar2(50) primary key,
    naam         varchar2(50),
    paswoord  varchar2(20)
);

create table Shows(
    showid      integer primary key,
    naam        varchar2(20),
    dag         date
);

create table Plaatsen(
    plaatsid    integer primary key,
    prijs           integer,
    rij               integer,
    kolom       integer,
    vrij            char,
    showid     integer references Shows
);

create table Reservaties(
    code         integer primary key,
    locked      char(1),
    email        varchar2(50) references Klanten,
    plaatsid    integer references Plaatsen,
    showid      integer references Shows
);