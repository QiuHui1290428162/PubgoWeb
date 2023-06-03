USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Category](
	[id] integer  IDENTITY(1,1) NOT NULL PRIMARY KEY,       
	[name] varchar(32) NOT NULL ,
	[level] integer NOT NULL,
	[parentID] integer NOT NULL,
	[orderNum] integer NOT NULL,
	[path] varchar(100) NOT NULL ,
	[platform] integer NOT NULL,
	[crete_date] [datetime] default getdate(),
	[update_date] [datetime] default getdate(),
)
GO

SET ANSI_PADDING OFF
GO