CREATE DATABASE JAVA5_LAB06
GO
USE JAVA5_LAB06
GO

CREATE TABLE Users (
                     id int identity primary key,
                     username varchar(50) not null unique ,
                     password varchar(50) not null ,
                     fullname nvarchar(50) not null
)

CREATE TABLE Departs(
                      id int identity primary key ,
                      name nvarchar(50) not null
)

CREATE TABLE Staffs(
                     id int identity primary key ,
                     name nvarchar(50) not null ,
                     gender bit not null default (1),
                     birthday date not null ,
                     photo nvarchar(50) not null ,
                     email varchar(50) not null ,
                     phone varchar(10) not null ,
                     salary int not null ,
                     notes nvarchar(200) null,
                     departID int not null foreign key references Departs(id)
)

CREATE TABLE Records(
                      id int identity primary key ,
                      type bit not null,
                      reason nvarchar(200), -- Lý do
                      dateCreate date not null default (GETDATE()),
                      staffID int not null foreign key references Staffs(id)

)