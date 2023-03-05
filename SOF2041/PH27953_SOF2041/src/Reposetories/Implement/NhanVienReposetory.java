/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.NhanVien;
import DomainModels.CuaHang;
import DomainModels.ChucVu;
import Reposetories.ICuaHangRepository;
import Reposetories.INhanVienReposetory;
import Reposetories.INhanVienReposetory;
import Reposetories.IChucVuReposetory;
import Utilities.DbContext;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhanVienReposetory implements INhanVienReposetory {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
    ICuaHangRepository cuaHangRepo = new CuaHangRepository();
    IChucVuReposetory chucVuRepo = new ChucVuRepository();

    @Override
    public List<NhanVien> getLstDb() {
        List<NhanVien> lst = new ArrayList<>();
        String Select = "SELECT Id, Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, IdGuiBC, TrangThai FROM dbo.NhanVien";
//        String Select = "SELECT dbo.NhanVien.Id Id, dbo.NhanVien.Ma Ma, dbo.NhanVien.Ten Ten, TenDem, Ho, GioiTinh, NgaySinh, dbo.NhanVien.DiaChi DiaChi, Sdt, MatKhau, "
//                + "dbo.CuaHang.Id IdCH, dbo.CuaHang.Ma MaCH,CuaHang.Ten TenCH, CuaHang.DiaChi DiaChiCH, ThanhPho, QuocGia ,"
//                + "ChucVu.Id IdCV, ChucVu.Ma MaCV, ChucVu.Ten TenCV, "
//                + "IdGuiBC, TrangThai FROM dbo.NhanVien JOIN dbo.CuaHang ON CuaHang.Id = NhanVien.IdCH JOIN dbo.ChucVu ON ChucVu.Id = NhanVien.IdCV";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                
                nv.setId(rs.getString("Id"));
                nv.setMa(rs.getString("Ma"));
                nv.setTen(rs.getString("Ten"));
                nv.setTenDem(rs.getString("TenDem"));
                nv.setHo(rs.getString("Ho"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
//                nv.setNgaySinh(new java.util.Date(rs.getDate("NgaySinh").getTime()));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setMatKhau(rs.getString("MatKhau"));

                CuaHang ch = cuaHangRepo.getObj(rs.getString("IdCH"));
//                ch.setId(rs.getString("IdCH"));
//                ch.setMa(rs.getString("MaCH"));
//                ch.setTen(rs.getString("TenCH"));
//                ch.setDiaChi(rs.getString("DiaChiCH"));
//                ch.setThanhPho(rs.getString("ThanhPho"));
//                ch.setQuocGia(rs.getString("QuocGia"));
                nv.setIdCh((CuaHang) ch);

                ChucVu cv = chucVuRepo.getObj(rs.getString("IdCV"));
//                cv.setId(rs.getString("IdCV"));
//                cv.setMa(rs.getString("MaCV"));
//                cv.setTen(rs.getString("TenCV"));
                nv.setIdCv((ChucVu) cv);

                nv.setIdGuiBc(rs.getString("IdGuiBC"));
                nv.setTrangThai(rs.getInt("TrangThai"));

                lst.add(nv);

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return lst;
    }

    @Override
    public boolean addLstDb(NhanVien nv) {

        String Insert = "INSERT INTO dbo.NhanVien(Id, Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, IdGuiBC, TrangThai)VALUES(NEWID(),?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getTenDem());
            ps.setString(4, nv.getHo());
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getSdt());
            ps.setString(9, nv.getMatKhau());
           
            ps.setString(10, nv.getIdCh().getId());
//            System.out.println("cua hang"+ idCH);
            
            ps.setString(11, nv.getIdCv().getId());
//            System.out.println("chuc vu"+ idCV);

            ps.setString(12, nv.getIdGuiBc()); //IdGuiBc
            ps.setInt(13, nv.getTrangThai());

            check = ps.executeUpdate();

            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, NhanVien nv) {
        String update = "UPDATE dbo.NhanVien SET Ma = ?, Ten = ?, TenDem = ?, Ho = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Sdt = ?, MatKhau = ?, IdCH = ?, IdCV = ?, IdGuiBC =?, TrangThai =? WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getTenDem());
            ps.setString(4, nv.getHo());
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getSdt());
            ps.setString(9, nv.getMatKhau());
            ps.setString(10, nv.getIdCh().getId());
            ps.setString(11, nv.getIdCv().getId());
            ps.setString(12, nv.getIdGuiBc());
            ps.setInt(13, nv.getTrangThai());
            ps.setString(14, id);

            check = ps.executeUpdate();

            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteLstDb(String id) {
        String delete = "DELETE dbo.NhanVien WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, id);

            check = ps.executeUpdate();

            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public NhanVien getObj(String id) {
        String sql = "SELECT Id, Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, IdGuiBC, TrangThai FROM dbo.NhanVien WHERE Id = ?";
        NhanVien nv = new NhanVien();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nv.setId(rs.getString("Id"));
                nv.setMa(rs.getString("Ma"));
                nv.setTen(rs.getString("Ten"));
                nv.setTenDem(rs.getString("TenDem"));
                nv.setHo(rs.getString("Ho"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setMatKhau(rs.getString("MatKhau"));

                CuaHang ch = cuaHangRepo.getObj(rs.getString("IdCH"));
                nv.setIdCh((CuaHang) ch);

                ChucVu cv = chucVuRepo.getObj(rs.getString("IdCV"));
                nv.setIdCv((ChucVu) cv);

                nv.setIdGuiBc(rs.getString("IdGuiBC"));
                nv.setTrangThai(rs.getInt("TrangThai"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }
     public static void main(String[] args) {
         NhanVien nv  = new NhanVien();
         nv.setMa("Nv08t");
         CuaHang ch  = new CuaHang();
         ch.setId("1B7ADAA4-4115-4965-AF07-366A3563B812");
         nv.setIdCh(ch);
         ChucVu cv  = new ChucVu();
         cv.setId("E00B291F-0382-44EF-ADC6-10195B22645B");
         nv.setIdCv(cv);
         nv.setTrangThai(0);
        new NhanVienReposetory().addLstDb(nv);
    }
}
