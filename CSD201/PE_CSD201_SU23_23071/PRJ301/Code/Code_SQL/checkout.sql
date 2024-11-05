create database CheckOut


create table [dbo].[tblCheckOut] (
	ID nvarchar(50) not null,
	[Name] nvarchar(50) null,
	Price nvarchar(50) null,
	Quantity int
)