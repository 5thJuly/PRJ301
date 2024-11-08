
create database PRJ301_PE_SP_2022_B1

USE [PRJ301_PE_SP_2022_B1]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[displayname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Certificate](
	[certid] [int] NOT NULL,
	[certname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Certificate] PRIMARY KEY CLUSTERED 
(
	[certid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[empid] [int] NOT NULL,
	[empname] [varchar](150) NOT NULL,
	[empdob] [date] NOT NULL,
	[empgender] [bit] NOT NULL,
	[createdby] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[empid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee_Certificate]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee_Certificate](
	[empid] [int] NOT NULL,
	[certid] [int] NOT NULL,
	[issueddate] [date] NOT NULL,
 CONSTRAINT [PK_Employee_Certificate] PRIMARY KEY CLUSTERED 
(
	[empid] ASC,
	[certid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Member]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Member](
	[mid] [int] NOT NULL,
	[mname] [varchar](150) NOT NULL,
	[mdob] [date] NOT NULL,
	[isGold] [bit] NOT NULL,
	[createdby] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Member] PRIMARY KEY CLUSTERED 
(
	[mid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Package]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Package](
	[pid] [int] NOT NULL,
	[pname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Package] PRIMARY KEY CLUSTERED 
(
	[pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Package_Member]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Package_Member](
	[pid] [int] NOT NULL,
	[mid] [int] NOT NULL,
	[issueddate] [date] NOT NULL,
 CONSTRAINT [PK_Package_Member] PRIMARY KEY CLUSTERED 
(
	[pid] ASC,
	[mid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Skill]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skill](
	[sid] [int] NOT NULL,
	[sname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Skill] PRIMARY KEY CLUSTERED 
(
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[stuid] [int] NOT NULL,
	[stuname] [varchar](150) NOT NULL,
	[stugender] [bit] NOT NULL,
	[studob] [date] NOT NULL,
	[createdby] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[stuid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student_Skill]    Script Date: 3/6/2022 11:35:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Skill](
	[sid] [int] NOT NULL,
	[stuid] [int] NOT NULL,
	[degree] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Student_Skill] PRIMARY KEY CLUSTERED 
(
	[sid] ASC,
	[stuid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mra', N'mra', N'DisplayName of A')
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mrb', N'mrb', N'DisplayName of B')
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mrc', N'mrc', N'DisplayName of C')
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mrd', N'mrd', N'DisplayName of D')
GO
INSERT [dbo].[Certificate] ([certid], [certname]) VALUES (1, N'Cert 1')
INSERT [dbo].[Certificate] ([certid], [certname]) VALUES (2, N'Cert 2')
INSERT [dbo].[Certificate] ([certid], [certname]) VALUES (3, N'Cert 3')
INSERT [dbo].[Certificate] ([certid], [certname]) VALUES (4, N'Cert 4')
INSERT [dbo].[Certificate] ([certid], [certname]) VALUES (5, N'Cert 5')
GO
INSERT [dbo].[Employee] ([empid], [empname], [empdob], [empgender], [createdby]) VALUES (10001, N'Employee 1', CAST(N'1987-11-13' AS Date), 1, N'mra')
INSERT [dbo].[Employee] ([empid], [empname], [empdob], [empgender], [createdby]) VALUES (10002, N'Employee 2', CAST(N'1985-04-16' AS Date), 0, N'mra')
INSERT [dbo].[Employee] ([empid], [empname], [empdob], [empgender], [createdby]) VALUES (10003, N'Employee 3', CAST(N'1982-09-08' AS Date), 0, N'mra')
INSERT [dbo].[Employee] ([empid], [empname], [empdob], [empgender], [createdby]) VALUES (10004, N'Employee 4', CAST(N'1991-07-05' AS Date), 1, N'mrb')
INSERT [dbo].[Employee] ([empid], [empname], [empdob], [empgender], [createdby]) VALUES (10005, N'Employee 5', CAST(N'1994-08-15' AS Date), 1, N'mrb')
GO
INSERT [dbo].[Member] ([mid], [mname], [mdob], [isGold], [createdby]) VALUES (10001, N'Member 1', CAST(N'1987-11-13' AS Date), 1, N'mra')
INSERT [dbo].[Member] ([mid], [mname], [mdob], [isGold], [createdby]) VALUES (10002, N'Member 2', CAST(N'1985-04-16' AS Date), 0, N'mra')
INSERT [dbo].[Member] ([mid], [mname], [mdob], [isGold], [createdby]) VALUES (10003, N'Member 3', CAST(N'1982-09-08' AS Date), 0, N'mra')
INSERT [dbo].[Member] ([mid], [mname], [mdob], [isGold], [createdby]) VALUES (10004, N'Member 4', CAST(N'1991-07-05' AS Date), 1, N'mrb')
INSERT [dbo].[Member] ([mid], [mname], [mdob], [isGold], [createdby]) VALUES (10005, N'Member 5', CAST(N'1994-08-15' AS Date), 1, N'mrb')
GO
INSERT [dbo].[Package] ([pid], [pname]) VALUES (1, N'Package 1')
INSERT [dbo].[Package] ([pid], [pname]) VALUES (2, N'Package 2')
INSERT [dbo].[Package] ([pid], [pname]) VALUES (3, N'Package 3')
INSERT [dbo].[Package] ([pid], [pname]) VALUES (4, N'Package 4')
INSERT [dbo].[Package] ([pid], [pname]) VALUES (5, N'Package 5')
GO
INSERT [dbo].[Skill] ([sid], [sname]) VALUES (1, N'Skill 1')
INSERT [dbo].[Skill] ([sid], [sname]) VALUES (2, N'Skill 2')
INSERT [dbo].[Skill] ([sid], [sname]) VALUES (3, N'Skill 3')
INSERT [dbo].[Skill] ([sid], [sname]) VALUES (4, N'Skill 4')
INSERT [dbo].[Skill] ([sid], [sname]) VALUES (5, N'Skill 5')
GO
INSERT [dbo].[Student] ([stuid], [stuname], [stugender], [studob], [createdby]) VALUES (10001, N'Student 1', 1, CAST(N'1987-11-13' AS Date), N'mra')
INSERT [dbo].[Student] ([stuid], [stuname], [stugender], [studob], [createdby]) VALUES (10002, N'Student 2', 0, CAST(N'1985-04-16' AS Date), N'mra')
INSERT [dbo].[Student] ([stuid], [stuname], [stugender], [studob], [createdby]) VALUES (10003, N'Student 3', 0, CAST(N'1982-09-08' AS Date), N'mra')
INSERT [dbo].[Student] ([stuid], [stuname], [stugender], [studob], [createdby]) VALUES (10004, N'Student 4', 1, CAST(N'1991-07-05' AS Date), N'mrb')
INSERT [dbo].[Student] ([stuid], [stuname], [stugender], [studob], [createdby]) VALUES (10005, N'Student 5', 1, CAST(N'1994-08-15' AS Date), N'mrb')
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Account] FOREIGN KEY([createdby])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Account]
GO
ALTER TABLE [dbo].[Employee_Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Certificate_Certificate] FOREIGN KEY([certid])
REFERENCES [dbo].[Certificate] ([certid])
GO
ALTER TABLE [dbo].[Employee_Certificate] CHECK CONSTRAINT [FK_Employee_Certificate_Certificate]
GO
ALTER TABLE [dbo].[Employee_Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Certificate_Employee] FOREIGN KEY([empid])
REFERENCES [dbo].[Employee] ([empid])
GO
ALTER TABLE [dbo].[Employee_Certificate] CHECK CONSTRAINT [FK_Employee_Certificate_Employee]
GO
ALTER TABLE [dbo].[Member]  WITH CHECK ADD  CONSTRAINT [FK_Member_Account] FOREIGN KEY([createdby])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Member] CHECK CONSTRAINT [FK_Member_Account]
GO
ALTER TABLE [dbo].[Package_Member]  WITH CHECK ADD  CONSTRAINT [FK_Package_Member_Member] FOREIGN KEY([mid])
REFERENCES [dbo].[Member] ([mid])
GO
ALTER TABLE [dbo].[Package_Member] CHECK CONSTRAINT [FK_Package_Member_Member]
GO
ALTER TABLE [dbo].[Package_Member]  WITH CHECK ADD  CONSTRAINT [FK_Package_Member_Package] FOREIGN KEY([pid])
REFERENCES [dbo].[Package] ([pid])
GO
ALTER TABLE [dbo].[Package_Member] CHECK CONSTRAINT [FK_Package_Member_Package]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Account] FOREIGN KEY([createdby])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Account]
GO
ALTER TABLE [dbo].[Student_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Student_Skill_Skill] FOREIGN KEY([sid])
REFERENCES [dbo].[Skill] ([sid])
GO
ALTER TABLE [dbo].[Student_Skill] CHECK CONSTRAINT [FK_Student_Skill_Skill]
GO
ALTER TABLE [dbo].[Student_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Student_Skill_Student] FOREIGN KEY([stuid])
REFERENCES [dbo].[Student] ([stuid])
GO
ALTER TABLE [dbo].[Student_Skill] CHECK CONSTRAINT [FK_Student_Skill_Student]
GO
