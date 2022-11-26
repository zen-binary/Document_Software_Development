CREATE DATABASE Lab78_Com2034
GO

USE Lab78_Com2034
GO

CREATE TABLE TheLoai(
	maTl VARCHAR(10) PRIMARY KEY,
	tenTl NVARCHAR(50),
	moTa NVARCHAR(50),
	hanCheTuoi INT
)
GO


CREATE TABLE TacGia(
	maTg VARCHAR(10) PRIMARY KEY,
	tenTg NVARCHAR(50),
	namSinh INT,
	gioiTinh bit
)
GO

CREATE TABLE NhaXB(
	maNxb VARCHAR(10) PRIMARY KEY,
	tenNxb NVARCHAR(50),
	diaChi NVARCHAR(50),
	sdt VARCHAR(12)
)
GO

CREATE TABLE TruyenTranh(
	maTt VARCHAR(10) PRIMARY KEY,
	tenTt NVARCHAR(50),
	maTg VARCHAR(10),
	maTl VARCHAR(10),
	maNxb VARCHAR(10)
	CONSTRAINT fk_tg FOREIGN KEY(maTg) REFERENCES dbo.TacGia(maTg),
	CONSTRAINT fk_tl FOREIGN KEY(maTl) REFERENCES dbo.TheLoai(maTl),
	CONSTRAINT fk_nxb FOREIGN KEY(maNxb) REFERENCES dbo.NhaXB(maNxb)
)
GO


CREATE PROC Insert_TheLoai
	(@maTl VARCHAR(10), @tenTl NVARCHAR(50), @moTa NVARCHAR(50), @hanCheTuoi INT)
AS
BEGIN
    INSERT INTO dbo.TheLoai
    (
        maTl,
        tenTl,
        moTa,
        hanCheTuoi
    )
    VALUES
    (   @maTl,  -- maTl - varchar(10)
        @tenTl, -- tenTl - nvarchar(50)
        @moTa, -- moTa - nvarchar(50)
        @hanCheTuoi    -- hanCheTuoi - int
        )
END
GO

EXEC dbo.Insert_TheLoai @maTl = 'A065',     -- varchar(10)
                   @tenTl = N'Anime4',   -- nvarchar(50)
                   @moTa = N'Hoạt Hình',    -- nvarchar(50)
                   @hanCheTuoi = 18 -- int
GO
SELECT *FROM dbo.TheLoai
GO


CREATE PROC Insert_TacGia
	(@maTg VARCHAR(10),
	@tenTg NVARCHAR(50),
	@namSinh INT,
	@gioiTinh bit)
	AS
	BEGIN
	    INSERT INTO dbo.TacGia
	    (
	        maTg,
	        tenTg,
	        namSinh,
	        gioiTinh
	    )
	    VALUES
	    (   @maTg,  -- maTg - varchar(10)
	        @tenTg, -- tenTg - nvarchar(50)
	        @namSinh,   -- namSinh - int
	        @gioiTinh -- gioiTinh - bit
	        )
	END
GO

SELECT *FROM dbo.TacGia
EXEC dbo.Insert_TacGia @maTg = 'TG065223',      -- varchar(10)
                       @tenTg = N'Doraemon4',    -- nvarchar(50)
                       @namSinh = 1990,    -- int
                       @gioiTinh = 1 -- bit
GO

CREATE PROC INSERT_NhaXb(
	@maNxb VARCHAR(10),
	@tenNxb NVARCHAR(50),
	@diaChi NVARCHAR(50),
	@sdt VARCHAR(12)
)
AS
BEGIN
    INSERT INTO dbo.NhaXB
    (
        maNxb,
        tenNxb,
        diaChi,
        sdt
    )
    VALUES
    (   @maNxb,  -- maNxb - varchar(10)
        @tenNxb, -- tenNxb - nvarchar(50)
        @diaChi, -- diaChi - nvarchar(50)
        @sdt   -- sdt - varchar(12)
        )

END
GO

SELECT *FROM dbo.NhaXB
EXEC dbo.INSERT_NhaXb @maNxb = 'NXB0266343',   -- varchar(10)
                      @tenNxb = N'Mihoho2', -- nvarchar(50)
                      @diaChi = N'Hà nội', -- nvarchar(50)
                      @sdt = '123456789'      -- varchar(12)

GO


CREATE FUNCTION viewGioiTinh1
	(@gt VARCHAR(10))
RETURNS NVARCHAR(50)
AS
BEGIN
	IF @gt != 0 AND @gt !=1 
	BEGIN
	    RETURN N'Chưa rõ || Nhập gt phải là 0 hoặc 1'
	END
	ELSE
    IF @gt = 0
	BEGIN
	  RETURN N'Giới Tính Nữ'
	END
	ELSE
	IF @gt = 1
	BEGIN
	   RETURN N'Giới Tính Nam'
	END
	RETURN N'Chưa rõ'
	
