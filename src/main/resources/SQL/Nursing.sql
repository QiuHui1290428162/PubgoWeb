USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Nursing](
	[NursingID] [varchar](30)   NOT NULL PRIMARY KEY,
	[Tel] [varchar](15) NOT NULL ,
	[Name] [varchar](15),
	[Customer_ID] [varchar](20) NOT NULL,
	[Quantity] [integer] NOT NULL,
	[Step] [integer] NOT NULL,
	[Score] [integer] ,
	[Appraise] [varchar](100) ,
	[Input] [integer] ,
	[Payment] [varchar](20) ,
	[UserRemake] [varchar](200) NULL,
	[EmployeeRemake] [varchar](200) NULL,
	[CreateTime] [datetime] default getdate() NOT NULL,
	[UpdateTime] [datetime] ,
	[sign] [varchar]() NOT NULL,
)
GO

SET ANSI_PADDING OFF
GO