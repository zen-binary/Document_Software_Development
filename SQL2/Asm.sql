CREATE DATABASE Assignment2
GO

USE Assignment2
GO

CREATE TABLE NhanVien(
	MaNv VARCHAR(10) PRIMARY KEY,
	HoTen NVARCHAR(50),
	GioiTinh BIT,
	LuongCoBan MONEY,
	PhongBan VARCHAR(10),
	BacLuong VARCHAR(10)
)
GO

CREATE TABLE PhongBan(
	MaPb VARCHAR(10) PRIMARY KEY,
	Ten NVARCHAR(50),
	TruongPhuong VARCHAR(10)

)
GO

CREATE TABLE BacLuong(
	MaBl VARCHAR(10) PRIMARY KEY,
	HeSoLuong FLOAT,
	PhuCap MONEY
)

ALTER TABLE dbo.NhanVien ADD CONSTRAINT fk_NhanVien_PhongBan FOREIGN KEY(PhongBan) REFERENCES dbo.PhongBan(MaPb)
ALTER TABLE dbo.NhanVien ADD CONSTRAINT fk_NhanVien_BacLuong FOREIGN KEY(BacLuong) REFERENCES dbo.BacLuong(MaBl)

GO
INSERT INTO dbo.NhanVien
(
    MaNv,
    HoTen,
    GioiTinh,
    LuongCoBan,
    PhongBan,
    BacLuong
)
VALUES
(   'NV0001',  -- Ma - varchar(6)
    N'Trần Văn An', -- HoTen - nvarchar(50),
	1,
    38521188, 
    'DP003',  -- PhongBan - varchar(5)
    'LV1'   -- BacLuong - varchar(3)
    ),
(   'NV0002',  -- Ma - varchar(6)
    N'Lý Thị Bình', -- HoTen - nvarchar(50),
	0,
    11742782,
    'DP002',  -- PhongBan - varchar(5)
    'LV4'   -- BacLuong - varchar(3)
    ),
(   'NV0003',  -- Ma - varchar(6)
    N'Dương Thu Cúc', -- HoTen - nvarchar(50),
	0,
    25584611, 
    'DP001',  -- PhongBan - varchar(5)
    'LV3'   -- BacLuong - varchar(3)
    ),
(   'NV0004',  -- Ma - varchar(6)
    N'Đinh Quốc Trường Dương', -- HoTen - nvarchar(50),
	1,
    33258559, 
    'DP003',  -- PhongBan - varchar(5)
    'LV1'   -- BacLuong - varchar(3)
    ),
(   'NV0005',  -- Ma - varchar(6)
    N'Phan Thanh', -- HoTen - nvarchar(50),
    1,
	14792267,
    'DP001',  -- PhongBan - varchar(5)
    'LV5'   -- BacLuong - varchar(3)
    )
GO


INSERT INTO dbo.PhongBan
(
    MaPb,
    Ten,
    TruongPhuong
)
VALUES
(   'DP001',  -- Ma - varchar(5)
    N'Phòng Nghiên cứu và Phát triển', -- Ten - nvarchar(50)
    'NV0005'   -- TruongPhong - varchar(6)
    ),
(   'DP002',  -- Ma - varchar(5)
    N'Phòng Kinh doanh', -- Ten - nvarchar(50)
    'NV0002'   -- TruongPhong - varchar(6)
    ),
(   'DP003',  -- Ma - varchar(5)
    N'Phòng Truyền thông và Thiết kế', -- Ten - nvarchar(50)
    'NV0001'   -- TruongPhong - varchar(6)
    )

GO

INSERT INTO dbo.BacLuong
(
    MaBl,
    HeSoLuong,
    PhuCap
)
VALUES
(   'LV1',  -- Ma - varchar(3)
    1.0, -- HeSoLuong - float
    1000000.0  -- PhuCap - float
    ),
(   'LV2',  -- Ma - varchar(3)
    1.2, -- HeSoLuong - float
    1000000.0  -- PhuCap - float
    ),
(   'LV3',  -- Ma - varchar(3)
    1.5, -- HeSoLuong - float
    1000000  
    ),
