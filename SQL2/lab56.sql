CREATE DATABASE Lab56
GO

USE Lab56
GO

CREATE TABLE Oto(
	MaOto VARCHAR(10) NOT NULL PRIMARY KEY,
	TenOto NVARCHAR(50) NULL,
	ThuongHieu NVARCHAR(50) NULL,
	DungTich FLOAT NULL,
	ChoNgoi INT NULL
)

GO

CREATE TABLE DieuHoa(
	MaDh VARCHAR(10) NOT NULL PRIMARY KEY,
	TenDh NVARCHAR(50) NULL,
	Loai VARCHAR(5) NULL,
	CongXuat FLOAT NULL,
	LuuLuongGio FLOAT NULL
)
GO

--1
CREATE PROCEDURE Insert_Oto
	@ma VARCHAR(10), 
	@ten NVARCHAR(50),
	@thuongHieu NVARCHAR(50),
	@dungTich FLOAT,
	@choNgoi INT

	AS
	IF @choNgoi > 0 
	BEGIN
	INSERT INTO dbo.Oto
	(
	    MaOto,
	    TenOto,
	    ThuongHieu,
	    DungTich,
	    ChoNgoi
	)
	VALUES
	(   @ma,  -- MaOto - varchar(10)
	    @ten, -- TenOto - nvarchar(50)
	    @thuongHieu, -- ThuongHieu - nvarchar(50)
	    @dungTich, -- DungTich - float
	    @choNgoi    -- ChoNgoi - int
	    )
	END
	ELSE
	BEGIN
	    PRINT N'Chỗ ngồi phải lớn hơn 0'
	END

GO


EXEC dbo.Insert_Oto @ma = 'A3',          -- varchar(10)
                    @ten = N'Mec',        -- nvarchar(50)
                    @thuongHieu = N'HonDa', -- nvarchar(50)
                    @dungTich = 7.0,   -- float
                    @choNgoi = 4       -- int
GO
SELECT *FROM dbo.Oto
GO
--

CREATE PROCEDURE INSERT_DieuHoa
	@ma VARCHAR(10),
	@ten NVARCHAR(50),
	@loai VARCHAR(5),
	@congXuat FLOAT,
	@luuLuongGio FLOAT
AS
	IF @loai LIKE 'Y' OR @loai LIKE 'N'
BEGIN
	INSERT INTO dbo.DieuHoa
	(
	    MaDh,
	    TenDh,
	    Loai,
	    CongXuat,
	    LuuLuongGio
	)
	VALUES
	(   @ma,   -- MaDh - varchar(10)
	    @ten,  -- TenDh - nvarchar(50)
	    @loai, -- Loai - varchar(5)
	    @congXuat,  -- CongXuat - float
	    @luuLuongGio   -- LuuLuongGio - float
	    )
END
ELSE 
BEGIN
    PRINT N'Loại phải là Y hoặc N'
END

GO

EXEC dbo.INSERT_DieuHoa @ma = 'D03',          -- varchar(10)
                        @ten = N'Điều Hòa Xanh',        -- nvarchar(50)
                        @loai = Y,      -- bit
                        @congXuat = 7.0,   -- float
                        @luuLuongGio = 2.0 -- float

GO
SELECT *FROM dbo.DieuHoa
GO


--2
CREATE PROCEDURE Update_Oto
	@ma VARCHAR(10),
	@choNgoi INT
AS 
BEGIN
    UPDATE dbo.Oto
	SET ChoNgoi = @choNgoi
	WHERE MaOto = @ma
END
GO
SELECT *FROM dbo.Oto
EXEC dbo.Update_Oto @ma = 'A2',    -- varchar(10)
                    @choNgoi = 10 -- int
GO

--
CREATE PROCEDURE Update_DieuHoa
	@ma VARCHAR(10),
	@luuLuongGio FLOAT
AS
BEGIN
    UPDATE dbo.DieuHoa
	SET LuuLuongGio = @luuLuongGio
	WHERE MaDh = @ma
END
GO

SELECT *FROM dbo.DieuHoa
EXEC dbo.Update_DieuHoa @ma = 'D02',          -- varchar(10)
                        @luuLuongGio = 10.0 -- float
GO

--3
CREATE PROCEDURE Delete_Oto
	@dungTich FLOAT

AS 
BEGIN
	DELETE dbo.Oto
	WHERE DungTich = @dungTich
END
GO
SELECT *FROM dbo.Oto
EXEC dbo.Delete_Oto @dungTich = 7.0 -- float

GO


CREATE PROCEDURE Delete_DieuHoa
	@congXuat FLOAT
	AS
	BEGIN
	    DELETE dbo.DieuHoa
		WHERE CongXuat = @congXuat
	END
	GO
    
SELECT *FROM dbo.DieuHoa
EXEC dbo.Delete_DieuHoa @congXuat = 7.0 -- float
GO



--4
EXEC dbo.INSERT_DieuHoa @ma = 'D006',          -- varchar(10)
                        @ten = N'Màu đỏ',        -- nvarchar(50)
                        @loai = 'v',        -- varchar(5)
                        @congXuat = 6.0,   -- float
                        @luuLuongGio = 3.0 -- float

GO


CREATE PROCEDURE Insert_Oto_CHk
	@ma VARCHAR(10), 
	@ten NVARCHAR(50),
	@thuongHieu NVARCHAR(50),
	@dungTich FLOAT,
	@choNgoi INT

	AS
	IF @choNgoi > 0
	BEGIN 
	INSERT INTO dbo.Oto
	(
	    MaOto,
	    TenOto,
	    ThuongHieu,
	    DungTich,
	    ChoNgoi
	)
	VALUES
	(   @ma,  -- MaOto - varchar(10)
	    @ten, -- TenOto - nvarchar(50)
	    @thuongHieu, -- ThuongHieu - nvarchar(50)
	    @dungTich, -- DungTich - float
	    @choNgoi    -- ChoNgoi - int
	    )
	END
	ELSE 
	BEGIN 
	PRINT N'Chỗ ngồi phải lớn hơn '
	END

GO

EXEC dbo.Insert_Oto_CHk @ma = 'A001',          -- varchar(10)
                        @ten = N'BMW',        -- nvarchar(50)
                        @thuongHieu = N'HonDa', -- nvarchar(50)
                        @dungTich = 3.0,   -- float
                        @choNgoi = 4       -- int

















