USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Appraise](
	[ID] [integer]  IDENTITY(1000000001,1) NOT NULL PRIMARY KEY,
	[Mobile] [varchar](11) NOT NULL ,
	[Name] [varchar](20) ,
	[Customer_ID] [varchar](20) NOT NULL,
	[RGUser] [varchar](20) NOT NULL,
	[JBUser] [varchar](20) NOT NULL,
	[Grade] [integer] NOT NULL,
	[ShineShoesNum] [integer] NOT NULL,
	[WashShoesNum] [integer] NOT NULL,
	[Remark] [varchar](200) NULL,
	[Input_Date] [datetime] default getdate() NOT NULL,
	[state] [varchar](200) NULL,
	[ImgFile] [varchar](200)  NULL
)
GO

SET ANSI_PADDING OFF
GO