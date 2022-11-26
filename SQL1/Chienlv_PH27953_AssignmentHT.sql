create database Quanlysach2
use Quanlysach2

create table SinhVien(
	MaSv varchar(10) not null,
	HoTen nvarchar(20),
	GioiTinh nvarchar(10),
	NgaySinh date,
	DiaChi nvarchar(50),
	Email varchar(10),
	Sdt int,
	NgayHetHan date,
	MaLop varchar(10) not null
);
alter table SinhVien add constraint pk_masv primary key (MaSv)
alter table SinhVien add constraint fk_sv_lop foreign key (MaLop) references Lop(MaLop)
alter table SinhVien drop column Email
alter table SinhVien add Email varchar(20) 
go
create table NganhHoc(
	MaNganh varchar(10) not null,
	TenNganh nvarchar(20)

);

alter table NganhHoc add constraint pk_MaNganh primary key (MaNganh)
go

create table Lop(
	MaLop varchar(10) not null,
	TenLop nvarchar(20),
	MaNganh varchar(10) not null
);
alter table Lop add constraint pk_MaLop primary key (MaLop)
alter table Lop add constraint fk_lop_nganh foreign key (MaNganh) references NganhHoc(MaNganh)
go

create table Sach(
	MaSach varchar(10) not null,
	TenSach nvarchar(20),
	SoTrang int,
	SlBanSao int,
	GiaBia varchar(20),
	NgayNk date,
	NgayXb date,
	ViTri nvarchar(20),
	GhiChu nvarchar(20),
	MaTl varchar(10) not null,


);
 
alter table Sach add constraint pk_MaSach primary key (MaSach)
alter table Sach add constraint fk_Sach_tl foreign key (MaTl) references TheLoai(MaTl)
alter table Sach drop column GiaBia
alter table Sach add GiaBia int
alter table Sach add constraint chk_giobia check (GiaBia >1)
alter table Sach add constraint chk_trang check (SoTrang >10)

go

create table PhieuMuon(
	SoPhieu int not null,
	NgayMuon date,
	NgayTra date,
	TrangThai nvarchar(20),
	MaSv varchar(10) not null

);
alter table PhieuMuon add constraint pk_SoPhieu primary key (SoPhieu)
alter table PhieuMuon add constraint fk_phieu_sv foreign key (MaSv) references SinhVien(MaSv)
alter table PhieuMuon add constraint chk_ngay check (NgayMuon <= NgayTra)
go

create table TacGia(
	MaTg varchar(10) not null,
	HoTen nvarchar(20),
	ButDanh nvarchar(20),
	DiaChi nvarchar(50),
	Sdt int,
);
alter table TacGia add constraint pk_MaTg primary key (MaTg)
go

create table TheLoai(
	MaTl varchar(10) not null,
	MaSach varchar(10) not null,

);
alter table TheLoai add constraint pk_MaTl primary key (MaTl)


create table TacGia_Sach(
	MaTg varchar(10) not null,
	MaSach varchar(10) not null,

);
alter table TacGia_Sach add constraint pk_MaTg_sach primary key (MaTg,MaSach)
alter table TacGia_Sach add constraint fk_tgsach_sach foreign key (MaSach) references Sach(MaSach)
alter table TacGia_Sach add constraint fk_tgsach_tg foreign key (MaTg) references TacGia(MaTg)
go

create table ChiTietPhieuMuon(
	SoPhieu int not null,
	MaSach varchar(10) not null,
	SoLuong int
); 
alter table ChiTietPhieuMuon add constraint pk_SoPhieu2 primary key (SoPhieu,MaSach)
alter table ChiTietPhieuMuon add constraint fk_chitiet_phieu foreign key (SoPhieu) references PhieuMuon(SoPhieu)
alter table ChiTietPhieuMuon add constraint fk_chitiet_sach foreign key (MaSach) references Sach(MaSach)
alter table ChiTietPhieuMuon add constraint chk_sl check (SoLuong <= 3)
go
insert into NganhHoc(MaNganh,TenNganh) values ('a1','Cntt'),
											  ('a12','Cntt'),
											  ('a123','marketing'),
											  ('a1234','shiper'),
											  ('a12345','Cntt')

go
insert into Lop(MaLop,TenLop,MaNganh) values ('it1','p01','a1'),
											 ('it2','p02','a1'),
											 ('it3','p03','a1'),
											 ('it4','p04','a1'),
											 ('it5','p05','a1')

go


