CREATE DATABASE Lab34_COM2034
GO
USE Lab34_COM2034
GO


CREATE TABLE SinhVien(
	MSSV VARCHAR(7) PRIMARY KEY NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh INT NOT NULL,
	DiaChi NVARCHAR(10) NULL,
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
    1,         -- GioiTinh - int
    N'HN',       -- DiaChi - nvarchar(10)
    1.0,       -- Quiz1 - float
    4.0,       -- Quiz2 - float
    7.0,       -- Quiz3 - float
    8.0,       -- Quiz4 - float
    9.0,       -- Quiz5 - float
    9.0,       -- Quiz6 - float
    2.0,       -- Quiz7 - float
    1.0,       -- Quiz8 - float
    9.0,       -- Lab1 - float
    6.0,       -- Lab2 - float
    6.0,       -- Lab3 - float
    4.0,       -- Lab4 - float
    9.0,       -- Lab5 - float
    8.0,       -- Lab6 - float
    1.0,       -- Lab7 - float
    4.0,       -- Lab8 - float
    3.0,       -- Assignment1 - float
    7.0,       -- Assignment2 - float
    9.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1999/05/08', -- NgaySinh - date
    '0912345678'         -- SoDienThoai - varchar(15)
    ),

(   'PH00002',        -- MSSV - varchar(7)
    N'Trần Thị Bình',       -- HoTen - nvarchar(50)
    0,         -- GioiTinh - int
    N'HN',       -- DiaChi - nvarchar(10)
    9.0,       -- Quiz1 - float
    3.0,       -- Quiz2 - float
    1.0,       -- Quiz3 - float
    6.0,       -- Quiz4 - float
    10.0,       -- Quiz5 - float
    1.0,       -- Quiz6 - float
    3.0,       -- Quiz7 - float
    5.0,       -- Quiz8 - float
    5.0,       -- Lab1 - float
    6.0,       -- Lab2 - float
    8.0,       -- Lab3 - float
    1.0,       -- Lab4 - float
    4.0,       -- Lab5 - float
    5.0,       -- Lab6 - float
    8.0,       -- Lab7 - float
    8.0,       -- Lab8 - float
    8.0,       -- Assignment1 - float
    7.0,       -- Assignment2 - float
    4.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2035',        -- MonHoc - varchar(7)
    '1995/10/08', -- NgaySinh - date
    '0912345679'         -- SoDienThoai - varchar(15)
    ),

(   'PH00003',        -- MSSV - varchar(7)
    N'Phạm Văn Cường',       -- HoTen - nvarchar(50)
    1,         -- GioiTinh - int
    NULL,       -- DiaChi - nvarchar(10)
    4.0,       -- Quiz1 - float
    8.0,       -- Quiz2 - float
    3.0,       -- Quiz3 - float
    3.0,       -- Quiz4 - float
    9.0,       -- Quiz5 - float
    7.0,       -- Quiz6 - float
    1.0,       -- Quiz7 - float
    6.0,       -- Quiz8 - float
    5.0,       -- Lab1 - float
    10.0,       -- Lab2 - float
    7.0,       -- Lab3 - float
    6.0,       -- Lab4 - float
    7.0,       -- Lab5 - float
    6.0,       -- Lab6 - float
    7.0,       -- Lab7 - float
    8.0,       -- Lab8 - float
    6.0,       -- Assignment1 - float
    6.0,       -- Assignment2 - float
    6.0,       -- Final - float
    'IT10002',        -- Lop - varchar(7)
    'SU22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '2001/12/26', -- NgaySinh - date
	 NULL         -- SoDienThoai - varchar(15)
    ),

