USE [IngInterview]
GO

/****** Object:  Table [dbo].[bank_accounts]    Script Date: 3/23/2020 10:54:50 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[bank_accounts](
	[bank_account_id] [int] IDENTITY(1,1) NOT NULL,
	[iban_code] [varchar](20) NOT NULL,
	[balance] [float] NOT NULL,
 CONSTRAINT [PK_bankAccounts] PRIMARY KEY CLUSTERED 
(
	[bank_account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


