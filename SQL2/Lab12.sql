CREATE DATABASE BaiTap_Lab12;
GO
USE BaiTap_Lab12;
GO

CREATE TABLE SinhVien(
	MSSV VARCHAR(7) PRIMARY KEY,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh NVARCHAR(5) NOT NULL,
	DiaChi NVARCHAR(MAX) NULL,
	Quiz1 FLOAT NULL,
	Quiz2 FLOAT NULL,
	Quiz3 FLOAT NULL,
	Quiz4 FLOAT NULL,
	Quiz5 FLOAT NULL,
	Quiz6 FLOAT NULL,
	Quiz7 FLOAT NULL,
	Quiz8 FLOAT NULL,
	Lab1 FLOAT NULL,
	Lab2 FLOAT NULL,
	Lab3 FLOAT NULL,
	Lab4 FLOAT NULL,
	Lab5 FLOAT NULL,
	Lab6 FLOAT NULL,
	Lab7 FLOAT NULL,
	Lab8 FLOAT NULL,
	Assignment1 FLOAT NULL,
	Assignment2 FLOAT NULL,
	Final FLOAT NULL,
	Lop VARCHAR(7) NOT NULL,
	HocKy VARCHAR(4) NOT NULL,
	MonHoc VARCHAR(7) NOT NULL,
	NgaySinh DATE NOT NULL,
	SoDienThoai VARCHAR(15) NULL

)
GO

SELECT * FROM dbo.SinhVien
GO

DELETE dbo.SinhVien
GO

INSERT INTO dbo.SinhVien
(
    MSSV,
    HoTen,
    GioiTinh,
    DiaChi,
    Quiz1,
    Quiz2,
    Quiz3,
    Quiz4,
    Quiz5,
    Quiz6,
    Quiz7,
    Quiz8,
    Lab1,
    Lab2,
    Lab3,
    Lab4,
    Lab5,
    Lab6,
    Lab7,
    Lab8,
    Assignment1,
    Assignment2,
    Final,
    Lop,
    HocKy,
    MonHoc,
    NgaySinh,
    SoDienThoai
)
VALUES
(   'PH00001',        -- MSSV - varchar(7)
    N'Nguyễn Văn An',       -- HoTen - nvarchar(50)
    N'Nam',       -- GioiTinh - nvarchar(5)
    N'HN',       -- DiaChi - nvarchar(max)
    10.0,       -- Quiz1 - float
    8.0,       -- Quiz2 - float
    3.0,       -- Quiz3 - float
    10.0,       -- Quiz4 - float
    5.0,       -- Quiz5 - float
    2.0,       -- Quiz6 - float
    3.0,       -- Quiz7 - float
    3.0,       -- Quiz8 - float
    2.0,       -- Lab1 - float
    3.0,       -- Lab2 - float
    10.0,       -- Lab3 - float
    4.0,       -- Lab4 - float
    5.0,       -- Lab5 - float
    3.0,       -- Lab6 - float
    6.0,       -- Lab7 - float
    9.0,       -- Lab8 - float
    9.0,       -- Assignment1 - float
    0.0,       -- Assignment2 - float
    3.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1998/08/03', -- NgaySinh - date
    '0912345678'         -- SoDienThoai - varchar(15)
    ),
(   'PH00002',        -- MSSV - varchar(7)
    N'Trần Thị Bình',       -- HoTen - nvarchar(50)
    N'Nữ',       -- GioiTinh - nvarchar(5)
    N'HN',       -- DiaChi - nvarchar(max)
    1.0,       -- Quiz1 - float
    5.0,       -- Quiz2 - float
    4.0,       -- Quiz3 - float
    2.0,       -- Quiz4 - float
    3.0,       -- Quiz5 - float
    8.0,       -- Quiz6 - float
    7.0,       -- Quiz7 - float
    1.0,       -- Quiz8 - float
    2.0,       -- Lab1 - float
    3.0,       -- Lab2 - float
    10.0,       -- Lab3 - float
    1.0,       -- Lab4 - float
    4.0,       -- Lab5 - float
    7.0,       -- Lab6 - float
    4.0,       -- Lab7 - float
    10.0,       -- Lab8 - float
    0.0,       -- Assignment1 - float
    2.0,       -- Assignment2 - float
    3.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2035',        -- MonHoc - varchar(7)
    '2000/11/24', -- NgaySinh - date
    '0912345679'         -- SoDienThoai - varchar(15)
    ),
