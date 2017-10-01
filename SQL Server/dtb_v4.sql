create database QuanLyNhaSach
go
use QuanLyNhaSach
go
CREATE TABLE [dbo].[BAOCAOTONG](
	[ngay] [datetime] NOT NULL,
	[tongthu] [int] NOT NULL,
	[tongchi] [int] NOT NULL,
	[chenhlech] [int] NOT NULL,
	[delflag] [int] NOT NULL,
	[timedel] [datetime] NULL,
 CONSTRAINT [PK_BAOCAOTONG] PRIMARY KEY CLUSTERED 
(
	[ngay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BK_BAOCAOTONG]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BK_BAOCAOTONG](
	[ngay] [datetime] NOT NULL,
	[tongthu] [int] NOT NULL,
	[tongchi] [int] NOT NULL,
	[chenhlech] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BK_CT_DATHANG]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BK_CT_DATHANG](
	[madathang] [varchar](8) NOT NULL,
	[masach] [varchar](8) NOT NULL,
	[soluongdat] [int] NOT NULL,
	[dongia] [int] NOT NULL,
	[thanhtien] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BK_CT_HOADON]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BK_CT_HOADON](
	[mahoadon] [varchar](8) NOT NULL,
	[masach] [varchar](8) NOT NULL,
	[soluongban] [int] NOT NULL,
	[dongia] [int] NOT NULL,
	[thanhtien] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BK_SACH]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BK_SACH](
	[masach] [varchar](8) NOT NULL,
	[tensach] [nvarchar](50) NOT NULL,
	[matheloai] [varchar](8) NOT NULL,
	[dongiaban] [int] NOT NULL,
	[luotmua] [int] NOT NULL,
	[khuyenmai] [float] NOT NULL,
	[anhbia] [varchar](30) NOT NULL,
	[tinhtrang] [bit] NOT NULL,
	[mota] [nvarchar](max) NOT NULL,
	[nhaxuatban] [nvarchar](25) NOT NULL,
	[tacgia] [nvarchar](20) NOT NULL,
	[ngayxuatban] [date] NOT NULL,
	[soluongton] [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_DATHANG]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_DATHANG](
	[madathang] [varchar](8) NOT NULL,
	[masach] [varchar](8) NOT NULL,
	[soluongdat] [int] NOT NULL,
	[dongia] [int] NOT NULL,
	[thanhtien] [int] NOT NULL,
	[delflag] [int] NOT NULL,
	[timedel] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HOADON]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HOADON](
	[mahoadon] [varchar](8) NOT NULL,
	[masach] [varchar](8) NOT NULL,
	[soluongban] [int] NOT NULL,
	[dongia] [int] NOT NULL,
	[thanhtien] [int] NOT NULL,
	[delflag] [int] NOT NULL,
	[timedel] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_PHIEUNHAP]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_PHIEUNHAP](
	[masach] [varchar](8) NOT NULL,
	[mapn] [varchar](8) NOT NULL,
	[soluong] [int] NOT NULL,
	[gianhap] [int] NOT NULL,
	[thanhtien] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DATHANG]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DATHANG](
	[madathang] [varchar](8) NOT NULL,
	[makh] [varchar](8) NOT NULL,
	[sdt] [varchar](20) NOT NULL,
	[diachi] [nvarchar](100) NOT NULL,
	[ngaydat] [datetime] NOT NULL,
	[ngaygiao] [datetime] NOT NULL,
	[tongdonhang] [int] NOT NULL,
	[tinhtrang] [bit] NOT NULL,
 CONSTRAINT [DATHANG_MADATHANG_PK] PRIMARY KEY CLUSTERED 
(
	[madathang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[mahoadon] [varchar](8) NOT NULL,
	[manv] [varchar](8) NOT NULL,
	[makh] [varchar](8) NOT NULL,
	[ngaylap] [datetime] NOT NULL,
	[tonghoadon] [int] NOT NULL,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[mahoadon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[makh] [varchar](8) NOT NULL,
	[tenkh] [nvarchar](25) NOT NULL,
	[diachi] [nvarchar](100) NOT NULL,
	[sodienthoai] [varchar](12) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[matkhaukh] [nvarchar](50) NOT NULL,
 CONSTRAINT [KHACHHANG_MAKHACHHANG_PK] PRIMARY KEY CLUSTERED 
(
	[makh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHACUNGCAP]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHACUNGCAP](
	[mancc] [varchar](8) NOT NULL,
	[tenncc] [nvarchar](25) NOT NULL,
	[diachi] [nvarchar](100) NOT NULL,
	[sdtncc] [varchar](25) NOT NULL,
 CONSTRAINT [PK_NHACUNGCAP] PRIMARY KEY CLUSTERED 
(
	[mancc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[manv] [varchar](8) NOT NULL,
	[tennv] [nvarchar](50) NOT NULL,
	[ngaysinh] [date] NOT NULL,
	[diachi] [nvarchar](150) NOT NULL,
	[sodienthoai] [varchar](25) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[matkhaunv] [varchar](50) NOT NULL,
	[maquyen] [varchar](8) NOT NULL,
	[tinhtrang] [bit] NOT NULL,
 CONSTRAINT [NHANVIEN_MANHANVIEN_PK] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEUNHAP]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEUNHAP](
	[mapn] [varchar](8) NOT NULL,
	[manv] [varchar](8) NOT NULL,
	[mancc] [varchar](8) NOT NULL,
	[soluongnhap] [int] NOT NULL,
	[ngaylapphieu] [date] NOT NULL,
	[tongtiennhap] [int] NOT NULL,
 CONSTRAINT [NHAPSACH_MANHAPSACH_PK] PRIMARY KEY CLUSTERED 
(
	[mapn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QUYEN]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QUYEN](
	[maquyen] [varchar](8) NOT NULL,
	[tenquyen] [nvarchar](20) NOT NULL,
 CONSTRAINT [QUYEN_MAQUYEN_PK] PRIMARY KEY CLUSTERED 
(
	[maquyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SACH]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SACH](
	[masach] [varchar](8) NOT NULL,
	[tensach] [nvarchar](50) NOT NULL,
	[matheloai] [varchar](8) NOT NULL,
	[dongiaban] [int] NOT NULL,
	[luotmua] [int] NOT NULL,
	[khuyenmai] [float] NOT NULL,
	[anhbia] [varchar](30) NOT NULL,
	[tinhtrang] [bit] NOT NULL,
	[mota] [nvarchar](max) NOT NULL,
	[nhaxuatban] [nvarchar](25) NOT NULL,
	[tacgia] [nvarchar](20) NOT NULL,
	[ngayxuatban] [date] NOT NULL,
	[soluongton] [int] NOT NULL,
	[delflag] [int] NOT NULL,
	[timedel] [datetime] NULL,
 CONSTRAINT [SACH_MASACH_PK] PRIMARY KEY CLUSTERED 
(
	[masach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[THELOAI]    Script Date: 9/26/2017 6:13:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THELOAI](
	[matheloai] [varchar](8) NOT NULL,
	[tentheloai] [nvarchar](25) NOT NULL,
 CONSTRAINT [THELOAI_MATHELOAI_PK] PRIMARY KEY CLUSTERED 
(
	[matheloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-01-01T00:00:00.000' AS DateTime), 3000000, 4000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-02-01T00:00:00.000' AS DateTime), 4000000, 5000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-03-01T00:00:00.000' AS DateTime), 5000000, 6000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-04-01T00:00:00.000' AS DateTime), 6000000, 7000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-05-01T00:00:00.000' AS DateTime), 7000000, 8000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-06-01T00:00:00.000' AS DateTime), 8000000, 9000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-07-01T00:00:00.000' AS DateTime), 9000000, 10000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-08-01T00:00:00.000' AS DateTime), 1000000, 2000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-09-01T00:00:00.000' AS DateTime), 2000000, 3000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-10-01T00:00:00.000' AS DateTime), 3000000, 4000000, 1000000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-11-01T00:00:00.000' AS DateTime), 1200000, 2000000, 800000, 0, NULL)
INSERT [dbo].[BAOCAOTONG] ([ngay], [tongthu], [tongchi], [chenhlech], [delflag], [timedel]) VALUES (CAST(N'2017-12-01T00:00:00.000' AS DateTime), 1100000, 3000000, 1900000, 0, NULL)
INSERT [dbo].[CT_DATHANG] ([madathang], [masach], [soluongdat], [dongia], [thanhtien], [delflag], [timedel]) VALUES (N'DH1', N'S00008', 1, 54000, 54000, 0, NULL)
INSERT [dbo].[CT_DATHANG] ([madathang], [masach], [soluongdat], [dongia], [thanhtien], [delflag], [timedel]) VALUES (N'DH1', N'S00027', 1, 87000, 87000, 0, NULL)
INSERT [dbo].[CT_DATHANG] ([madathang], [masach], [soluongdat], [dongia], [thanhtien], [delflag], [timedel]) VALUES (N'DH11', N'S00027', 1, 87000, 87000, 0, NULL)
INSERT [dbo].[CT_DATHANG] ([madathang], [masach], [soluongdat], [dongia], [thanhtien], [delflag], [timedel]) VALUES (N'DH10', N'S00006', 1, 54000, 54000, 0, NULL)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00001', N'PN001', 100, 30000, 3000000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00002', N'PN002', 123, 14000, 2340000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00003', N'PN003', 134, 15000, 3450000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00004', N'PN004', 145, 16000, 4560000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00005', N'PN005', 156, 17000, 5670000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00006', N'PN006', 167, 18000, 1110000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00007', N'PN007', 178, 19000, 2220000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00008', N'PN008', 189, 20000, 3330000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00009', N'PN009', 190, 21000, 4440000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00010', N'PN010', 109, 22000, 4320000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00011', N'PN011', 198, 23000, 6430000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00012', N'PN012', 187, 24000, 2220000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00013', N'PN013', 176, 25000, 5440000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00014', N'PN014', 165, 26000, 1120000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00015', N'PN015', 154, 27000, 1130000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00016', N'PN016', 143, 28000, 4320000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00017', N'PN017', 132, 29000, 5440000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00018', N'PN018', 121, 30000, 1120000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00019', N'PN019', 111, 31000, 1220000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00020', N'PN020', 122, 32000, 1320000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00021', N'PN021', 133, 33000, 4230000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00022', N'PN022', 144, 34000, 1430000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00023', N'PN023', 155, 45000, 3320000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00024', N'PN024', 166, 35000, 3150000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00025', N'PN025', 177, 36000, 3650000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00026', N'PN026', 188, 37000, 3870000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00027', N'PN027', 199, 38000, 3080000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00028', N'PN028', 200, 39000, 3340000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00029', N'PN029', 124, 40000, 3650000)
INSERT [dbo].[CT_PHIEUNHAP] ([masach], [mapn], [soluong], [gianhap], [thanhtien]) VALUES (N'S00030', N'PN030', 126, 41000, 3750000)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH1', N'KH1', N'1231231231', N'asdasdsad', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 32000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH10', N'KH1', N'01234567987', N'55 tan quý nè', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 54000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH11', N'KH4', N'0123456789', N'asdasdasd', CAST(N'2017-09-25T00:00:00.000' AS DateTime), CAST(N'2017-09-27T00:00:00.000' AS DateTime), 87000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH2', N'KH1', N'1231231231', N'asdasdsad', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 32000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH3', N'KH1', N'1231231231', N'asdasdsad', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 32000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH4', N'KH1', N'1231231231', N'asdasdsad', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 32000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH5', N'KH1', N'0123123123', N'asasdasd', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 36800, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH6', N'KH1', N'0123123123', N'asasdasd', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 36800, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH7', N'KH1', N'0123123123', N'asasdasd', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 36800, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH8', N'KH1', N'3333333333', N'dfdfdfdf', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 54000, 1)
INSERT [dbo].[DATHANG] ([madathang], [makh], [sdt], [diachi], [ngaydat], [ngaygiao], [tongdonhang], [tinhtrang]) VALUES (N'DH9', N'KH1', N'1231231231', N'asdasdasdsad', CAST(N'2017-09-23T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 87000, 1)
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH1', N'Nguyễn Thanh Nhân', N'Đồng Nai', N'0123456789', N'thanhnhan@gmail.com', N'123123')
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH2', N'aaaaaa', N'aaaaaaaa', N'0123456654', N'asdasdasdasd', N'123123')
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH3', N'aaaaaaaaa', N'ABC', N'0123321123', N'123', N'123123')
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH4', N'vuhoang', N'ABC', N'1231231231', N'123', N'123123')
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH5', N'asdzxc', N'ABC', N'3213213211', N'123', N'123123')
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH6', N'minh', N'55 tan quy', N'0123456789', N'khongco@gmail.com', N'123123')
INSERT [dbo].[KHACHHANG] ([makh], [tenkh], [diachi], [sodienthoai], [email], [matkhaukh]) VALUES (N'KH7', N'aaaaaaaa', N'ABC', N'0123456789', N'123', N'123123')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC01', N'Chính trị Quốc gia', N'Quận 1', N'0121212120')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC02', N'Tư pháp', N'Quận 2', N'0121212121')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC03', N'Hồng Đức', N'Quận 3', N'0121212122')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC04', N'Quân đội', N'Quận 4', N'0121212123')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC05', N'Kim đồng', N'Quận 5', N'0121212124')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC06', N'Thanh niên', N'Quận 6', N'0121212125')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC07', N'Lao động', N'Quận 7', N'0121212126')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC08', N'Phụ nữ', N'Quận 8', N'0121212127')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC09', N'Mỹ thuật', N'Quận 9', N'0121212128')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC10', N'Tôn giáo', N'Quận 10', N'0121212129')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC11', N'Tài chính', N'Quận 1', N'0121232120')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC12', N'Sân khấu', N'Quận 2', N'0121234121')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC13', N'Thế giới', N'Quận 3', N'0121251122')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC14', N'Thể dục Thể thao', N'Quận 4', N'0133212123')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC15', N'Tri thức', N'Quận 5', N'0121215424')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC16', N'Văn hóa dân tộc', N'Quận 6', N'0122312125')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC17', N'Văn hóa Sài Gòn', N'Quận 7', N'0121112126')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC18', N'Văn hóa Thông tin', N'Quận 8', N'0145612127')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC19', N'Văn học', N'Quận 9', N'0121212123')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC20', N'Xây dựng', N'Quận 10', N'0121244429')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC21', N'Y học', N'Quận 1', N'0121232120')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC22', N'Âm nhạc', N'Quận 2', N'0121234121')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC23', N'Chính trị Quốc gia', N'Quận 3', N'0121251122')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC24', N'Công an nhân dân', N'Quận 4', N'0133212123')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC25', N'Công báo chính phủ', N'Quận 5', N'0121215424')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC26', N'Cục báo chí', N'Quận 6', N'0122312125')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC27', N'Giáo dục', N'Quận 7', N'0121112126')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC28', N'Giao thông vận tải', N'Quận 8', N'0145612127')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC29', N'Lao động', N'Quận 9', N'0121212123')
INSERT [dbo].[NHACUNGCAP] ([mancc], [tenncc], [diachi], [sdtncc]) VALUES (N'NCC30', N'Lý luận chính trị', N'Quận 10', N'0121244429')
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV001', N'Nguyễn Thanh Nhân', CAST(N'1996-01-01' AS Date), N'Đồng Nai', N'0123453123', N'thanhnhan@gmail.com', N'123123123', N'PTK', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV002', N'Nguyễn Anh Quốc', CAST(N'1996-02-01' AS Date), N'Cà Mau', N'0123126783', N'anhquoc@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV003', N'Đặng Vũ Hồng Phúc', CAST(N'1996-03-01' AS Date), N'Phú Yên', N'0120003123', N'hongphuc@gmail.com', N'123123123', N'PKT', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV004', N'Đoàn Cao Thăng', CAST(N'1996-04-01' AS Date), N'Hà Nội', N'0123123333', N'caothang@gmail.com', N'123123123', N'AD', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV005', N'Trần Nguyễn Hoàng Sơn', CAST(N'1996-05-01' AS Date), N'TP.HCM', N'0127643123', N'hoangson@gmail.com', N'123123123', N'TP', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV006', N'Trần Xuân Toàn', CAST(N'1996-06-01' AS Date), N'Bình Dương', N'0123123123', N'xuantoan@gmail.com', N'123123123', N'PP', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV007', N'Nguyễn Đức Trọng ', CAST(N'1996-07-01' AS Date), N'Bạc Liêu', N'0123124323', N'ductrong@gmail.com', N'123123123', N'QL', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV008', N'Lê Hữu Trường', CAST(N'1996-08-01' AS Date), N'Kiên Giang', N'0123127623', N'huutruong@gmail.com', N'123123123', N'TK', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV009', N'Phạm Ngọc Hiếu', CAST(N'1996-09-01' AS Date), N'An Giang', N'0123127623', N'ngochieu@gmail.com', N'123123123', N'GD', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV010', N'Mai Hoàng Duy Anh', CAST(N'1996-10-01' AS Date), N'Đồng Tháp', N'0154123123', N'duyanh@gmail.com', N'123123123', N'PGD', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV011', N'Nguyễn Hữu Đang', CAST(N'1996-11-01' AS Date), N'Cần Thơ', N'0123123223', N'huudang@gmail.com', N'123123123', N'TT', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV012', N'Cao Hoàng Hải Đăng', CAST(N'1996-12-01' AS Date), N'Lâm Đồng', N'0165123123', N'haidang@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV013', N'Nguyễn Duy Hiếu', CAST(N'1996-01-02' AS Date), N'Khánh Hòa', N'0123873123', N'duyhieu@gmail.com', N'123123123', N'PTK', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV014', N'Lê Văn Hoàng', CAST(N'1996-01-03' AS Date), N'Quãng Nam', N'0123123983', N'vanhoang@gmail.com', N'123123123', N'PKT', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV015', N'Nguyễn Hưng', CAST(N'1996-01-04' AS Date), N'Quãng Ninh', N'0123120923', N'nguyenhung@gmail.com', N'123123123', N'AD', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV016', N'Trần Anh Kha', CAST(N'1996-01-05' AS Date), N'Quãng Ngãi', N'0123198123', N'anhkha@gmail.com', N'123123123', N'TP', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV017', N'Phạm Hoài Lâm', CAST(N'1996-01-06' AS Date), N'Hà Giang', N'0123128723', N'hoailam@gmail.com', N'123123123', N'PP', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV018', N'Phạm Duy Linh', CAST(N'1996-01-07' AS Date), N'Cao Bằng', N'0123127623', N'duylinh@gmail.com', N'123123123', N'QL', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV019', N'Phạm Minh Nhật', CAST(N'1996-01-08' AS Date), N'Vũng Tàu', N'0123154123', N'minhnhat@gmail.com', N'123123123', N'TK', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV020', N'Nguyễn Ngọc Thanh Phong', CAST(N'1996-01-09' AS Date), N'Thanh Hóa', N'0123123543', N'thanhphong@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV021', N'Trần Hồng Sơn', CAST(N'1996-01-10' AS Date), N'Đà Nẵng', N'0123124323', N'hongson@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV022', N'Nguyễn Đức Tín', CAST(N'1996-01-11' AS Date), N'Hòa Bình', N'0123323123', N'ductin@gmail.com', N'123123123', N'PTK', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV023', N'Nguyễn Hòa Bình', CAST(N'1996-01-12' AS Date), N'Lạng Sơn', N'0122223123', N'hoabinh@gmail.com', N'123123123', N'PKT', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV024', N'Nguyễn Thanh Bình', CAST(N'1996-02-02' AS Date), N'Kon Tum', N'0154123123', N'thanhbinh@gmail.com', N'123123123', N'TP', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV025', N'Nguyễn Ngọc Lâm', CAST(N'1996-03-03' AS Date), N'Phan Thiết', N'0233123123', N'ngoclam@gmail.com', N'123123123', N'PP', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV026', N'Nguyễn Phát Hải', CAST(N'1996-04-04' AS Date), N'Bình Thuận', N'0123453123', N'phathai@gmail.com', N'123123123', N'QL', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV027', N'Nguyễn Xuân Thịnh', CAST(N'1996-05-05' AS Date), N'Ninh Thuận', N'0167123123', N'xuanthinh@gmail.com', N'123123123', N'TK', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV028', N'Nguyễn Phúc Lâm', CAST(N'1996-06-06' AS Date), N'Ninh Bình', N'0123178123', N'phuclam@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV029', N'Nguyễn Tân Hữu', CAST(N'1996-07-07' AS Date), N'Hà Tây', N'0123123873', N'tanhuu@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV030', N'Nguyễn Văn Hải', CAST(N'1996-08-08' AS Date), N'Hải Phòng', N'0123653123', N'vanhai@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV031', N'Nguyễn Bắc Hòa', CAST(N'1996-09-09' AS Date), N'Đồng Nai', N'0123154123', N'bachoa@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [ngaysinh], [diachi], [sodienthoai], [email], [matkhaunv], [maquyen], [tinhtrang]) VALUES (N'NV032', N'Nguyễn Xuân Bình', CAST(N'1996-10-10' AS Date), N'Đồng Nai', N'0126723123', N'xuanbinh@gmail.com', N'123123123', N'PBH', 1)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN001', N'NV001', N'NCC01', 100, CAST(N'2017-01-01' AS Date), 3000000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN002', N'NV013', N'NCC02', 123, CAST(N'2017-02-01' AS Date), 2340000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN003', N'NV022', N'NCC03', 134, CAST(N'2017-03-01' AS Date), 3450000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN004', N'NV001', N'NCC04', 145, CAST(N'2017-04-01' AS Date), 4560000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN005', N'NV013', N'NCC05', 156, CAST(N'2017-05-01' AS Date), 5670000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN006', N'NV022', N'NCC06', 167, CAST(N'2017-06-01' AS Date), 1110000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN007', N'NV001', N'NCC07', 178, CAST(N'2017-07-01' AS Date), 2220000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN008', N'NV013', N'NCC08', 189, CAST(N'2017-08-01' AS Date), 3330000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN009', N'NV022', N'NCC09', 190, CAST(N'2017-09-01' AS Date), 4440000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN010', N'NV001', N'NCC10', 109, CAST(N'2017-10-01' AS Date), 4320000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN011', N'NV013', N'NCC11', 198, CAST(N'2017-11-01' AS Date), 6430000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN012', N'NV022', N'NCC12', 187, CAST(N'2017-12-01' AS Date), 2220000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN013', N'NV001', N'NCC13', 176, CAST(N'2017-01-01' AS Date), 5440000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN014', N'NV013', N'NCC14', 165, CAST(N'2017-01-02' AS Date), 1120000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN015', N'NV022', N'NCC15', 154, CAST(N'2017-01-03' AS Date), 1130000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN016', N'NV001', N'NCC16', 143, CAST(N'2017-01-04' AS Date), 4320000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN017', N'NV013', N'NCC17', 132, CAST(N'2017-01-05' AS Date), 5440000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN018', N'NV022', N'NCC18', 121, CAST(N'2017-01-06' AS Date), 1120000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN019', N'NV001', N'NCC19', 111, CAST(N'2017-01-07' AS Date), 1220000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN020', N'NV013', N'NCC20', 122, CAST(N'2017-01-08' AS Date), 1320000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN021', N'NV022', N'NCC21', 133, CAST(N'2017-01-09' AS Date), 4230000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN022', N'NV001', N'NCC22', 144, CAST(N'2017-01-10' AS Date), 1430000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN023', N'NV013', N'NCC23', 155, CAST(N'2017-01-11' AS Date), 3320000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN024', N'NV022', N'NCC24', 166, CAST(N'2017-01-12' AS Date), 3150000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN025', N'NV001', N'NCC25', 177, CAST(N'2017-02-02' AS Date), 3650000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN026', N'NV013', N'NCC26', 188, CAST(N'2017-03-03' AS Date), 3870000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN027', N'NV022', N'NCC27', 199, CAST(N'2017-04-04' AS Date), 3080000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN028', N'NV001', N'NCC28', 200, CAST(N'2017-05-05' AS Date), 3340000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN029', N'NV013', N'NCC29', 124, CAST(N'2017-06-06' AS Date), 3650000)
INSERT [dbo].[PHIEUNHAP] ([mapn], [manv], [mancc], [soluongnhap], [ngaylapphieu], [tongtiennhap]) VALUES (N'PN030', N'NV022', N'NCC30', 126, CAST(N'2017-07-07' AS Date), 3750000)
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'AD', N'Admin')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'GD', N'Giám Đốc')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'KH', N'Khách Hàng')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'PBH', N'Bán Hàng')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'PGD', N'Phó Giám Đốc')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'PKT', N'Kế Toán')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'PP', N'Phó Phòng')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'PTK', N'Thủ Kho')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'QL', N'Quản Lý')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'TK', N'Thư Ký')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'TP', N'Trưởng Phòng')
INSERT [dbo].[QUYEN] ([maquyen], [tenquyen]) VALUES (N'TT', N'Thực Tập')
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00001', N'Ảo Ảnh Của Thanh Xuân', N'TL01', 10000, 10, 0, N'E:\IIS\Images\image1.gif', 1, N'Cuốn sách này chứa đựng một bí mật. Vì lợi ích của những người đọc sau, bạn đừng tiết lộ nó trong các bài nhận xét hay review, hãy giữ bí mật đó cho riêng mình (dĩ nhiên là nếu bạn phát hiện ra). Câu chuyện có ba màu xanh biển, trắng tuyết và đen […]', N'Chính trị Quốc gia', N'Trần Việt Dũng', CAST(N'2017-02-01' AS Date), 25, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00002', N'Giá Nào Cũng Yêu', N'TL02', 20000, 320, 0, N'E:\IIS\Images\image2.gif', 0, N'Lần thứ ba gặp nhau, anh cao ngạo ngỏ lới cầu hôn cô. Bởi anh không đơn thuần muốn một cô nhân tình bé nhỏ, anh muốn một người vợ để có thể hưởng thụ mọi giá trị từ cái danh phận ấy. Lần thứ ba gặp nhau, cô bình thản đồng ý làm vợ […]', N'Tư pháp', N'Ngô Khánh Duy', CAST(N'2017-01-01' AS Date), 26, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00003', N'5 Centimet Trên Giây', N'TL03', 23000, 450, 0, N'E:\IIS\Images\image3.gif', 1, N'5cm/s không chỉ là vận tốc của những cánh anh đào rơi, mà còn là vận tốc khi chúng ta lặng lẽ bước qua đời nhau, đánh mất bao cảm xúc thiết tha nhất của tình yêu. Bằng giọng văn tinh tế, truyền cảm, 5 centimet trên giây mang đến những khắc họa mới về tâm hồn và […]', N'Hồng Đức', N'Đinh Công Hoàng Hảo', CAST(N'2017-03-01' AS Date), 27, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00004', N'Quãng Thời Gian Trong Hồi Ức', N'TL04', 41000, 110, 0, N'E:\IIS\Images\image4.jpg', 1, N'"… Có lẽ đã từng lướt qua nhau trong biển người mênh mông, lúc ngoảnh đầu nhìn lại sẽ có cảm giác quen thuộc. Cũng có thể một phía vẫn còn độc thân, ánh mắt đăm đắm nhìn dán vào người kia. Cũng không loại trừ cả hai vẫn một mình, nhìn nhau nở nụ […]', N'Quân đội', N'Nguyễn Văn Đoán', CAST(N'2017-04-01' AS Date), 35, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00005', N'Chết Đi Cho Rồi', N'TL05', 22000, 140, 0, N'E:\IIS\Images\image5.gif', 1, N'Trong cuốn tiểu thuyết Chết đi cho rồi, Leonard Peacock, tác giả của Về phía mặt trời kể về một cậu bé tài giỏi, nhưng gặp nhiều vấn đề ở trường và phải sống với một bà mẹ vô tâm chỉ quan tâm tới thời trang. Cậu đi đến quyết định tự sát, và trước khi tự sát, cậu […]', N'Kim đồng', N'Đinh Vũ Khánh Duy', CAST(N'2017-05-01' AS Date), 15, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00006', N'Mẹ Chồng Ăn Thịt Cả Nhà Nàng Dâu (Tái Bản 2014)', N'TL06', 54000, 140, 0, N'E:\IIS\Images\image6.jpg', 1, N'Thúy Thúy – nàng dâu trẻ hiền lành ngoan ngoãn, gặp phải bà mẹ chồng tai quái, độc đoán và tham lam vô độ. Cô chưa kịp hưởng niềm hạnh phúc của cuộc sống mới, đã phải bước vào những chuỗi ngày u ám chốn địa ngục trần gian. Sau khi hứng chịu những trận […]', N'Thanh niên', N'Nguyễn Quốc Hòa', CAST(N'2017-06-01' AS Date), 75, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00007', N'Ngày Đẹp Hơn Sẽ Tới', N'TL07', 21000, 170, 0, N'E:\IIS\Images\image7.jpg', 1, N'Book7', N'Lao động', N'Trần Hoàng Linh', CAST(N'2017-07-01' AS Date), 55, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00008', N'Dám Yêu', N'TL08', 54000, 140, 0, N'E:\IIS\Images\image8.gif', 1, N'Điều sai lầm lớn nhất là phủ nhận những gì trái mình thực sự cảm nhận! Dám yêu là những dòng thương nhớ trong veo của mối tình đầu vụng dại, là những cung bậc cảm xúc ai rồi cũng một lần trải qua. Yêu là dám đương đầu và chấp nhận. Ở Dám yêu là cuộc sống của […]', N'Phụ nữ', N'Bùi Thanh Tân', CAST(N'2017-08-01' AS Date), 45, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00009', N'Những Nụ Hôn Điện Ảnh', N'TL09', 76000, 111, 0, N'E:\IIS\Images\image9.gif', 1, N'“Tôi không hay biết gì về nguồn gốc của mình. Tôi sinh ra tại Paris từ một người mẹ không biết mặt còn bố tôi chuyên chụp ảnh các nữ diễn viên. Ít lâu trước khi qua đời, ông mời thổ lộ với tôi rằng, tôi có mặt trên đời này là nhờ một nụ […]', N'Mỹ thuật', N'Hồ Đắc Vũ', CAST(N'2017-09-01' AS Date), 35, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00010', N'Thiên Đường Cho Con', N'TL01', 54000, 100, 0, N'E:\IIS\Images\image10.gif', 1, N'“Thiên đường cho con” là câu chuyện của tình thương và tình thân. Tác phẩm là tình yêu của một người cha muốn mang lại cho cậu con trai mặc bệnh hiểm nghèo của mình những phút giây yên bình nhất, hạnh phúc bình dị nhất; là những tâm sự của một người con xa xứ […]', N'Tôn giáo', N'Bùi Bảo Ân', CAST(N'2017-10-01' AS Date), 15, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00011', N'Đời Này Không Đổi Thay', N'TL02', 51000, 130, 0, N'E:\IIS\Images\image11.jpg', 1, N'Anh vốn là kẻ ngông cuồng tự đại, khi còn nhỏ vì bị bức ép mà phải dồn cô bạn thanh mai trúc mã của mình vào biển lửa, từ đó về sau anh hao tâm tổn sức làm biết bao chuyện nhằm bù đắp cho cô, ngày cầu hôn cũng là ngày cô quay […]', N'Tài chính', N'Vũ Minh Nghĩa', CAST(N'2017-11-01' AS Date), 55, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00012', N'Mỡ Mỡ Phiêu Lưu Ký', N'TL03', 30000, 60, 0, N'E:\IIS\Images\image12.png', 1, N'Gần đây trên cộng đồng mạng xuất hiện một gia đình lạ lùng và vô cùng nhắng nhít: Gia đình Ngộ, trong đó người chủ gia đình Ngộ Sam chính là hình ảnh lấy từ anh chàng Tiến Đạt, chàng trai sinh năm 1992, đam mê và bén duyên với hội hoạ từ năm 7 tuổi.  […]', N'Sân khấu', N'Nguyễn Hiền Phúc', CAST(N'2017-12-01' AS Date), 65, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00013', N'Truyện Cổ Tích Việt Nam Đặc Sắc – Thạch Sanh', N'TL04', 32000, 112, 0, N'E:\IIS\Images\image13.jpg', 1, N'Bộ sách tuyển chọn những câu chuyện cổ tích Việt Nam đặc sắc, với những hình ảnh minh họa rõ nét: Người con nuôi hiếu thảo, Sơn Tinh – Thủy Tinh, Ai mua hành tôi, Nợ như chúa chổm, Thạch Sanh…', N'Thế giới', N'Đào Văn Thanh', CAST(N'2017-01-31' AS Date), 75, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00014', N'Mùi Hương ( Tái Bản)', N'TL02', 35000, 14, 0, N'E:\IIS\Images\image14.gif', 1, N'Đây có phải là câu chuyện của một kẻ giết người không, xin bạn đọc hãy tự kiểm tra. Tuy nhiên, qua đánh giá của dư luận thì rõ ràng đây là một cuốn sách hay, hấp dẫn, từng nằm trong danh sách bestseller. Mùi hương cũng vừa được dựng thành phim năm 2006, tại […]', N'Thể dục Thể thao', N'Hoàng Gia Phi Khanh', CAST(N'2017-01-29' AS Date), 26, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00015', N'Zoo', N'TL05', 11000, 140, 0, N'E:\IIS\Images\image15.jpg', 1, N'Hơi lạnh phà ra từ khắp cuốn sách kinh dị này… Phà ra từ hầm ngầm, nơi các nạn nhân bị chặt thành từng mảnh nhỏ để trôi vừa qua lưới chắn cống xối, Phà ra từ bộ ảnh chụp lần lượt từng bước phân hủy xác một cô gái: đổi màu, ứa nước, rữa nát đến […]', N'Tri thức', N'Nguyễn Sơn Lâm', CAST(N'2017-01-25' AS Date), 43, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00016', N'Yêu Đi Thôi, Muộn Lắm Rồi!', N'TL06', 36800, 100, 0, N'E:\IIS\Images\image16.gif', 1, N'Nếu như ví cuộc đời mỗi người là một bản tình ca được cất lên trong một chiều đầy gió, thì tuổi trẻ và tình yêu chính là những nốt đẹp nhất trong khuôn nhạc đó mà tạo hóa ban cho mỗi chúng ta. Chúng ta trẻ và chúng ta yêu. Tình yêu đó có […]', N'Văn hóa dân tộc', N'Nguyễn Hoàng Mạnh', CAST(N'2017-02-04' AS Date), 43, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00017', N'Việt Nam Danh Tác – Tâm Hồn Tôi', N'TL07', 37600, 160, 0, N'E:\IIS\Images\image17.gif', 1, N'Cái tình trong thơ Nguyễn Bính luôn luôn mặn mà, mộc mạc, sâu sắc và tế nhị hợp với phong cách, tâm hồn của người Á Đông. Vì vậy thơ Nguyễn Bính sớm đi sâu vào tâm hồn của nhiều lớp người và đã chiếm lĩnh được cảm tình của đông đảo bạn đọc từ […]', N'Văn hóa Sài Gòn', N'Vũ Ngọc Thiên Ân', CAST(N'2017-06-02' AS Date), 77, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00018', N'Mật Thư', N'TL08', 34300, 180, 0, N'E:\IIS\Images\image18.jpeg', 1, N'Tiếp nối thành công của tập thơ “Mật thư” đến từ tác giả Nguyễn Thế Hoàng Linh sau lần in đầu tiên, vào ngày 24/5/3013, SKYBOOKS xin trân trọng giới thiệu đến những độc giả thân yêu trên toàn quốc lần tái bản thứ hai của tác phẩm này – một “Mật thư” hoàn toàn […]', N'Văn hóa Thông tin', N'Nguyễn Anh Dũng', CAST(N'2017-01-07' AS Date), 66, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00019', N'Mẹ Ơi, Con Muốn Làm Con Gái', N'TL09', 54000, 600, 0, N'E:\IIS\Images\image19.jpg', 1, N'Sinh ra là con gái, mắc kẹt trong hình hài con trai – câu chuyện này có lẽ bạn đã nghe nói tới rất nhiều lần. Nhưng đã bao giờ bạn thực sự nghĩ tới những gì đang diễn ra bên trong nội tâm họ Cô bé George là một người như thế. Em phải […]', N'Văn học', N'Nguyễn Xuân Tiến', CAST(N'2017-03-04' AS Date), 55, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00020', N'Vận Mệnh Viết Trên Những Vì Sao', N'TL01', 30400, 150, 0, N'E:\IIS\Images\image20.gif', 1, N'Bạn có muốn tìm câu trả lời cho tình yêu, sự nghiệp, tiền bạc của mình trong năm tới? Làm sao để biết khi nào mới là cơ hội “nghỉ quách” công việc hiện tại để đến với “chân trời tự do”; hay liệu có ai đó sẽ sớm bước chân vào cuộc đời bạn […]', N'Xây dựng', N'Nguyễn Long Tuấn', CAST(N'2017-05-05' AS Date), 44, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00021', N'Chỉ Tại Vợ Tôi Gợi Tình', N'TL02', 17000, 140, 0, N'E:\IIS\Images\image21.gif', 1, N'Đàn ông sinh ra là dành cho đàn bà, sự thật ấy ai dám chối cãi. Thế mà Hector lại không như thế. Gã sinh ra là để… dành cho đồ vật. Bởi gã ấy, từ thuở cha sinh mẹ đẻ, phàm là đồ vật, cái gì gã cũng sưu tầm, từ tem thư, huy […]', N'Y học', N'Nguyễn Thành Duy', CAST(N'2017-06-06' AS Date), 66, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00022', N'Những Người Thích Đùa', N'TL03', 19000, 130, 0, N'E:\IIS\Images\image22.jpg', 1, N'Khóc mà cười, cười mà lại trào nước mắt – những câu chuyện chỉ có thể là của Aziz Nesin luôn đọc người đọc vào cái trạng thái lạ lùng như vậy. Tin rằng nhà văn trào phúng như người khổng lồ có sứ mệnh nâng đỡ cả thế giới trên vai, Aziz Nesin không viết những truyện cười […]', N'Âm nhạc', N'Vũ Hiếu Trung ', CAST(N'2017-07-06' AS Date), 43, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00023', N'Ngủ Ngon, Hẹn Mai Nhé', N'TL04', 40000, 120, 0, N'E:\IIS\Images\image23.jpg', 1, N'Ngủ ngon, hẹn mai nhé là câu chuyện chua xót về một người nhút nhát khép kín, đã quen sống trong yên ấm và bao bọc, bỗng bị đẩy bật ra đời một lần nữa sau khi tình cảmtan vỡ. U uất, thất bại và bơ vơ. Giữa lúc ấy thì anh gặp cậu. Rời khỏi tổ […]', N'Chính trị Quốc gia', N'Nguyễn Quang Trưởng', CAST(N'2017-07-08' AS Date), 65, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00024', N'Trẻ Em Pháp Không Ném Thức Ăn (Tái Bản)', N'TL05', 90000, 105, 0, N'E:\IIS\Images\image24.gif', 1, N'“Trẻ em Pháp không ném thức ăn” được phát hành vào cuối năm 2011 với cái tên “French children don’t throw food” (Trẻ em Pháp không ném thức ăn), khi đã có vô số những tựa sách khác nhau viết về phương pháp giáo dục con cái, nhưng vẫn tạo ra một “cơn sốt” toàn cầu và […]', N'Công an nhân dân', N'Trần Quốc Vương', CAST(N'2017-08-01' AS Date), 98, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00025', N'Tony Buổi Sáng – Trên Đường Băng', N'TL06', 10000, 190, 0, N'E:\IIS\Images\image25.gif', 1, N'“Khi còn trẻ, hãy ra ngoài nhiều hơn ở nhà. Hãy nhào vô xin người khác “bóc hết, lột sạch” khả năng của mình. Chỉ sợ bất tài nộp hồ sơ “xin việc”, mà chả ai thèm cho, chả ai thèm bóc lột. Khi đã được bóc và lột hết, dù sau này đi đâu, […]', N'Công báo chính phủ', N'Phạm Chí Bảo', CAST(N'2017-09-10' AS Date), 76, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00026', N'Romeo Và Juliet', N'TL07', 50000, 108, 0, N'E:\IIS\Images\image26.gif', 1, N'“Ngày xưa, ở thành Verona tươi đẹp, Có hai nhà thuộc dòng thế phiệt trâm anh Mối thù xưa bỗng gây cảnh bất bình Máu lương thiện, tay người lành nhuộm đỏ. Số phận éo le, thâm thù hai họ Lại khéo xui sinh hạ đôi tình nhân, Mối tình ai thê thảm muôn phần […]', N'Cục báo chí', N'Nguyễn Trung Nghĩa', CAST(N'2017-11-11' AS Date), 54, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00027', N'Về Bản Tính Người', N'TL08', 87000, 120, 0, N'E:\IIS\Images\image27.gif', 1, N'Không một người nào thực sự quan tâm đến tương lai nhân lọai mà có thể bỏ qua cuốn sách Về bản tính người của   E. O. Wilson. Hành vi của con người có bị kiểm soát bởi di sản sinh học của giống loài không? Di sản này có khiến cho số phận loài […]', N'Giáo dục', N'Nguyễn Minh Phát', CAST(N'2017-01-01' AS Date), 34, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00028', N'PR – Lý Luận Và Ứng Dụng (Tái Bản 2014)', N'TL09', 12000, 150, 0, N'E:\IIS\Images\image28.gif', 1, N'PR, ứng dụng của lý thuyết truyền thông, là nghệ thuật thuyết phục công chúng đặc biệt quan trọng trong việc tạo lập các mối quan hệ lâu dài và có lợi, xây dựng và duy trì hình ảnh, thương hiệu, uy tín cho một tổ chức, bất kể tổ chức đó là một doanh […]', N'Giao thông vận tải', N'Hoàng Đức Thiện', CAST(N'2017-01-01' AS Date), 54, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00029', N'Bánh Bèo Phiêu Lưu Ký', N'TL01', 87000, 180, 0, N'E:\IIS\Images\image29.jpg', 1, N'Bánh bèo phiêu lưu ký – Tuổi trẻ, Sợ gì không đi! Đi để đến, để sống và để cháy hết mình từng phút giây Nếu được ban tặng một đôi cánh, liệu bạn có muốn bay đến vùng đất xa lạ nào đó? Nếu có cơ hội trải nghiệm, liệu bạn có muốn xách […]', N'Lao động', N'Phạm Đình Tụng', CAST(N'2017-01-01' AS Date), 76, 0, NULL)
INSERT [dbo].[SACH] ([masach], [tensach], [matheloai], [dongiaban], [luotmua], [khuyenmai], [anhbia], [tinhtrang], [mota], [nhaxuatban], [tacgia], [ngayxuatban], [soluongton], [delflag], [timedel]) VALUES (N'S00030', N'Cô Gái Đan Mạch', N'TL02', 96000, 170, 0, N'E:\IIS\Images\image30.gif', 1, N'The Danish girl – Cô gái Đan Mạch là một câu chuyện cảm động về người chuyển giới đầu tiên trên thế giới, một họa sĩ người Đan Mạch đã dũng cảm đối diện và tìm về với bản ngã của chính mình. Đây cũng là câu chuyện về lòng vị tha, đức hy sinh trong tình […]', N'Lý luận chính trị', N'Nguyễn Thành Duy', CAST(N'2017-01-01' AS Date), 11, 0, NULL)
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL01', N'Sách Hài hước')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL02', N'Sách Thiếu Nhi')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL03', N'Sách Lãng mạn')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL04', N'Sách Phiêu lưu')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL05', N'Sách Chuyên Ngành')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL06', N'Sách Kinh dị')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL07', N'Sách Công nghệ')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL08', N'Sách Nhân văn')
INSERT [dbo].[THELOAI] ([matheloai], [tentheloai]) VALUES (N'TL09', N'Sách Tuổi Mới Lớn')

