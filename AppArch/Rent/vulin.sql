drop table e_deelname purge;
drop table e_persoon purge;

create table Klanten(
    knr         integer primary key,
    adres       varchar2(50),
    knaam       varchar2(50),
    gemeente    varchar2(50),
    postcode    integer
    );

create table Reservaties(
    rnr         integer primary key,
    datumres    date,
    datumvan    date,
    dagen       integer,
    
    lnrv        integer references Locaties,
    wnr         integer references Wagens,
    knr         integer references Klanten,
    lnrn        integer references Locaties
    );

create table Wagens(
    wnr         integer primary key,
    wnaam       varchar2(20),
    prijs       integer
    );

create table Locaties(
    lnr         integer primary key,
    lnaam       varchar2(20)
    );