(   'PH00004',        -- MSSV - varchar(7)
    N'Lý Thị Dương',       -- HoTen - nvarchar(50)
    0,         -- GioiTinh - int
    'Hà NỘi',       -- DiaChi - nvarchar(10)
    2.0,       -- Quiz1 - float
    2.0,       -- Quiz2 - float
    3.0,       -- Quiz3 - float
    5.0,       -- Quiz4 - float
    9.0,       -- Quiz5 - float
    5.0,       -- Quiz6 - float
    10.0,       -- Quiz7 - float
    7.0,       -- Quiz8 - float
    4.0,       -- Lab1 - float
    2.0,       -- Lab2 - float
    1.0,       -- Lab3 - float
    4.0,       -- Lab4 - float
    9.0,       -- Lab5 - float
    10.0,       -- Lab6 - float
    9.0,       -- Lab7 - float
    1.0,       -- Lab8 - float
    6.0,       -- Assignment1 - float
    2.0,       -- Assignment2 - float
    2.0,       -- Final - float
    'IT10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1996/09/20', -- NgaySinh - date
	'0812345680'         -- SoDienThoai - varchar(15)
    ),

(   'PH00005',        -- MSSV - varchar(7)
    N'Tào A Đức',       -- HoTen - nvarchar(50)
    1,         -- GioiTinh - int
    NULL,       -- DiaChi - nvarchar(10)
    1.0,       -- Quiz1 - float
    8.0,       -- Quiz2 - float
    8.0,       -- Quiz3 - float
    9.0,       -- Quiz4 - float
    8.0,       -- Quiz5 - float
    1.0,       -- Quiz6 - float
    10.0,       -- Quiz7 - float
    3.0,       -- Quiz8 - float
    9.0,       -- Lab1 - float
    1.0,       -- Lab2 - float
    8.0,       -- Lab3 - float
    6.0,       -- Lab4 - float
    5.0,       -- Lab5 - float
    6.0,       -- Lab6 - float
    7.0,       -- Lab7 - float
    8.0,       -- Lab8 - float
    1.0,       -- Assignment1 - float
    3.0,       -- Assignment2 - float
    7.0,       -- Final - float
    'WE10001',        -- Lop - varchar(7)
    'FA21',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1995/06/15', -- NgaySinh - date
	NULL         -- SoDienThoai - varchar(15)
    ),

(   'PH00006',        -- MSSV - varchar(7)
    N'Giàng Thị Em',       -- HoTen - nvarchar(50)
    0,         -- GioiTinh - int
    'hà nội',       -- DiaChi - nvarchar(10)
    4.0,       -- Quiz1 - float
    10.0,       -- Quiz2 - float
    9.0,       -- Quiz3 - float
    9.0,       -- Quiz4 - float
    7.0,       -- Quiz5 - float
    1.0,       -- Quiz6 - float
    2.0,       -- Quiz7 - float
    5.0,       -- Quiz8 - float
    3.0,       -- Lab1 - float
    2.0,       -- Lab2 - float
    3.0,       -- Lab3 - float
    9.0,       -- Lab4 - float
    6.0,       -- Lab5 - float
    6.0,       -- Lab6 - float
    1.0,       -- Lab7 - float
    2.0,       -- Lab8 - float
    1.0,       -- Assignment1 - float
    2.0,       -- Assignment2 - float
    6.0,       -- Final - float
    'IT11101',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '2002/04/25', -- NgaySinh - date
	'0912345682'         -- SoDienThoai - varchar(15)
    ),

(   'PH00007',        -- MSSV - varchar(7)
    N'Lê Văn Giang',       -- HoTen - nvarchar(50)
    1,         -- GioiTinh - int
    'HN',       -- DiaChi - nvarchar(10)
    8.0,       -- Quiz1 - float
    4.0,       -- Quiz2 - float
    3.0,       -- Quiz3 - float
    7.0,       -- Quiz4 - float
    4.0,       -- Quiz5 - float
    7.0,       -- Quiz6 - float
    1.0,       -- Quiz7 - float
    10.0,       -- Quiz8 - float
    8.0,       -- Lab1 - float
    5.0,       -- Lab2 - float
    5.0,       -- Lab3 - float
    5.0,       -- Lab4 - float
    3.0,       -- Lab5 - float
    4.0,       -- Lab6 - float
    2.0,       -- Lab7 - float
    9.0,       -- Lab8 - float
    5.0,       -- Assignment1 - float
    8.0,       -- Assignment2 - float
    2.0,       -- Final - float
    'IT10002',        -- Lop - varchar(7)
    'SP22',        -- HocKy - varchar(4)
    'COM2040',        -- MonHoc - varchar(7)
    '1995/04/22', -- NgaySinh - date
	'0812345683'         -- SoDienThoai - varchar(15)
    ),

