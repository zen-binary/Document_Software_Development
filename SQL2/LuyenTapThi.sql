CREATE DATABASE DANGKYHOC
GO

USE DANGKYHOC
GO

/* Câu 1 (1.5 điểm): Tạo cơ sở dữ liệu DANGKYHOC gồm 3 bảng.
SINHVIEN (MaSV, Ten,GioiTinh,NgaySinh,DiaChi)
MONHOC (MaMH, TenMH, NganhHoc)
DANGKY (MaSV, MaMH, NgayDK, HocKy) */

CREATE TABLE SINHVIEN(
	MaSV VARCHAR(10) PRIMARY KEY,
	Ten NVARCHAR(50),
	GioiTinh BIT,
	NgaySinh DATE,
	DiaChi NVARCHAR(50)
)
GO

CREATE TABLE MONHOC(
	MaMH VARCHAR(10) PRIMARY KEY,
	TenMH NVARCHAR(50),
	NganhHoc NVARCHAR(50)
)
GO

CREATE TABLE DANGKY(
	MaSV VARCHAR(10),
	MaMH VARCHAR(10),
	NgayDK DATE,
	HocKy INT
	PRIMARY KEY(MaSV,MaMH)
)
GO

ALTER TABLE dbo.DANGKY ADD CONSTRAINT fk_DangKy_SinhVien FOREIGN KEY(MaSV) REFERENCES dbo.SINHVIEN(MaSV)
ALTER TABLE dbo.DANGKY ADD CONSTRAINT fk_DangKy_MonHoc FOREIGN KEY(MaMH) REFERENCES dbo.MONHOC(MaMH)
GO

/* Câu 2 (3 điểm): Chèn thông tin vào các bảng
Tạo Stored Procedure (SP) với các tham số đầu vào phù hợp.
SP thứ nhất thực hiện chèn dữ liệu vào bảng SINHVIEN.
SP thứ hai thực hiện chèn dữ liệu vào bảng MONHOC.
SP thứ ba thực hiện chèn dữ liệu vào bảng DANGKY.
Yêu cầu mỗi SP phải kiểm tra tham số đầu vào. Với các cột không chấp nhận thuộc tính Null.
Với mỗi SP viết 3 lời gọi thành công. */

CREATE PROC SP_SinhVien(
	@MaSV VARCHAR(10),
	@Ten NVARCHAR(50),
	@GioiTinh BIT,
	@NgaySinh DATE,
	@DiaChi NVARCHAR(50)
)
AS
BEGIN
    IF @MaSV IS NULL OR @Ten IS NULL OR @GioiTinh IS NULL OR @NgaySinh IS NULL OR @DiaChi IS NULL
	BEGIN
	    PRINT N'Không được để trống'
	END
	ELSE
	BEGIN
	    INSERT INTO dbo.SINHVIEN
	    (
	        MaSV,
	        Ten,
	        GioiTinh,
	        NgaySinh,
	        DiaChi
	    )
	    VALUES
	    (   @MaSV,        -- MaSV - varchar(10)
	        @Ten,       -- Ten - nvarchar(50)
			@GioiTinh,      -- GioiTinh - bit
	        @NgaySinh, -- NgaySinh - date
	        @DiaChi        -- DiaChi - nvarchar(50)
	        )
	END
END
GO
EXEC dbo.SP_SinhVien @MaSV = 'SV01',               -- varchar(10)
                     @Ten = N'Lại Văn A',               -- nvarchar(50)
                     @GioiTinh = 1,         -- bit
                     @NgaySinh = '2000-10-10', -- date
                     @DiaChi = N'Hà nội'             -- nvarchar(50)

EXEC dbo.SP_SinhVien @MaSV = 'SV02',               -- varchar(10)
                     @Ten = N'Lại Văn B',               -- nvarchar(50)
                     @GioiTinh = 1,         -- bit
                     @NgaySinh = '2000-10-10', -- date
                     @DiaChi = N'Hà nội'             -- nvarchar(50)

EXEC dbo.SP_SinhVien @MaSV = 'SV03',               -- varchar(10)
                     @Ten = N'Lại Văn C',               -- nvarchar(50)
                     @GioiTinh = 1,         -- bit
                     @NgaySinh = '2000-10-10', -- date
                     @DiaChi = N'Hà nội'             -- nvarchar(50)
GO

CREATE PROC SP_MONHOC(
	@MaMH VARCHAR(10),
	@TenMH NVARCHAR(50),
	@NganhHoc NVARCHAR(50)
)
AS
BEGIN
    IF @MaMH IS NULL OR @TenMH IS NULL OR @NganhHoc IS NULL
	BEGIN
	    PRINT N'Không được để trống'
	END
	ELSE
	BEGIN
	    INSERT INTO dbo.MONHOC
	    (
	        MaMH,
	        TenMH,
	        NganhHoc
	    )
	    VALUES
	    (   @MaMH,  -- MaMH - varchar(10)
	        @TenMH, -- TenMH - nvarchar(50)
	        @NganhHoc  -- NganhHoc - nvarchar(50)
	        )
			PRINT N'Thêm thành công'
	END

END
GO

EXEC dbo.SP_MONHOC @MaMH = 'MN01',     -- varchar(10)
                   @TenMH = N'Com2034',   -- nvarchar(50)
                   @NganhHoc = N'Web' -- nvarchar(50)

EXEC dbo.SP_MONHOC @MaMH = 'MN02',     -- varchar(10)
                   @TenMH = N'Com2034',   -- nvarchar(50)
                   @NganhHoc = N'Web' -- nvarchar(50)

