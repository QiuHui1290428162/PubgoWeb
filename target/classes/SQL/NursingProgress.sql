USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[NursingProgress](
	[NursingProgressID] [varchar](30)  NOT NULL PRIMARY KEY,
	[NursingID] [varchar](30)  NOT NULL FOREIGN KEY REFERENCES Nursing(NursingID)ON DELETE CASCADE ON UPDATE CASCADE,
	[Step] [integer] NOT NULL,
	[InputDate] [datetime] default getdate() NOT NULL,
	[Operator] [varchar](20),
	[ImagePath] [varchar](100)
)
GO

SET ANSI_PADDING OFF
GO