(   'PH00008',        -- MSSV - varchar(7)
    N'Hoàng A Hoàng',       -- HoTen - nvarchar(50)
    0,         -- GioiTinh - int
    NULL,       -- DiaChi - nvarchar(10)
    7.0,       -- Quiz1 - float
    9.0,       -- Quiz2 - float
    6.0,       -- Quiz3 - float
    2.0,       -- Quiz4 - float
    2.0,       -- Quiz5 - float
    10.0,       -- Quiz6 - float
    9.0,       -- Quiz7 - float
    7.0,       -- Quiz8 - float
    9.0,       -- Lab1 - float
    4.0,       -- Lab2 - float
    8.0,       -- Lab3 - float
    9.0,       -- Lab4 - float
    3.0,       -- Lab5 - float
    7.0,       -- Lab6 - float
    7.0,       -- Lab7 - float
    4.0,       -- Lab8 - float
    1.0,       -- Assignment1 - float
    2.0,       -- Assignment2 - float
    7.0,       -- Final - float
    'WE10001',        -- Lop - varchar(7)
    'SU22',        -- HocKy - varchar(4)
    'COM2040',        -- MonHoc - varchar(7)
    '2001/12/07', -- NgaySinh - date
	'0912345684'         -- SoDienThoai - varchar(15)
    ),

(   'PH00009',        -- MSSV - varchar(7)
    N'Ngô Thị Lem',       -- HoTen - nvarchar(50)
    0,         -- GioiTinh - int
    'hn',       -- DiaChi - nvarchar(10)
    10.0,       -- Quiz1 - float
    6.0,       -- Quiz2 - float
    5.0,       -- Quiz3 - float
    4.0,       -- Quiz4 - float
    8.0,       -- Quiz5 - float
    2.0,       -- Quiz6 - float
    7.0,       -- Quiz7 - float
    10.0,       -- Quiz8 - float
    6.0,       -- Lab1 - float
    6.0,       -- Lab2 - float
    4.0,       -- Lab3 - float
    1.0,       -- Lab4 - float
    3.0,       -- Lab5 - float
    3.0,       -- Lab6 - float
    9.0,       -- Lab7 - float
    2.0,       -- Lab8 - float
    10.0,       -- Assignment1 - float
    4.0,       -- Assignment2 - float
    2.0,       -- Final - float
    'WE10001',        -- Lop - varchar(7)
    'FA22',        -- HocKy - varchar(4)
    'COM2034',        -- MonHoc - varchar(7)
    '1998/12/14', -- NgaySinh - date
	'0312345685'         -- SoDienThoai - varchar(15)
    )
GO
--2
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai ,CEILING(((Quiz1+Quiz2+Quiz3+Quiz4+Quiz5+Quiz6 + Quiz7 + Quiz8)/8))  AS N'Điểm TB Quiz' FROM dbo.SinhVien
 GO

--3
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai ,FLOOR(((Lab1+Lab2+ Lab3+ Lab4+ Lab5+ Lab6+ Lab7+ Lab8)/8))  AS N'Điểm TB Lab' FROM dbo.SinhVien
 GO


--4
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai ,ROUND(((Assignment1+Assignment2)/2),2)   AS N'Điểm TB ASM' FROM dbo.SinhVien
GO

