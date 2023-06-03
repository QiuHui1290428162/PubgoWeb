USE [bbgdata]
GO


SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Deposit](
	[Mobile] [varchar](15)  NOT NULL PRIMARY KEY,
	[Money] numeric(8, 2) default 0  NOT NULL,
	[Principal] numeric(8, 2) default 0  NOT NULL,
	[Bonus] numeric(8, 2) default 0  NOT NULL,
	[Name] [varchar](50) NULL ,
	[Sex]  [varchar](5) NULL,
	[Password] [varchar](15)  NOT NULL ,
	[Customer_ID] [varchar](20) NULL,
	[Remark] [varchar](100)  NULL
)
GO

SET ANSI_PADDING OFF
GO