(   'PH00003',        -- MSSV - varchar(7)
    N'Phạm Văn Cường',       -- HoTen - nvarchar(50)
    N'nam',       -- GioiTinh - nvarchar(5)
    NULL,       -- DiaChi - nvarchar(max)
    3.0,       -- Quiz1 - float
    0.0,       -- Quiz2 - float
    10.0,       -- Quiz3 - float
    9.0,       -- Quiz4 - float
    4.0,       -- Quiz5 - float
    2.0,       -- Quiz6 - float
    4.0,       -- Quiz7 - float
    1.0,       -- Quiz8 - float
    5.0,       -- Lab1 - float
    0.0,       -- Lab2 - float
    4.0,       -- Lab3 - float
    10.0,       -- Lab4 - float
    6.0,       -- Lab5 - float
    6.0,       -- Lab6 - float
    7.0,       -- Lab7 - float
    1.0,       -- Lab8 - float
    10.0,       -- Assignment1 - float
    9.0,       -- Assignment2 - float
    9.0,       -- Final - float
    'IT10002',        -- Lop - varchar(7)
    'SU22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1996/10/01', -- NgaySinh - date
    '0812345680'         -- SoDienThoai - varchar(15)
    ),
(   'PH00004',        -- MSSV - varchar(7)
    N'Lý Thị Dương',       -- HoTen - nvarchar(50)
    N'nu',       -- GioiTinh - nvarchar(5)
    N'Hà NỘi',       -- DiaChi - nvarchar(max)
    4.0,       -- Quiz1 - float
    9.0,       -- Quiz2 - float
    0.0,       -- Quiz3 - float
    5.0,       -- Quiz4 - float
    8.0,       -- Quiz5 - float
    2.0,       -- Quiz6 - float
    10.0,       -- Quiz7 - float
    3.0,       -- Quiz8 - float
    5.0,       -- Lab1 - float
    2.0,       -- Lab2 - float
    5.0,       -- Lab3 - float
    9.0,       -- Lab4 - float
    3.0,       -- Lab5 - float
    5.0,       -- Lab6 - float
    3.0,       -- Lab7 - float
    2.0,       -- Lab8 - float
    3.0,       -- Assignment1 - float
    0.0,       -- Assignment2 - float
    10.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1997/11/14', -- NgaySinh - date
    NULL         -- SoDienThoai - varchar(15)
    ),
(   'PH00005',        -- MSSV - varchar(7)
    N'Tào A Đức',       -- HoTen - nvarchar(50)
    N'NAM',       -- GioiTinh - nvarchar(5)
    NULL,       -- DiaChi - nvarchar(max)
    7.0,       -- Quiz1 - float
    9.0,       -- Quiz2 - float
    8.0,       -- Quiz3 - float
    4.0,       -- Quiz4 - float
    7.0,       -- Quiz5 - float
    1.0,       -- Quiz6 - float
    3.0,       -- Quiz7 - float
    5.0,       -- Quiz8 - float
    9.0,       -- Lab1 - float
    9.0,       -- Lab2 - float
    4.0,       -- Lab3 - float
    4.0,       -- Lab4 - float
    8.0,       -- Lab5 - float
    7.0,       -- Lab6 - float
    0.0,       -- Lab7 - float
    0.0,       -- Lab8 - float
    0.0,       -- Assignment1 - float
    5.0,       -- Assignment2 - float
    0.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA21',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '2002/09/08', -- NgaySinh - date
    '0912345682'         -- SoDienThoai - varchar(15)
    ),
(   'PH00006',        -- MSSV - varchar(7)
    N'Giàng Thị Em',       -- HoTen - nvarchar(50)
    N'NU',       -- GioiTinh - nvarchar(5)
    'hà nội',       -- DiaChi - nvarchar(max)
    10.0,       -- Quiz1 - float
    10.0,       -- Quiz2 - float
    3.0,       -- Quiz3 - float
    3.0,       -- Quiz4 - float
    5.0,       -- Quiz5 - float
    1.0,       -- Quiz6 - float
    3.0,       -- Quiz7 - float
    3.0,       -- Quiz8 - float
    5.0,       -- Lab1 - float
    4.0,       -- Lab2 - float
    0.0,       -- Lab3 - float
    10.0,       -- Lab4 - float
    6.0,       -- Lab5 - float
    7.0,       -- Lab6 - float
    1.0,       -- Lab7 - float
    3.0,       -- Lab8 - float
    3.0,       -- Assignment1 - float
    8.0,       -- Assignment2 - float
    1.0,       -- Final - float
    'IT11101',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '2004/02/18', -- NgaySinh - date
    '0812345683'         -- SoDienThoai - varchar(15)
    ),