--5
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai , YEAR(GETDATE()) - YEAR(NgaySinh) AS N'Tuổi' FROM dbo.SinhVien
GO

--6
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai, MONTH(NgaySinh) AS 'Tháng Sinh'  FROM dbo.SinhVien
WHERE MONTH(NgaySinh)%2 = 0
GO


--7
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai, MONTH(NgaySinh) AS 'Tháng Sinh'  FROM dbo.SinhVien
WHERE  MONTH(NgaySinh) = 4 OR  MONTH(NgaySinh) = 6 OR MONTH(NgaySinh) = 9 OR MONTH(NgaySinh) = 11 


SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai, MONTH(NgaySinh) AS 'Tháng Sinh'  FROM dbo.SinhVien
WHERE  MONTH(NgaySinh) IN (4,6,9,11)


--8
SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai FROM dbo.SinhVien
WHERE Lop LIKE 'IT%'

SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai FROM dbo.SinhVien
WHERE LEFT(Lop,2) ='IT'

SELECT MSSV, HoTen, GioiTinh,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai FROM dbo.SinhVien
WHERE Lop NOT LIKE 'WE%'

--9
SELECT HoTen, 
SUBSTRING(HoTen,0,CHARINDEX(' ', HoTen , 0)) AS N'Họ' ,
SUBSTRING(HoTen,CHARINDEX(' ', HoTen)+1  , LEN(HoTen) -  CHARINDEX(' ', HoTen) - CHARINDEX(' ',  REVERSE (HoTen) , 0) ) AS N'Tên Đệm',
REVERSE (SUBSTRING(REVERSE (HoTen),0,CHARINDEX(' ',  REVERSE (HoTen) , 0))) AS N'Tên' 
FROM dbo.SinhVien



DECLARE @hoTen NVARCHAR(50);
SET @hoTen = 'Trần Văn A'
--lấy họ
PRINT SUBSTRING(@hoTen,1, ch)







--Văn
-- Văn
--SELECT LEN('123 56 89')
--SELECT CHARINDEX(' ',  REVERSE ('123 56 89') , 0)
--SELECT CHARINDEX(' ', '123 56 89')
--SELECT  SUBSTRING('123 56 89',CHARINDEX(' ', '123 56 89') , LEN('123 56 89')+1  -  CHARINDEX(' ', '123 56 89') - CHARINDEX(' ',  REVERSE ('123 56 89') , 0) ) AS N'Tên Đệm'

--10
SELECT MSSV, HoTen, CASE GioiTinh WHEN 0 THEN N'Nam' WHEN 1 THEN N'Nữ' END AS N'Giới Tính'  ,NgaySinh, DiaChi,Lop , HocKy , MonHoc, SoDienThoai FROM dbo.SinhVien





SELECT * FROM dbo.SinhVien


--2
SELECT MSSV, HoTen, GioiTinh, DiaChi , Lop, HocKy, MonHoc, NgaySinh, SoDienThoai, ROUND((Quiz1+Quiz2+Quiz3+Quiz4+Quiz5+Quiz6 +Quiz7+ Quiz8)/8, 1) AS 'Điểm TB Quiz' FROM dbo.SinhVien

--3
SELECT MSSV, YEAR(GETDATE()) - YEAR(NgaySinh) AS N'Tuổi', HoTen FROM dbo.SinhVien
WHERE YEAR(GETDATE()) - YEAR(NgaySinh) < 22 AND YEAR(GETDATE()) - YEAR(NgaySinh) > 19

--4
SELECT MSSV, HoTen, GioiTinh, DiaChi , Lop, HocKy, MonHoc, NgaySinh, SoDienThoai, YEAR(NgaySinh) AS N'Năm sinh'  FROM dbo.SinhVien
WHERE YEAR(NgaySinh)%2 !=0