(   'LV4',  -- Ma - varchar(3)
    2.0, -- HeSoLuong - float
    1000000
    ),
(   'LV5',  -- Ma - varchar(3)
    2.5, -- HeSoLuong - float
    2000000
    )
GO

SELECT *FROM dbo.NhanVien
SELECT *FROM dbo.PhongBan
SELECT *FROM dbo.BacLuong


GO

CREATE PROC SP_ThemNv
(@ma VARCHAR(10),
@hoTen NVARCHAR(50),
@gioiTinh BIT, 
@luongCb MONEY,
@phongBan VARCHAR(10),
@bacLuong VARCHAR(10))
AS
BEGIN
    
	INSERT INTO dbo.NhanVien
	(
	    MaNv,
	    HoTen,
	    GioiTinh,
	    LuongCoBan,
	    PhongBan,
	    BacLuong
	)
	VALUES
	(   @ma,   -- MaNv - varchar(10)
	    @hoTen,  -- HoTen - nvarchar(50)
	    @gioiTinh, -- GioiTinh - bit
	    @luongCb, -- LuongCoBan - money
	    @phongBan,   -- PhongBan - varchar(10)
	    @bacLuong    -- BacLuong - varchar(10)
	    )
END







GO

EXEC dbo.SP_ThemNv @ma = 'NV0006',         -- varchar(10)
                   @hoTen = N'Lại văn chiến',     -- nvarchar(50)
                   @gioiTinh = 1, -- bit
                   @luongCb = 300000,  -- money
                   @phongBan = 'DP003',   -- varchar(10)
                   @bacLuong = 'LV4'    -- varchar(10)
GO



CREATE PROC SP_ThemPhongBan 
(@maPb VARCHAR(10),
@ten NVARCHAR(50),
@truongPhong VARCHAR(10)
)
AS 
BEGIN
    INSERT INTO dbo.PhongBan
    (
        MaPb,
        Ten,
        TruongPhuong
    )
    VALUES
    (   @maPb,  -- MaPb - varchar(10)
        @ten, -- Ten - nvarchar(50)
        @truongPhong   -- TruongPhuong - varchar(10)
        )

END
GO

EXEC dbo.SP_ThemPhongBan @maPb = 'DP006',       -- varchar(10)
                         @ten = N'Dotemon',       -- nvarchar(50)
                         @truongPhong = 'nobita' -- varchar(10)
GO


CREATE PROC SP_ThemBacLuong
(@ma VARCHAR(10),
@heSl FLOAT,
@phuCap MONEY)
AS
BEGIN
    INSERT INTO dbo.BacLuong
    (
        MaBl,
        HeSoLuong,
        PhuCap
    )
    VALUES
    (   @ma,  -- MaBl - varchar(10)
        @heSl, -- HeSoLuong - float
        @phuCap -- PhuCap - money
        )
END
GO

EXEC dbo.SP_ThemBacLuong @ma = 'LV7',      -- varchar(10)
                         @heSl = 1.0,   -- float
                         @phuCap = 100000 -- money
GO

CREATE FUNCTION F_Vnd2Euro 
(@moneyVND MONEY)
RETURNS VARCHAR(50)
AS 
BEGIN
    DECLARE @euro MONEY

	SELECT @euro = ROUND(@moneyVND * 0.000043,3)
	RETURN CONVERT(VARCHAR(50),@euro) + 'Euro'
END
GO
--
PRINT dbo.F_Vnd2Euro(10000000)

GO

CREATE FUNCTION F_Gender2String
(@gt BIT)
RETURNS NVARCHAR(20)
AS
BEGIN
    IF @gt = 0
	BEGIN
	    RETURN N'Nam'
	END
	ELSE
	IF @gt = 1
	BEGIN
	    RETURN N'Nữ'
	END
    RETURN N'Không xác định'
END
GO

PRINT dbo.F_Gender2String(0)
GO

SELECT *FROM dbo.PhongBan
SELECT *FROM dbo.BacLuong
GO

