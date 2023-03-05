/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.HoaDon;
import Reposetories.IHoaDonReposetory;
import Utilities.DbContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Reposetories.IKhachHangReposetory;
import Reposetories.INhanVienReposetory;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements IHoaDonReposetory {

    IKhachHangReposetory khRepo = new KhachHangRepository();
    INhanVienReposetory nvRepo = new NhanVienReposetory();

    @Override
    public List<HoaDon> getLstDb() {
        List<HoaDon> lst = new ArrayList<>();
        String Select = "SELECT Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt FROM dbo.HoaDon";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString("Id"));

                KhachHang kh = khRepo.getObj(rs.getString("IdKH"));
                hd.setIdKh(kh);

                NhanVien nv = nvRepo.getObj(rs.getString("IdNV"));
                hd.setIdNv(nv);

                hd.setMa(rs.getString("Ma"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hd.setNgayShip(rs.getDate("NgayShip"));
                hd.setNgayNhan(rs.getDate("NgayNhan"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                hd.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                hd.setDiaChi(rs.getString("DiaChi"));
                hd.setSdt(rs.getString("Sdt"));

                lst.add(hd);

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    @Override
    public boolean addLstDb(HoaDon hd) {

        String Insert = "INSERT INTO dbo.HoaDon (Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt)VALUES(NEWID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, hd.getIdKh().getId());
            ps.setString(2, hd.getIdNv().getId());
            ps.setString(3, hd.getMa());
            ps.setDate(4, new java.sql.Date(hd.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hd.getNgayThanhToan().getTime()));
            ps.setDate(6, new java.sql.Date(hd.getNgayShip().getTime()));
            ps.setDate(7, new java.sql.Date(hd.getNgayNhan().getTime()));
            ps.setInt(8, hd.getTinhTrang());
            ps.setString(9, hd.getTenNguoiNhan());
            ps.setString(10, hd.getDiaChi());
            ps.setString(11, hd.getSdt());

            check = ps.executeUpdate();
            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, HoaDon hd) {
        String Update = "UPDATE dbo.HoaDon SET IdKH= ?, IdNV = ?, Ma = ?, NgayTao = ?, NgayThanhToan = ?, NgayShip = ?, NgayNhan = ?, TinhTrang = ?, TenNguoiNhan = ?, DiaChi = ?, Sdt = ? WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);

            ps.setString(1, hd.getIdKh().getId());
            ps.setString(2, hd.getIdNv().getId());
            ps.setString(3, hd.getMa());
            ps.setDate(4, new java.sql.Date(hd.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hd.getNgayThanhToan().getTime()));
            ps.setDate(6, new java.sql.Date(hd.getNgayShip().getTime()));
            ps.setDate(7, new java.sql.Date(hd.getNgayNhan().getTime()));
            ps.setInt(8, hd.getTinhTrang());
            ps.setString(9, hd.getTenNguoiNhan());
            ps.setString(10, hd.getDiaChi());
            ps.setString(11, hd.getSdt());
            ps.setString(12, id);

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
        String Delete = "DELETE dbo.HoaDon WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Delete);
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
    public HoaDon getObj(String id) {
        String sql = "SELECT Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt FROM dbo.HoaDon WHERE Id = ?";
        HoaDon hd = new HoaDon();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hd.setId(rs.getString("Id"));
                
                KhachHang kh = khRepo.getObj(rs.getString("IdKH"));
                hd.setIdKh(kh);

                NhanVien nv = nvRepo.getObj(rs.getString("IdNV"));
                hd.setIdNv(nv);

                hd.setMa(rs.getString("Ma"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hd.setNgayShip(rs.getDate("NgayShip"));
                hd.setNgayNhan(rs.getDate("NgayNhan"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                hd.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                hd.setDiaChi(rs.getString("DiaChi"));
                hd.setSdt(rs.getString("Sdt"));
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hd;

    }

}
