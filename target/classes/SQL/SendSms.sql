USE [bbgdata]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[SendSms](
	TemplateCode [varchar](30) NOT NULL   PRIMARY KEY,
	SignName [varchar](30) NOT NULL,
	Region  [varchar](30) NOT NULL,
	SysDomain  [varchar](30) NOT NULL,
	TemplateText  [varchar](100),
	TemplateName  [varchar](30) ,
)
GO

SET ANSI_PADDING OFF
GO