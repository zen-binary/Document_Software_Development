CREATE DATABASE ASM_JAVA3
GO

USE ASM_JAVA3
GO


CREATE TABLE Users(
	UserName NVARCHAR(50) PRIMARY KEY,
	PassWord NVARCHAR(50),
	Role NVARCHAR(50)
)
GO

CREATE TABLE Students(
	MaSv NVARCHAR(50) PRIMARY KEY,
	HoTen NVARCHAR(50),
	Email NVARCHAR(50),
	SoDT NVARCHAR(50),
	GioiTinh BIT,
	DiaChi NVARCHAR(50),
	Hinh NVARCHAR(50)
)
GO

CREATE TABLE Grade(
	Id INT PRIMARY KEY,
	MaSv NVARCHAR(50),
	TiengAnh INT,
	TinHoc INT,
	GDTC INT
	FOREIGN KEY(MaSv) REFERENCES dbo.Students(MaSv)
)
GO

insert into Students(MaSv, HoTen,Email, GioiTinh ,DiaChi ,Hinh) values('PH004', 'Nguyễn Văn Bình', 'mail322@gmail.com', 1 , 'Hà Nam', NULL)
,('PH005', N'Nguyễn Văn Bắc', 'mail322@gmail.com', 1 , N'Hà Nam', NULL),
('PH006', N'Nguyễn Văn Hằng', 'mail45@gmail.com', 1 , N'Hà Nội', NULL)
,('PH007', N'Nguyễn Thị Hoa', 'mail4352@gmail.com', 0 , N'Hà Nam', NULL)
,('PH008', N'Nguyễn Thị Hoàng', 'mail2342@gmail.com', 0 , N'Hà Nam', NULL)
,('PH009', N'Nguyễn Văn Hưng', 'mail33242@gmail.com', 1 , N'Hà Nam', NULL),
('PH0010', N'Nguyễn Thi Bình', 'mail34522@gmail.com', 0 , N'Hà Nam', NULL)


INSERT INTO dbo.Grade
(
    Id,
    MaSv,
    TiengAnh,
    TinHoc,
    GDTC
)
VALUES
(   01,   -- Id - int
    N'PH001', -- MaSv - nvarchar(50)
    9,   -- TiengAnh - int
    5,   -- TinHoc - int
    8    -- GDTC - int
    ),
(   02,   -- Id - int
    N'PH002', -- MaSv - nvarchar(50)
    5,   -- TiengAnh - int
    5,   -- TinHoc - int
    4    -- GDTC - int
    ),

(   03,   -- Id - int
    N'PH003', -- MaSv - nvarchar(50)
    7,   -- TiengAnh - int
    1,   -- TinHoc - int
    9    -- GDTC - int
    )
,
(   04,   -- Id - int
    N'PH004', -- MaSv - nvarchar(50)
    9,   -- TiengAnh - int
    9,   -- TinHoc - int
    9    -- GDTC - int
    ),
(   05,   -- Id - int
    N'PH005', -- MaSv - nvarchar(50)
    10,   -- TiengAnh - int
    7,   -- TinHoc - int
    10    -- GDTC - int
    ),
(   06,   -- Id - int
    N'PH006', -- MaSv - nvarchar(50)
    9,   -- TiengAnh - int
    8,   -- TinHoc - int
    8    -- GDTC - int
    ),
(   07,   -- Id - int
    N'PH007', -- MaSv - nvarchar(50)
    9,   -- TiengAnh - int
    5,   -- TinHoc - int
    10    -- GDTC - int
    ),
	(   08,   -- Id - int
    N'PH008', -- MaSv - nvarchar(50)
    9,   -- TiengAnh - int
    9,   -- TinHoc - int
    8    -- GDTC - int
    ),
	(   09,   -- Id - int
    N'PH009', -- MaSv - nvarchar(50)
    7,   -- TiengAnh - int
    5,   -- TinHoc - int
    8    -- GDTC - int
    ),
	(   010,   -- Id - int
    N'PH0010', -- MaSv - nvarchar(50)
    7,   -- TiengAnh - int
    5,   -- TinHoc - int
    7    -- GDTC - int
    )
GO



INSERT INTO dbo.Users
(
    UserName,
    PassWord,
    Role
)
VALUES
(   N'admin', -- UserName - nvarchar(50)
    N'admin', -- PassWord - nvarchar(50)
    N'Students'  -- Role - nvarchar(50)
    ),
(   N'adminv2', -- UserName - nvarchar(50)
    N'admin', -- PassWord - nvarchar(50)
    N'Students'  -- Role - nvarchar(50)
    ),
(   N'chienlv', -- UserName - nvarchar(50)
    N'123', -- PassWord - nvarchar(50)
    N'Students'  -- Role - nvarchar(50)
    ),
(   N'chienlai', -- UserName - nvarchar(50)
    N'123', -- PassWord - nvarchar(50)
    N'Grade'  -- Role - nvarchar(50)
    ),
(   N'chienlaiv2', -- UserName - nvarchar(50)
    N'123', -- PassWord - nvarchar(50)
    N'Grade'  -- Role - nvarchar(50)
    )