(   'PH00007',        -- MSSV - varchar(7)
    N'Lê Văn Giang',       -- HoTen - nvarchar(50)
    N'naMM',       -- GioiTinh - nvarchar(5)
    'HN',       -- DiaChi - nvarchar(max)
    2.0,       -- Quiz1 - float
    6.0,       -- Quiz2 - float
    10.0,       -- Quiz3 - float
    5.0,       -- Quiz4 - float
    5.0,       -- Quiz5 - float
    0.0,       -- Quiz6 - float
    7.0,       -- Quiz7 - float
    9.0,       -- Quiz8 - float
    5.0,       -- Lab1 - float
    8.0,       -- Lab2 - float
    6.0,       -- Lab3 - float
    7.0,       -- Lab4 - float
    7.0,       -- Lab5 - float
    8.0,       -- Lab6 - float
    8.0,       -- Lab7 - float
    7.0,       -- Lab8 - float
    0.0,       -- Assignment1 - float
    10.0,       -- Assignment2 - float
    9.0,       -- Final - float
    'IT10002',        -- Lop - varchar(7)
    'SP22',        -- HocKy - varchar(4)
    'COM2040',        -- MonHoc - varchar(7)
    '2003/10/29', -- NgaySinh - date
    '0912345684'         -- SoDienThoai - varchar(15)
    ),
(   'PH00008',        -- MSSV - varchar(7)
    N'Hoàng A Hoàng',       -- HoTen - nvarchar(50)
    N'NỮ',       -- GioiTinh - nvarchar(5)
    NULL,       -- DiaChi - nvarchar(max)
    8.0,       -- Quiz1 - float
    8.0,       -- Quiz2 - float
    8.0,       -- Quiz3 - float
    10.0,       -- Quiz4 - float
    4.0,       -- Quiz5 - float
    3.0,       -- Quiz6 - float
    6.0,       -- Quiz7 - float
    7.0,       -- Quiz8 - float
    10.0,       -- Lab1 - float
    5.0,       -- Lab2 - float
    8.0,       -- Lab3 - float
    6.0,       -- Lab4 - float
    6.0,       -- Lab5 - float
    7.0,       -- Lab6 - float
    10.0,       -- Lab7 - float
    6.0,       -- Lab8 - float
    10.0,       -- Assignment1 - float
    8.0,       -- Assignment2 - float
    3.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'SU22',        -- HocKy - varchar(4)
    'COM2040',        -- MonHoc - varchar(7)
    '2001/07/10', -- NgaySinh - date
    '0312345685'         -- SoDienThoai - varchar(15)
    ),
(   'PH00009',        -- MSSV - varchar(7)
    N'Ngô Thị Lem',       -- HoTen - nvarchar(50)
    N'NỮU',       -- GioiTinh - nvarchar(5)
    'hn',       -- DiaChi - nvarchar(max)
    1.0,       -- Quiz1 - float
    9.0,       -- Quiz2 - float
    8.0,       -- Quiz3 - float
    8.0,       -- Quiz4 - float
    5.0,       -- Quiz5 - float
    6.0,       -- Quiz6 - float
    8.0,       -- Quiz7 - float
    5.0,       -- Quiz8 - float
    8.0,       -- Lab1 - float
    9.0,       -- Lab2 - float
    0.0,       -- Lab3 - float
    2.0,       -- Lab4 - float
    5.0,       -- Lab5 - float
    4.0,       -- Lab6 - float
    9.0,       -- Lab7 - float
    6.0,       -- Lab8 - float
    0.0,       -- Assignment1 - float
    3.0,       -- Assignment2 - float
    4.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1999/10/25', -- NgaySinh - date
    NULL         -- SoDienThoai - varchar(15)
    )



DROP TABLE dbo.SinhVien
GO

--1
INSERT INTO dbo.SinhVien
(
    MSSV,
    HoTen,
    GioiTinh,
    DiaChi,
    Quiz1,
    Quiz2,
    Quiz3,
    Quiz4,
    Quiz5,
    Quiz6,
    Quiz7,
    Quiz8,
    Lab1,
    Lab2,
    Lab3,
    Lab4,
    Lab5,
    Lab6,
    Lab7,
    Lab8,
    Assignment1,
    Assignment2,
    Final,
    Lop,
    HocKy,
    MonHoc,
    NgaySinh,
    SoDienThoai
)
VALUES
(   'PH27953',        -- MSSV - varchar(7)
    N'Lại Văn Chiến',       -- HoTen - nvarchar(50)
    N'Nam',       -- GioiTinh - nvarchar(5)
    N'Bắc Giang',       -- DiaChi - nvarchar(max)
    10.0,       -- Quiz1 - float
    10.0,       -- Quiz2 - float
    6.0,       -- Quiz3 - float
    7.0,       -- Quiz4 - float
    3.0,       -- Quiz5 - float
    8.0,       -- Quiz6 - float
    3.0,       -- Quiz7 - float
    6.0,       -- Quiz8 - float
    9.0,       -- Lab1 - float
    2.0,       -- Lab2 - float
    6.0,       -- Lab3 - float
    3.0,       -- Lab4 - float
    8.0,       -- Lab5 - float
    6.0,       -- Lab6 - float
    7.0,       -- Lab7 - float
    8.0,       -- Lab8 - float
    3.0,       -- Assignment1 - float
    8.0,       -- Assignment2 - float
    3.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1998/08/03', -- NgaySinh - date
    '0912345678'        -- SoDienThoai - varchar(15)
    )
