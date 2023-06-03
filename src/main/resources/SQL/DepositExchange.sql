USE [bbgdata]
GO


SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[DepositExchange](
	[DepositsID] [varchar](30)  NOT NULL PRIMARY KEY,
	[Input_Date] [datetime] NOT NULL,
	[Mobile] [varchar](15) NOT NULL FOREIGN KEY REFERENCES Deposit(Mobile)ON DELETE CASCADE ON UPDATE CASCADE,
	[AdjustPrincipal] [numeric](7,2) NOT NULL,
	[AdjustBonus] [numeric](7,2) NOT NULL,
	[Principal] [numeric](7,2) NOT NULL,
	[Bonus] [numeric](7,2) NOT NULL,
	[Customer_ID] [varchar](10) NOT NULL,
	[Operator] [varchar](10) NOT NULL,
	[CheckID] [varchar](20) NULL,
	[Posted] [bit] NULL DEFAULT '0',
	[PostUser] [char](10) NULL,
	[Remark] [varchar](100)  NULL
)
GO

SET ANSI_PADDING OFF
GO