insert into SinhVien(MaSv,HoTen,GioiTinh,NgaySinh,DiaChi,Email,Sdt,NgayHetHan,MaLop) values ('ph01', N'Lại văn chiến', N'Nam', '2001/01/20', N'Bắc Giang', 'chien@gmail.com', 0123456789, '2021/01/20', 'it1'),
							('ph02', N'Lại thị chín', N'Nữ', '2003/07/07', N'Bắc Giang', 'chin@gmail.com', 0123436789, '2021/01/01', 'it2'),
							('ph03', N'Nguyễn văn hòa', N'Nam', '2003/08/01', N'Hà Nội', 'hoa@gmail.com', 0127456789, '2021/08/01', 'it3'),
							('ph04', N'Nguyễn văn tường', N'Nam', '2000/02/01', N'Hà Nội', 'tuong@gmail.com', 0127457789, '2021/08/01', 'it4'),
							('ph05', N'Nguyễn thị mị', N'Nữ', '2000/06/01', N'Hà Nội', 'mi@gmail.com', 0127477849, '2021/09/01', 'it5')
go
delete SinhVien
insert into TacGia(MaTg,HoTen,ButDanh,DiaChi,Sdt) values ('tg01', N'Hồ Quang Hiếu', N'kì lân ko cánh', N'Hà Nội', 987654321),
														 ('tg02', N'Hồ Ly Tinh', N'kì lân ko cánh', N'Hà Nội', 987654321),
														 ('tg03', N'Toang Hết Ngày', N'kì lân ko cánh', N'Hà Nội', 987654321),
														 ('tg04', N'Lý Mạc Sầu', N'kì lân ko cánh', N'Hà Nội', 987654321),
														 ('tg05', N'Mặc Tự Tài', N'kì lân ko cánh', N'Hà Nội', 987654321)
go

insert into TheLoai(MaTl,MaSach) values('IT01','sach01'),
									   ('tl02','sach02'),
									   ('tl03','sach03'),
									   ('tl04','sach04'),
									   ('tl05','sach05')
go
insert into Sach(MaSach,TenSach,SoTrang, SlBanSao,NgayNk,NgayXb,ViTri,GhiChu,MaTl,GiaBia) values ('sach01', N'SQL Nhà em có con gà', 35,38, '2020/10/21','2019/10/21', N'Hàng 1', N'sách dắt tiền', 'IT01', 999999),
																					   ('sach02', N'SQl Nhà em có con bò', 50,32, '2020/10/21','2019/10/21', N'Hàng 2', N'sách dắt tiền', 'tl02', 888888),
																					   ('sach03', N'Nhà em có con heo', 30,39, '2020/10/21','2019/10/21', N'Hàng 3', N'sách dắt tiền', 'tl03', 2999999),
																					   ('sach04', N'Nhà em có con cá', 55,32, '2020/10/21','2019/10/21', N'Hàng 4', N'sách dắt tiền', 'tl04', 3999999),
																					   ('sach05', N'Nhà em có con trâu', 20,30, '2020/10/21','2019/10/21', N'Hàng 5', N'sách dắt tiền', 'tl05', 3999999)

go
delete Sach



insert into TacGia_Sach(MaTg,MaSach) values ('tg01','sach01'),
                                            ('tg02','sach02'),
											('tg03','sach03'),
											('tg04','sach04'),
											('tg05','sach05')
go

insert into ChiTietPhieuMuon(SoPhieu,MaSach,SoLuong) values (01, 'sach01', 2 ),
															(02, 'sach02', 2 ),
															(03, 'sach03', 2 ),
															(04, 'sach04', 2 ),
															(05, 'sach05', 2 )
go

insert into PhieuMuon(SoPhieu,NgayMuon,NgayTra,TrangThai,MaSv) values (01,'2016/12/01','2022/12/01',N'Đã Trả','ph01'),
																	  (02,'2017/12/01','2020/12/01',N'Đã Trả','ph02'),
																	  (03,'2018/12/01','2021/12/01',N'Chưa Trả','ph03'),
																	  (04,'2021/12/01','2022/12/01',N'Chưa Trả','ph04'),
																	  (05,'2021/12/01','2022/12/01',N'Sắp Trả', 'ph05')
go

select *from SinhVien
--asm 6
select MaSv, HoTen, datediff(year,NgaySinh,getdate()) as N'Tuổi',Sdt from SinhVien
where DiaChi=N'Hà Nội'