GO
--2
SELECT MSSV, SoDienThoai, Lab1,Lab2, Lab3, Lab4, Lab5, Lab6, Lab7, Lab8 FROM dbo.SinhVien
WHERE MonHoc = 'COM2035'
GO
--3
SELECT MSSV, HoTen, Final FROM dbo.SinhVien
WHERE Final < 5




--4
SELECT HoTen, DiaChi, MonHoc FROM dbo.SinhVien
WHERE SoDienThoai LIKE '08%'
GO

--5
SELECT MSSV, Lop, MonHoc, (Quiz1 + Quiz2+ Quiz3+ Quiz4 + Quiz5 + Quiz6 + Quiz7 + Quiz8)/ 8 AS 'Điểm Quiz Trung Bình' FROM dbo.SinhVien
--6
UPDATE dbo.SinhVien
SET Final = 5
WHERE Lop = 'IT11101'
GO

--7
DELETE dbo.SinhVien
WHERE Assignment1 = 5
GO

--8



ALTER TABLE dbo.SinhVien ADD CONSTRAINT chk_gtt CHECK (GioiTinh  IN (N'Nữ' ,N'Nam'));

--9
SELECT COUNT(MSSV) AS 'Số Lượng Nữ' FROM dbo.SinhVien
WHERE GioiTinh = N'Nữ' AND HocKy='FA22'



--10
SELECT  MSSV, HoTen, ((Quiz1 + Quiz2+ Quiz3+ Quiz4 + Quiz5 + Quiz6 + Quiz7 + Quiz8)/ 8 *0.12) + ((Lab1+Lab2+ Lab3+ Lab4+ Lab5+ Lab6+ Lab7+ Lab8)/8 * 0.28) +((Assignment1+Assignment2)/2*0.2) + Final*0.4 AS 'Điểm Tổng Kết', MonHoc  FROM dbo.SinhVien


SELECT MSSV, HoTen FROM dbo.SinhVien
WHERE SoDienThoai IS NOT NULL

SELECT HoTen, ((Quiz1 + Quiz2+ Quiz3+ Quiz4 + Quiz5 + Quiz6 + Quiz7 + Quiz8)/ 8 *0.12) + ((Lab1+Lab2+ Lab3+ Lab4+ Lab5+ Lab6+ Lab7+ Lab8)/8 * 0.28) +((Assignment1+Assignment2)/2*0.2) + Final*0.4 AS 'Điểm Tổng Kết' FROM dbo.SinhVien
WHERE HocKy = 'FA22'

UPDATE dbo.SinhVien
SET DiaChi = N'HCM'
WHERE Lop = 'IT10002'

SELECT Lop, COUNT(MSSV) FROM dbo.SinhVien
GROUP BY Lop


 
SELECT MSSV, GioiTinh FROM dbo.SinhVien
WHERE YEAR(GETDATE()) - YEAR(NgaySinh) >= 20 AND YEAR(GETDATE()) - YEAR(NgaySinh) < 21

PRINT GETDATE()
PRINT YEAR(GETDATE())
PRINT MONTH(GETDATE())
PRINT DAY(GETDATE())
PRINT TIME(GETDATE())

SELECT GioiTinh, COUNT(GioiTinh) FROM dbo.SinhVien
GROUP BY GioiTinh


CREATE TABLE SINHVIEN_KT2(
MSSV INT NOT NULL,
GioiTinh NVARCHAR(10),
GioiTinhV2 INT,
GioiTinhV3 BIT -- chỉ nhận 1,2

)

DROP TABLE dbo.SINHVIEN_KT2
SELECT *FROM dbo.SINHVIEN_KT2
ALTER TABLE dbo.SINHVIEN_KT2 ADD CONSTRAINT pk_mssv PRIMARY KEY(MSSV)
ALTER TABLE dbo.SINHVIEN_KT2 ADD CONSTRAINT chk_gtt CHECK(GioiTinh IN (N'Nữ', N'Nam')) -- kiểu 1
ALTER TABLE dbo.SINHVIEN_KT2 ADD CONSTRAINT chk_gtv2 CHECK(GioiTinh IN (1,2)) -- kiểu 2


INSERT INTO dbo.SINHVIEN_KT2
(
    MSSV,
    GioiTinh,
    GioiTinhV2,
    GioiTinhV3
)
VALUES
(   4,   -- MSSV - int
    2, -- GioiTinh - nvarchar(10)
    3,   -- GioiTinhV2 - int
    1 -- GioiTinhV3 - bit
    )