--5
SELECT MSSV, HoTen, GioiTinh, DiaChi , Lop, HocKy, MonHoc, NgaySinh, SoDienThoai, MONTH(NgaySinh) AS 'Tháng Sinh' FROM dbo.SinhVien
WHERE  MONTH(NgaySinh) = 1 OR  MONTH(NgaySinh) = 3 OR  MONTH(NgaySinh) = 5 OR  MONTH(NgaySinh) = 7 OR  MONTH(NgaySinh) = 8 OR  MONTH(NgaySinh) = 10 OR  MONTH(NgaySinh)  = 12 

--6
SELECT MSSV, HoTen, CASE GioiTinh WHEN 1 THEN N'Boy' WHEN '0' THEN N'Girl' END  AS N'Giới Tính', DiaChi , Lop, HocKy, MonHoc, NgaySinh, SoDienThoai FROM dbo.SinhVien

--7
DELETE dbo.Lop
DELETE dbo.Lop
CREATE TABLE Lop(
	Lop VARCHAR(7) NOT NULL PRIMARY KEY,
	GiangVien VARCHAR(10) NULL
)


DELETE dbo.SinhVien

ALTER TABLE dbo.SinhVien  ADD CONSTRAINT fk_lopwee FOREIGN KEY(Lop) REFERENCES dbo.Lop(Lop)
GO
 
INSERT INTO dbo.Lop
(
    Lop,
    GiangVien
)
VALUES
(   'IT10001', -- Lop - varchar(7)
    'phongtt35'  -- GiangVien - varchar(10)
    ),
(   'IT10002', -- Lop - varchar(7)
    'minhdq8'  -- GiangVien - varchar(10)
    ),
(   'WE10001', -- Lop - varchar(7)
    'nguyenvv4'  -- GiangVien - varchar(10)
    ),
(   'IT11101', -- Lop - varchar(7)
    'hangnt169'  -- GiangVien - varchar(10)
    )
GO

SELECT  Lop.Lop, GiangVien, COUNT(MSSV) AS 'Số Lượng'
FROM dbo.SinhVien JOIN dbo.Lop 
ON  SinhVien.Lop =Lop.Lop 
GROUP BY dbo.Lop.GiangVien, Lop.Lop 
HAVING Lop.Lop   NOT LIKE 'IT%'


--8
SELECT LOWER(HoTen) AS 'Họ Và Tên'  , 
UPPER(SUBSTRING(HoTen, 0 , CHARINDEX(' ' , HoTen)))  AS 'Họ',
UPPER(SUBSTRING( HoTen ,CHARINDEX(' ' , HoTen) +1, LEN(HoTen) - CHARINDEX(' ' , HoTen) - CHARINDEX(' ' , REVERSE(HoTen)) )) AS 'Tên Đệm',
UPPER(REVERSE(SUBSTRING(REVERSE(HoTen), 0, CHARINDEX(' ',REVERSE(HoTen))))) AS 'Tên'
FROM dbo.SinhVien


--9
SELECT DAY(NgaySinh) AS 'Ngày Sinh', MONTH(NgaySinh) AS N'Tháng',  DATENAME(WEEKDAY, NgaySinh) AS 'Thứ Trong Tuần', 
CASE DATEPART(WEEKDAY, NgaySinh)
WHEN 1 THEN N'Chủ Nhật'
WHEN 2 THEN N'Thứ Hai'
WHEN 3 THEN N'Thứ Ba'
WHEN 4 THEN N'Thứ Tư'
WHEN 5 THEN N'Thứ Năm'
WHEN 6 THEN N'Thứ Sáu'
WHEN 7 THEN N'Thứ Bảy'
END AS 'Thứ Trong Tuần V2'FROM dbo.SinhVien

SELECT DATENAME(year, '12:10:30.123')  
    ,DATENAME(month, '12:10:30.123')  
    ,DATENAME(day, '12:10:30.123')  
    ,DATENAME(dayofyear, '12:10:30.123')  
    ,DATENAME(weekday, '12:10:30.123'); 