END

GO

PRINT dbo.viewGioiTinh1(1)
GO


CREATE FUNCTION TinhTuoi
	(@namsinh INT)
	RETURNS NVARCHAR(50) 
AS

BEGIN
    
	IF @namsinh < 0
	BEGIN
	    RETURN 'Năm sinh phải lớn hơn 0' 
	END
	DECLARE @tuoi INT = YEAR(GETDATE()) - @namsinh
	RETURN N'Tuoi là ' + CONVERT(NVARCHAR(10), @tuoi) 
END
GO
PRINT dbo.TinhTuoi(2000)
GO
DROP TRIGGER Delete_TheLoai
GO

---

CREATE VIEW Ds_TruyenTranh1 
AS
SELECT  maTt, dbo.TruyenTranh.tenTt, dbo.TacGia.tenTg,  namSinh FROM dbo.TruyenTranh JOIN dbo.TacGia ON TacGia.maTg = TruyenTranh.maTg
GO


SELECT *FROM dbo.Ds_TruyenTranh1


INSERT INTO dbo.TruyenTranh
(
    maTt,
    tenTt,
    maTg,
    maTl,
    maNxb
)
VALUES
(   'TT07',  -- maTt - varchar(10)
    N'Naruto', -- tenTt - nvarchar(50)
    'TG02',  -- maTg - varchar(10)
    'A065',  -- maTl - varchar(10)
    'NXB0266'   -- maNxb - varchar(10)
    )
	GO
SELECT * FROM dbo.TruyenTranh
SELECT *FROM dbo.TacGia
SELECT *FROM dbo.NhaXB
SELECT * FROM dbo.TheLoai

GO



CREATE VIEW HienThiDsTT
AS

SELECT maTt , tenTt, tenTg, YEAR(GETDATE()) - namSinh AS N'Tuổi' , gioiTinh , tenTl , hanCheTuoi , tenNxb , sdt FROM dbo.TruyenTranh JOIN dbo.TacGia ON TacGia.maTg = TruyenTranh.maTg  JOIN dbo.TheLoai ON TheLoai.maTl = TruyenTranh.maTl JOIN dbo.NhaXB ON NhaXB.maNxb = TruyenTranh.maNxb
GO

SELECT *FROM dbo.HienThiDsTT
GO


 PROC delete_truyentranh
(@tuoiHanChe INT)
AS 
BEGIN	

	DELETE dbo.TheLoai 
	WHERE hanCheTuoi  = @tuoiHanChe
       
END
SELECT *FROM dbo.TheLoai
GO

EXEC dbo.delete_truyentranh @tuoiHanChe = 17 -- int


INSERT INTO dbo.TheLoai
(
    maTl,
    tenTl,
    moTa,
    hanCheTuoi
)
VALUES
(   'A023',  -- maTl - varchar(10)
    N'A065', -- tenTl - nvarchar(50)
    N'sdfs', -- moTa - nvarchar(50)
    17    -- hanCheTuoi - int
    )

	GO
    
CREATE TRIGGER Delete_TheLoai1
ON dbo.TheLoai
INSTEAD OF DELETE
AS
BEGIN
	DECLARE @tenTheLoai NVARCHAR(50) = (SELECT tenTl FROM Deleted);
	
	PRINT 'Xóa ' + @tenTheLoai
	DELETE dbo.TheLoai 
	WHERE maTl = (SELECT Deleted.maTl FROM Deleted) 

END
GO
SELECT * FROM dbo.TheLoai

DELETE dbo.TheLoai
WHERE maTl = 'A01'
GO

CREATE TRIGGER Delete_tacGia
ON dbo.TacGia
INSTEAD OF DELETE
AS
BEGIN
    DECLARE @tentg NVARCHAR(50) = (SELECT Deleted.tenTg FROM Deleted)			
	PRINT 'Xóa ' + @tentg
	DELETE dbo.TacGia
	WHERE maTg = (SELECT Deleted.maTg FROM Deleted)

END
SELECT *FROM dbo.TacGia

DELETE dbo.TacGia
WHERE maTg  = 'TG01'

GO


CREATE TRIGGER delete_nxb
ON dbo.NhaXB
INSTEAD OF DELETE
AS
BEGIN
    DECLARE @tennxb NVARCHAR(50) = (SELECT Deleted.tenNxb FROM Deleted)			
	PRINT 'Xóa ' + @tennxb

END

GO


SELECT *FROM dbo.NhaXB

DELETE dbo.NhaXB 
WHERE maNxb = 'NXB01'
 