select *from Sach
select  SinhVien.MaSv, HoTen, NgayMuon, PhieuMuon.SoPhieu, Sach.MaSach, TenSach, NgayXb, GhiChu from SinhVien
join PhieuMuon on SinhVien.MaSv=PhieuMuon.MaSv
join ChiTietPhieuMuon on ChiTietPhieuMuon.SoPhieu=PhieuMuon.SoPhieu
join Sach on Sach.MaSach=ChiTietPhieuMuon.MaSach


select TenSach, Sach.MaSach, GiaBia, HoTen, MaTl  from Sach
join TacGia_Sach on Sach.MaSach=TacGia_Sach.MaSach
join TacGia on TacGia.MaTg=TacGia_Sach.MaTg
where Sach.MaTl like 'IT%'


select PhieuMuon.SoPhieu, Sach.MaSach, NgayMuon, MaSv  from PhieuMuon
join ChiTietPhieuMuon on PhieuMuon.SoPhieu=ChiTietPhieuMuon.SoPhieu
join Sach on ChiTietPhieuMuon.MaSach=Sach.MaSach
where YEAR(NgayMuon) = '2018' and MONTH(NgayMuon)='12'


select *from PhieuMuon 
where TrangThai like N'Chưa Trả%'
order by NgayMuon asc



select TheLoai.MaTl, TenSach , COUNT(Sach.MaTl) as N'Số lượng' from TheLoai
join Sach on Sach.MaSach=TheLoai.MaSach
group by TheLoai.MaTl, TenSach


select COUNT(MaSv) as N'Số Lượng'from PhieuMuon



select *from Sach
where TenSach like N'SQL%'



select SinhVien.MaSv, HoTen, PhieuMuon.SoPhieu, TenSach, NgayMuon, NgayTra from SinhVien
join PhieuMuon on SinhVien.MaSv=PhieuMuon.MaSv
join ChiTietPhieuMuon on ChiTietPhieuMuon.SoPhieu=PhieuMuon.SoPhieu
join Sach on Sach.MaSach=ChiTietPhieuMuon.MaSach
order by NgayMuon desc


select MaSach, COUNT(MaSach) as N'Số Lượt' from ChiTietPhieuMuon
group by MaSach
having COUNT(MaSach) > 0

select *from Sach
update Sach
set GiaBia = GiaBia*0.3
where YEAR(NgayNk) < 2021


select *from PhieuMuon
update PhieuMuon
set TrangThai = N'Đã trả'
where MaSv='ph05'



select *from SinhVien
select PhieuMuon.SoPhieu, HoTen, Email, MaSach, NgayMuon, NgayTra, TrangThai, DATEDIFF(DAY, PhieuMuon.NgayTra, GETDATE()) as N'Số Ngày Mượn' from PhieuMuon
join SinhVien on SinhVien.MaSv=PhieuMuon.MaSv
join ChiTietPhieuMuon on PhieuMuon.SoPhieu=ChiTietPhieuMuon.SoPhieu
where TrangThai like N'Chưa Trả' and DATEDIFF(DAY,PhieuMuon.NgayTra, GETDATE())>=0


update Sach
set SlBanSao=SlBanSao+5
where MaSach in (select MaSach from ChiTietPhieuMuon
				group by MaSach
				having COUNT(MaSach) >10)



select *into PhieuMuonNew from PhieuMuon
select *into ChiTietPhieuMuonNew from ChiTietPhieuMuon

select *from PhieuMuonNew
select *from ChiTietPhieuMuonNew

delete from ChiTietPhieuMuon
where SoPhieu in (select SoPhieu from PhieuMuonNew
					where NgayMuon < '2022/11/02')
delete from PhieuMuonNew
where NgayMuon < '2022/01/01'


select *from Sach
where GiaBia=(select top 1 GiaBia from Sach order by GiaBia desc)
select *from Sach
where GiaBia=(select MAX(GiaBia) from Sach)


select *from Sach
where SlBanSao=(select MAX(SlBanSao) from Sach)


select *from Sach
where SlBanSao >= ( select AVG(SlBanSao) from Sach)


select TheLoai.MaTl, TenSach, SlBanSao from TheLoai
join Sach on Sach.MaTl=TheLoai.MaTl
where SlBanSao>=20


select TheLoai.MaTl, TenSach, SlBanSao from TheLoai
join Sach on Sach.MaTl=TheLoai.MaTl
where SlBanSao=(select MAX(SlBanSao) from Sach)






