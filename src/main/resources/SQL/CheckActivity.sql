USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[CheckActivity](
	[ID] [varchar](25)   NOT NULL PRIMARY KEY,
	[CheckID] [varchar](15) NOT NULL ,
	[CustomerName] [varchar](20) NULL,
	[BuisnessManName] [varchar](20) NULL,
	[InputDate] [datetime]  NOT NULL,
	[UnitPrice] numeric(18, 2) NULL,
	[DiscountPrice] numeric(18, 2) NULL,
	[Quantity] [integer] NULL,
	[VIP] [varchar](15) NULL,
	[Tel] [varchar](15) NULL,
	[Activity] [varchar](20) NULL,
	[Code] [varchar](20) NULL,
	[PromocardID] bigint  NULL,
	[Remark] [varchar](100)  NULL,
)
GO

SET ANSI_PADDING OFF
GO