EXEC dbo.SP_MONHOC @MaMH = 'MN03',     -- varchar(10)
                   @TenMH = N'Com2034',   -- nvarchar(50)
                   @NganhHoc = N'Web' -- nvarchar(50)

GO


CREATE PROC SP_DANGKY(
	@MaSV VARCHAR(10),
	@MaMH VARCHAR(10),
	@NgayDK DATE,
	@HocKy INT

)
AS
BEGIN
	IF @MaMH IS NULL OR @MaSV IS NULL OR @NgayDK IS NULL OR @HocKy IS NULL
	BEGIN
	    PRINT N'Không được để trống'
	END
	ELSE
	BEGIN
	    INSERT INTO dbo.DANGKY
	    (
	        MaSV,
	        MaMH,
	        NgayDK,
	        HocKy
	    )
	    VALUES
	    (   @MaSV,        -- MaSV - varchar(10)
	        @MaMH,        -- MaMH - varchar(10)
	        @NgayDK, -- NgayDK - date
	        @HocKy          -- HocKy - int
	        )
	END


END
GO

EXEC dbo.SP_DANGKY @MaSV = 'SV01',             -- varchar(10)
                   @MaMH = 'MN01',             -- varchar(10)
                   @NgayDK = '1999-10-20', -- date
                   @HocKy = 5              -- int

EXEC dbo.SP_DANGKY @MaSV = 'SV02',             -- varchar(10)
                   @MaMH = 'MN03',             -- varchar(10)
                   @NgayDK = '2000-10-20', -- date
                   @HocKy = 5 

EXEC dbo.SP_DANGKY @MaSV = 'SV03',             -- varchar(10)
                   @MaMH = 'MN02',             -- varchar(10)
                   @NgayDK = '2020-02-01', -- date
                   @HocKy = 5 
GO


/* Câu 3 (2 điểm): Viết Hàm
Viết hàm các tham số đầu vào tương ứng với các cột của bảng SinhVien . Hàm này trả về MaSV thỏa mãn các giá trị được truyền tham số. */

CREATE FUNCTION F_SinhVien(
	@MaSV VARCHAR(10),
	@Ten NVARCHAR(50),
	@GioiTinh BIT,
	@NgaySinh DATE,
	@DiaChi NVARCHAR(50)
)
RETURNS NVARCHAR(50)
AS
BEGIN
    RETURN (SELECT MaSV FROM dbo.SINHVIEN WHERE MaSV = @MaSV)
END

GO

PRINT dbo.F_SinhVien('SV02', N'Lại Văn B' , 1 , '2000-10-10', N'Hà nội')
GO
/* Câu 4 (1.5 điểm): Tạo View 
Tạo View lưu thông tin của  ngày đăng ký gần nhất, gồm các thông tin sau: MaSV, TenSV,Tuổi, DiaChi, MaMH, TenMH, NgayDK, HocKy và sắp xếp giảm dần theo ngày đăng ký */

CREATE VIEW V_ThongTinDk
AS
SELECT TOP(100) DANGKY.MaSV, Ten,YEAR(GETDATE()) - YEAR(NgaySinh) AS 'Tuổi', DiaChi , MONHOC.MaMH , TenMH, NgayDK , HocKy  FROM dbo.SINHVIEN JOIN dbo.DANGKY ON DANGKY.MaSV = SINHVIEN.MaSV JOIN dbo.MONHOC ON MONHOC.MaMH = DANGKY.MaMH
ORDER BY NgayDK DESC
GO

SELECT *FROM dbo.V_ThongTinDk

/* Câu 5 (2 điểm): Viết thủ tục
Viết một SP nhận một tham số đầu vào là NgayDK. SP này thực hiện thao tác xóa thông tin sinh viên và môn học tương ứng.
Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác xóa thực hiện không thành công.
Lưu ý! Tên CSDL: CSDL_Tên Sinh Viên_MSSV. Xóa hết các CSDL trên máy. Ngắt internet, không trao đổi. Giám thị nhắc lần 1 trừ 2 điểm, lần 2 trừ 5 điểm, lần 3 hủy bài thi. */


SELECT *FROM dbo.SINHVIEN
SELECT *FROM dbo.MONHOC 
SELECT *FROM dbo.DANGKY

GO

CREATE TRIGGER Delete_XoaThongTin ON dbo.DANGKY
FOR DELETE
AS
BEGIN
    DELETE dbo.SINHVIEN WHERE MaSV IN (SELECT Deleted.MaSV FROM Deleted)
	DELETE dbo.MONHOC WHERE MaMH IN (SELECT Deleted.MaMH FROM Deleted)
END

GO


CREATE PROC SP_XoaThongTin(
	@NgayDK DATE
	)
AS
BEGIN
    DELETE dbo.DANGKY WHERE NgayDK = @NgayDK
END

EXEC dbo.SP_XoaThongTin @NgayDK = '2000-10-20' -- date

GO

--C2
CREATE PROC SP_XoaThongTinV2(
	@NgayDK DATE
	)
AS
BEGIN
	DELETE dbo.DANGKY WHERE NGAYDK = @NgayDK
    DELETE dbo.SINHVIEN WHERE MASV IN (SELECT MASV FROM dbo.DANGKY WHERE NGAYDK = @NgayDK)
    DELETE dbo.MONHOC WHERE MAMH IN (SELECT MAMH FROM dbo.DANGKY WHERE NGAYDK = @NGAYDK)
	
END

EXEC dbo.SP_XoaThongTinV2 @NgayDK = '2020-02-01' -- date

