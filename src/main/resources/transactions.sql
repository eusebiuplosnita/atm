USE [IngInterview]
GO

/****** Object:  Table [dbo].[transactions]    Script Date: 3/23/2020 10:55:14 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[transactions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bank_account_id] [int] NOT NULL,
	[type] [varchar](10) NOT NULL,
	[amount] [float] NOT NULL,
	[date] [datetime] NOT NULL,
 CONSTRAINT [PK_transactions] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[transactions]  WITH CHECK ADD FOREIGN KEY([bank_account_id])
REFERENCES [dbo].[bank_accounts] ([bank_account_id])
GO


