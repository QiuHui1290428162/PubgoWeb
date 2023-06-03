USE [bbgdata]
GO

/****** Object:  Table [dbo].[VipCard]    Script Date: 05/12/2021 15:08:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[VipCard](
	[VipCardSN] [integer]  NOT NULL PRIMARY KEY,
	[VipGrade] [varchar](10) NOT NULL FOREIGN KEY REFERENCES [dbo].[VipGrade] ([VipGrade])ON DELETE CASCADE ON UPDATE CASCADE,
	[VipCardName] [varchar](20) NOT NULL,
	[VipCardAlias] [varchar](50) NOT NULL,
	[CorrelationId]  [integer]  NOT NULL,
)
GO

SET ANSI_PADDING OFF
GO

/**************************************************************************/

INSERT INTO [bbgdata].[dbo].[VipCard]
           ([VipGrade]
           ,[VipCardName]
           ,[VipCardAlias])
     VALUES
           ('1'
           ,'VIP会员卡'
           ,'Y2xe3i6oe1ni84')
GO
INSERT INTO [bbgdata].[dbo].[VipCard]
           ([VipGrade]
           ,[VipCardName]
           ,[VipCardAlias])
     VALUES
           ('2'
           ,'生日卡'
           ,'0000000000002')
GO
INSERT INTO [bbgdata].[dbo].[VipCard]
           ([VipGrade]
           ,[VipCardName]
           ,[VipCardAlias])
     VALUES
           ('1'
           ,'VIP会员卡.'
           ,'Y3nszp88b3fr2s')









