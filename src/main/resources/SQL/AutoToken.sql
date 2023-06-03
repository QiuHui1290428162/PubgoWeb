USE [bbgdata]
GO

/****** Object:  Table [dbo].[OAuthToken]    Script Date: 05/12/2021 15:04:35 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[AutoToken](
	[Token_id] [int] IDENTITY(1,1) NOT NULL,
	[Token_name] [char](60) NOT NULL,
	[OAuthToken] [varchar](100) NOT NULL,
 CONSTRAINT [Token_id] PRIMARY KEY CLUSTERED 
(
	[Token_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[OAuthToken] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Token_name] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO



/****************************************/


INSERT INTO [bbgdata].[dbo].[OAuthToken]
           ([Token_name]
           ,[OAuthToken])
     VALUES
           ('youzan','57ae500e6d3805df5f5a0c68c62dc94')
GO






















