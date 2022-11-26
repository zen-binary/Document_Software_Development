create database com2012
use com2012


create table Phong_Ban(
	Ma_Pb varchar(10) not null,
	Ten_Pb nvarchar(50),
	Ma_TruongPhong nvarchar(50)
);
alter table Phong_Ban add constraint pk_maPb primary key (Ma_Pb)

go

create table Nhan_Vien(
	ID_NhanVien varchar(10) not null,
	Ho_Nv nvarchar(50),
	Ten_Nv nvarchar(50),
	Nam_Sinh date,
	Dia_Chi nvarchar(50),
	Gioi_Tinh nvarchar(10),
	Luong float,
	PHG varchar(10)

);

alter table Nhan_Vien add constraint pk_Nhanvien primary key (ID_NhanVien)
alter table Nhan_Vien add constraint pk_PhongBan_NhanVien foreign key(PHG) references Phong_Ban(Ma_Pb)

go

create table QuanLy_DuAn(
	Ma_DuAn varchar(10) not null,
	Ma_NhanVien varchar(10) not null,
	Ngay_Tham_Gia date,
	Ngay_Ket_Thuc date,
	So_Gio int,
	Vai_Tro nvarchar(50)
	
); 
alter table QuanLy_DuAn add constraint pk_QlyDuAn primary key(Ma_DuAn,Ma_NhanVien)
alter table QuanLy_DuAn add constraint pk_Nhavien_DuAn foreign key(Ma_NhanVien) references Nhan_Vien(ID_NhanVien)
alter table QuanLy_DuAn add constraint pk_DuAn_QDuAn foreign key (Ma_DuAn) references Du_An(Ma_DuAn)

go

create table Du_An(
	Ma_DuAn varchar(10) not null,
	Ten_DuAn Nvarchar(50),
	Ngay_BatDau date,
	Ngay_KetThuc date
);
alter table Du_An add constraint pk_SDuAn primary key(Ma_DuAn)


go