CREATE
DATABASE ServletBeta

USE ServletBeta

GO

CREATE TABLE ChucVu
(
    Id  INT PRIMARY KEY IDENTITY(1,1),
    Ma  VARCHAR(20) UNIQUE,
    Ten NVARCHAR(50)
)
DROP TABLE NguoiDung

CREATE TABLE NguoiDung
(
    Id       INT PRIMARY KEY IDENTITY(1,1),
    IdCV     INT,
    Ma       VARCHAR(20) UNIQUE,
    Ten      NVARCHAR( MAX),
    GioiTinh INT,
    NgaySinh DATE,
    DiaChi   NVARCHAR( MAX),
    ThanhPho NVARCHAR( MAX),
    QuocGia  NVARCHAR( MAX),
    MatKhau  VARCHAR(100)
)

ALTER TABLE dbo.NguoiDung
    ADD CONSTRAINT fk_ND_CV FOREIGN KEY (IdCV) REFERENCES dbo.ChucVu (Id)