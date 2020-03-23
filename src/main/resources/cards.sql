USE [IngInterview]
GO

/****** Object:  Table [dbo].[cards]    Script Date: 3/23/2020 10:50:31 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cards](
	[card_id] [int] IDENTITY(1,1) NOT NULL,
	[bank_account_id] [int] NULL,
	[owner] [varchar](20) NULL,
	[expiration_date] [datetime] NULL,
 CONSTRAINT [PK_cards] PRIMARY KEY CLUSTERED 
(
	[card_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


