USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[NursingLog](
	[LogId] [varchar](30)   NOT NULL PRIMARY KEY,
	[NursingId] [varchar](30) NOT NULL ,
	[Customer_ID] [varchar](20) NULL,
	[Operator] [varchar](20) NOT NULL,
	[CreateTime] [datetime] default getdate() NOT NULL,
	[Operate] [varchar](100) NOT NULL,
	[Remark] [varchar](200) NULL
)
GO

SET ANSI_PADDING OFF
GO