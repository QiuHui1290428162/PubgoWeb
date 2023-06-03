USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[NursingCenter](
	[NursingID] [varchar](30)   NOT NULL PRIMARY KEY,
	[Customer_ID] [varchar](20) NOT NULL,
	[Operator] [varchar](20) NULL,
	[Quantity] [integer] NOT NULL,
	[Step] [integer] NOT NULL,
	[Score] [integer] ,
	[Appraise] [varchar](100) ,
	[Remark] [varchar](200) NULL,
	[EmployeeRemake] [varchar](200) NULL,
	[CreateTime] [datetime] default getdate() NOT NULL,
	[UpdateTime] [datetime] ,
	[sign] [varchar](5) NOT NULL,
	[ImagePath] [varchar](100) NULL,
)
GO

SET ANSI_PADDING OFF
GO