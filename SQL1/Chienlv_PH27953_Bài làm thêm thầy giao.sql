create database baithem3
use baithem3

create table KhachHang(
	MaKhachHang varchar(10) not null,
	TenCongTy nvarchar(50),
	TenGiaoDich nvarchar(50),
	DiaChi nvarchar(50),
	Email varchar(20),
	Sdt int,
	Fax nvarchar(50)
);
alter table KhachHang add constraint pk_MaKhachHang primary key (MaKhachHang)
alter table KhachHang add constraint chk_Sdt check (Sdt>=10)
go

create table NhaCungCap(
	MaCongTy varchar(10) not null,
	TenCongTy nvarchar(50),
	TenGiaoDich nvarchar(50),
	DiaChi nvarchar(50),
	Fax nvarchar(50),
	Email varchar(20)
);
alter table NhaCungCap add constraint pk_MaCongTy primary key (MaCongTy)

go
create table LoaiHang(
	MaLoaiHang varchar(10) not null,
	TenLoaiHang nvarchar(50)
);
alter table LoaiHang add constraint pk_MaLoaiHang primary key(MaLoaiHang)
go

create table MatHang(
	MaHang varchar(10) not null,
	TenHang nvarchar(50),
	MaCongTy varchar(10) not null,
	MaLoaiHang varchar(10) not null,
	SoLuong int,
	DonMinh nvarchar(50),
	GiaHang nvarchar(50)
);
alter table MatHang add constraint pk_MaHang primary key (MaHang)
alter table MatHang add constraint chk_SoLuong check(SoLuong>0)
alter table MatHang add constraint chk_GiaHang check(GiaHang>0)
alter table MatHang add constraint fk_MaCongTy_NhaCungCap foreign key (MaCongTy) references  NhaCungCap(MaCongTy)
alter table MatHang add constraint fk_MaLoaiHang_LoaiHang foreign key (MaLoaiHang) references LoaiHang(MaLoaiHang)
go

create table DonDatHang(
	SoHoaDon varchar(10) not null,
	MaKhachHang varchar(10) not null,
	MaNhanVien varchar(10) not null,
	NgayDatHang date,
	NgayGiaoHang date,
	NgayChuyenHang date,
	NoiGiaoHang nvarchar(50)

);
alter table DonDatHang add constraint pk_SoHoaDon primary key (SoHoaDon)
alter table DonDatHang add constraint fk_MaKhachHang_KhachHang foreign key (MaKhachHang) references KhachHang(MaKhachHang)
alter table DonDatHang add constraint fk_MaNhanVien_NhanVien foreign key (MaNhanVien) references NhanVien(MaNhanVien)
go

create table ChiTietDatHang(
	SoHoaDon varchar(10) not null,
	MaHang varchar(10) not null,
	GiaBan int,
	SoLuong int,
	MucGiamGia int

);
drop table ChiTietDatHang
alter table ChiTietDatHang add constraint pk_SoHD_MaHang primary key(SoHoaDon, MaHang)
alter table ChiTietDatHang add constraint chk_SoLuong_C check (SoLuong > 0)
alter table ChiTietDatHang add constraint chk_GiaBan_C check (GiaBan > 0)
alter table ChiTietDatHang add constraint fk_SoHoaDon_DoDatHang foreign key (SoHoaDon) references DonDatHang(SoHoaDon)
alter table ChiTietDatHang add constraint fk_MaHang_Mathang foreign key (MaHang) references MatHang(MaHang)
go



create table NhanVien(
	MaNhanVien varchar(10) not null,
	Ho nvarchar(20),
	Ten nvarchar(20),
	NgaySinh date,
	NgayLamVien date,
	DiaChi nvarchar(50),
	DienThoai int,
	LuongCoBan int,
	PhuCap nvarchar(50)

);
alter table NhanVien add constraint pk_maNhanVien primary key (MaNhanVien) 
alter table NhanVien add constraint chk_Ngaysinhnv check(NgaySinh <'01/01/2003')
alter table NhanVien add constraint chk_sdtNv check (DienThoai >=10)
alter table NhanVien add constraint chk_Luongcoban check (LuongCoBan >0)
go