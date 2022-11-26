CREATE DATABASE QUANLYNHANSU
GO

USE QUANLYNHANSU
GO

CREATE TABLE PhongBan(
	MaPb VARCHAR(10) PRIMARY KEY,
	TenPb NVARCHAR(50)

)
GO

CREATE TABLE NhanVien(
	MaNv VARCHAR(10) PRIMARY KEY,
	HoTen NVARCHAR(50),
	GioiTinh BIT,
	Luong FLOAT,
	MaPb VARCHAR(10)
)
GO
ALTER TABLE dbo.NhanVien ADD CONSTRAINT fk_pb_nv FOREIGN KEY(MaPb) REFERENCES dbo.PhongBan(MaPb)
GO
CREATE TABLE ChamCong(
	MaCong VARCHAR(10) PRIMARY KEY,
	MaNv VARCHAR(10),
	Thang INT,
	SoNgayLv DATE,
	NgPhep DATE,
	NgKPhep DATE

)
ALTER TABLE dbo.ChamCong ADD CONSTRAINT fk_cc_nv FOREIGN KEY(MaNv) REFERENCES dbo.NhanVien(MaNv)

GO

CREATE PROC Sp_PhongBan(
@MaPb VARCHAR(10),
@TenPb NVARCHAR(50)
)
AS
BEGIN
    IF (@MaPb IS NULL OR @TenPb IS NULL)
	BEGIN
	    PRINT N'Không dược để trống'
	END
	ELSE
	BEGIN
	   INSERT INTO dbo.PhongBan
	(
	    MaPb,
	    TenPb
	)
	VALUES
	(   @MaPb, -- MaPb - varchar(10)
	    @TenPb -- TenPb - nvarchar(50)
	    )
		PRINT N'Thêm thành công'
	END
	
END
GO

EXEC dbo.Sp_PhongBan @MaPb = NULL,  -- varchar(10)
                     @TenPb = N'3' -- nvarchar(50)
GO


CREATE PROC Sp_NhanVien(
	@MaNv VARCHAR(10),
	@HoTen NVARCHAR(50),
	@GioiTinh BIT,
	@Luong MONEY,
	@MaPb VARCHAR(10)
)
AS
BEGIN
    IF @MaPb IS NULL OR @MaNv IS NULL OR @HoTen IS NULL OR @GioiTinh IS NULL OR @Luong IS NULL
	BEGIN
	    PRINT N'Không được để trống'
	END
	ELSE
	BEGIN
	    INSERT INTO dbo.NhanVien
	    (
	        MaNv,
	        HoTen,
	        GioiTinh,
	        Luong,
	        MaPb
	    )
	    VALUES
	    (   @MaNv,   -- MaNv - varchar(10)
	        @HoTen,  -- HoTen - nvarchar(50)
	        @GioiTinh, -- GioiTinh - bit
	        @Luong,  -- Luong - float
	        @MaPb    -- MaPb - varchar(10)
	        )
			PRINT N'Thêm thành công'
	END

END

GO

EXEC dbo.Sp_NhanVien @MaNv = '',       -- varchar(10)
                     @HoTen = N'',     -- nvarchar(50)
                     @GioiTinh = NULL, -- bit
                     @Luong = NULL,    -- money
                     @MaPb = ''        -- varchar(10)

















GO


CREATE PROC Sp_ChamCong(
	@MaCong VARCHAR(10),
	@MaNv VARCHAR(10),
	@Thang INT,
	@SoNgayLv DATE,
	@NgPhep DATE,
	@NgKPhep DATE
)
AS 
BEGIN
    IF @MaNv IS NULL OR  @MaCong IS NULL OR @Thang IS NULL OR @SoNgayLv IS NULL OR @NgPhep IS NULL OR @NgKPhep IS NULL 
	BEGIN
	    PRINT N'Không được để trống'
	END
	ELSE
	BEGIN
	    INSERT INTO dbo.ChamCong
	    (
	        MaCong,
	        MaNv,
	        Thang,
	        SoNgayLv,
	        NgPhep,
	        NgKPhep
	    )
	    VALUES
	    (   @MaCong,        -- MaCong - varchar(10)
	        @MaNv,        -- MaNv - varchar(10)
	        @Thang,         -- Thang - int
	        @SoNgayLv, -- SoNgayLv - date
	        @NgPhep, -- NgPhep - date
	        @NgKPhep  -- NgKPhep - date
	        )
			PRINT N'Thêm thành công'
	END

END

GO

EXEC dbo.Sp_ChamCong @MaCong = '',             -- varchar(10)
                     @MaNv = '',               -- varchar(10)
                     @Thang = 0,               -- int
                     @SoNgayLv = '2022-10-20', -- date
                     @NgPhep = '2022-10-20',   -- date
                     @NgKPhep = '2022-10-20'   -- date

GO

CREATE FUNCTION F_NhanVien(
	@MaNv VARCHAR(10),
	@HoTen NVARCHAR(50),
	@GioiTinh BIT,
	@Luong FLOAT,
	@MaPb VARCHAR(10)
)
RETURNS NVARCHAR(50)
AS
BEGIN
	RETURN (SELECT @MaNv FROM dbo.NhanVien
	WHERE MaNv = @MaNv AND GioiTinh = @GioiTinh AND HoTen = @HoTen AND Luong = @Luong AND MaPb = @MaPb
	)
END
GO

SELECT * FROM dbo.NhanVien
SELECT dbo.F_NhanVien('A01', 'abc', 1, 1, 'Pb01')

GO

---view


CREATE VIEW V_PhongBan_nv
AS
SELECT TOP(3) dbo.PhongBan.MaPb, TenPb , COUNT(dbo.NhanVien.MaNv) AS N'Số Lượng' FROM dbo.PhongBan JOIN dbo.NhanVien ON NhanVien.MaPb = PhongBan.MaPb
GROUP BY PhongBan.MaPb, TenPb
GO

SELECT *FROM dbo.V_PhongBan_nv
GO
SELECT *FROM dbo.ChamCong