SELECT * FROM dbo.NhanVien JOIN dbo.PhongBan ON dbo.NhanVien.PhongBan = PhongBan.MaPb
WHERE MaPb = 'DP002'
GO
CREATE FUNCTION F_FindSalary_1
(@maPb VARCHAR(10))
RETURNS MONEY
AS 

BEGIN
    DECLARE @luongCb MONEY
	SELECT @luongCb = LuongCoBan FROM dbo.NhanVien JOIN dbo.PhongBan ON dbo.NhanVien.PhongBan = PhongBan.MaPb
	WHERE MaPb = @maPb 
	RETURN @luongCb + ''
END    
GO

PRINT dbo.F_FindSalary_1('DP002')

GO

CREATE VIEW V_NhanVien_1
AS
SELECT MaNv, HoTen, LuongCoBan * HeSoLuong AS N'Thu nhập khong tính phụ cấp' FROM dbo.NhanVien JOIN dbo.BacLuong ON dbo.NhanVien.BacLuong = BacLuong.MaBl JOIN dbo.PhongBan ON dbo.NhanVien.PhongBan = PhongBan.MaPb
GO
--
SELECT *FROM dbo.V_NhanVien_1
GO

--8
	SELECT MaNv, HoTen, dbo.F_Gender2String(GioiTinh) AS 'Giới tính',CONVERT(VARCHAR(50),LuongCoBan* HeSoLuong +PhuCap) + 'VNd' AS VND , dbo.F_Vnd2Euro(LuongCoBan* HeSoLuong +PhuCap)  AS 'Euro'  FROM dbo.NhanVien JOIN dbo.BacLuong ON dbo.NhanVien.BacLuong = dbo.BacLuong.MaBl JOIN dbo.PhongBan ON dbo.NhanVien.PhongBan = dbo.PhongBan.MaPb
	ORDER BY dbo.F_Vnd2Euro(LuongCoBan* HeSoLuong +PhuCap) 

	GO
    
	ALTER VIEW V_NhanVien_2
	AS 
    SELECT TOP 100 MaNv, HoTen, dbo.F_Gender2String(GioiTinh) AS 'Giới tính',CONVERT(VARCHAR(50),LuongCoBan* HeSoLuong +PhuCap) + 'VNd' AS VND , dbo.F_Vnd2Euro(LuongCoBan* HeSoLuong +PhuCap)  AS 'Euro'  FROM dbo.NhanVien JOIN dbo.BacLuong ON dbo.NhanVien.BacLuong = dbo.BacLuong.MaBl JOIN dbo.PhongBan ON dbo.NhanVien.PhongBan = dbo.PhongBan.MaPb
	ORDER BY dbo.F_Vnd2Euro(LuongCoBan* HeSoLuong +PhuCap) ASC
	GO
    
	SELECT *FROM dbo.V_NhanVien_2

--9
SELECT *FROM dbo.NhanVien
DELETE dbo.NhanVien
WHERE MaNv  = 'NV0006'
GO

CREATE TRIGGER T_PrintNhanVien ON dbo.NhanVien
INSTEAD OF DELETE
AS

BEGIN
    
	DECLARE @maNv VARCHAR(10)  = (SELECT Deleted.MaNv FROM Deleted JOIN dbo.BacLuong ON Deleted.BacLuong = dbo.BacLuong.MaBl)
	DECLARE @heSoluong FLOAT = (SELECT HeSoLuong FROM Deleted JOIN dbo.BacLuong ON Deleted.BacLuong = dbo.BacLuong.MaBl)
	PRINT 'Xoa ' + CONVERT(VARCHAR(10), @maNv)+ ' he so'  +CONVERT(VARCHAR(50),@heSoluong) 
	DELETE dbo.NhanVien
	WHERE MaNv = @maNv


END
GO

SELECT *FROM dbo.NhanVien
GO

DELETE dbo.NhanVien
WHERE MaNv = 'NV0005'


--10

CREATE PROC SP_XoaPhongBan
(@maPb VARCHAR(10))
AS 
BEGIN
    
	DELETE dbo.PhongBan
	WHERE MaPb = @maPb
	ROLLBACK 
END





