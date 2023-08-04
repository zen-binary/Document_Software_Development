CREATE DATABASE DB_Dynamic
GO
USE DB_Dynamic
GO

CREATE TABLE ThuocTinh(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(50)
)
CREATE TABLE GiaTriThuocTinh(
	Id INT IDENTITY PRIMARY KEY,
	IdTT INT FOREIGN KEY REFERENCES dbo.ThuocTinh(Id),
	Ten NVARCHAR(50)
)
GO 
CREATE TABLE SanPham(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(50),
	MoTa NVARCHAR(100)
)
GO
CREATE TABLE SanPham_GiaTTT(
	Id INT IDENTITY PRIMARY KEY,
	IdSp INT FOREIGN KEY REFERENCES dbo.SanPham(Id),
	IdGttt INT FOREIGN KEY REFERENCES dbo.GiaTriThuocTinh(Id)
)
GO


INSERT INTO dbo.SanPham
(
    Ten,
    MoTa
)
VALUES
(   N'Dép', -- Ten - nvarchar(50)
    NULL  -- MoTa - nvarchar(100)
    ),
(   N'Giày', -- Ten - nvarchar(50)
    NULL  -- MoTa - nvarchar(100)
    )
GO
INSERT INTO dbo.ThuocTinh
(
    Ten
)
VALUES
('Size' -- Ten - nvarchar(50)
    ),
	(N'Màu Sắc' -- Ten - nvarchar(50)
    )
INSERT INTO dbo.GiaTriThuocTinh
(
    IdTT,
    Ten
)
VALUES
(   1, -- IdTT - int
    '41'  -- Ten - nvarchar(50)
    ),
	(   1, -- IdTT - int
    '42'  -- Ten - nvarchar(50)
    ),
	(   2, -- IdTT - int
    N'Đỏ'  -- Ten - nvarchar(50)
    )
GO
INSERT INTO dbo.SanPham_GiaTTT
(
    IdSp,
    IdGttt
)
VALUES
(   1, -- IdSp - int
    1  -- IdGttt - int
    ),
	(   1, -- IdSp - int
    2  -- IdGttt - int
    )
GO

SELECT * FROM dbo.SanPham JOIN dbo.SanPham_GiaTTT ON SanPham_GiaTTT.IdSp = SanPham.Id JOIN dbo.GiaTriThuocTinh ON GiaTriThuocTinh.Id = SanPham_GiaTTT.IdGttt JOIN dbo.ThuocTinh ON ThuocTinh.Id = GiaTriThuocTinh.IdTT WHERE dbo.ThuocTinh.Ten LIKE 'Size'