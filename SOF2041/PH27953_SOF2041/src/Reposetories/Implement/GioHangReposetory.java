/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.GioHang;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Reposetories.IGioHangReposetory;
import Reposetories.IKhachHangReposetory;
import Reposetories.INhanVienReposetory;
import Utilities.DbContext;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GioHangReposetory implements IGioHangReposetory {

    IKhachHangReposetory khRepo = new KhachHangRepository();
    INhanVienReposetory nvRepo = new NhanVienReposetory();

    @Override
    public List<GioHang> getLstDb() {
        List<GioHang> lst = new ArrayList<>();
        String Select = "SELECT Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang FROM dbo.GioHang";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GioHang gh = new GioHang();
                gh.setId(rs.getString("Id"));

                KhachHang kh = khRepo.getObj(rs.getString("IdKH"));
                gh.setIdKh(kh);

                NhanVien nv = nvRepo.getObj(rs.getString("IdNV"));
                gh.setIdNv(nv);

                gh.setMa(rs.getString("Ma"));
                gh.setNgayTao(rs.getDate("NgayTao"));
                gh.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                gh.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                gh.setDiaChi(rs.getString("DiaChi"));
                gh.setSdt(rs.getString("Sdt"));
                gh.setTinhTrang(rs.getInt("TinhTrang"));

                lst.add(gh);

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    @Override
    public boolean addLstDb(GioHang gh) {
        String Insert = "INSERT INTO dbo.GioHang(Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang)VALUES(NEWID(), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, gh.getIdKh().getId());
            ps.setString(2, gh.getIdNv().getId());
            ps.setString(3, gh.getMa());
            ps.setDate(4, new java.sql.Date(gh.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(gh.getNgayThanhToan().getTime()));
            ps.setString(6, gh.getTenNguoiNhan());
            ps.setString(7, gh.getDiaChi());
            ps.setString(8, gh.getSdt());
            ps.setInt(9, gh.getTinhTrang());

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, GioHang gh) {
        String Update = "UPDATE dbo.GioHang SET IdKH = ?, IdNV= ?, Ma= ?, NgayTao = ?, NgayThanhToan= ?, TenNguoiNhan = ?, DiaChi = ?, Sdt = ?, TinhTrang = ? WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, gh.getIdKh().getId());
            ps.setString(2, gh.getIdNv().getId());
            ps.setString(3, gh.getMa());
            ps.setDate(4, new java.sql.Date(gh.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(gh.getNgayThanhToan().getTime()));
            ps.setString(6, gh.getTenNguoiNhan());
            ps.setString(7, gh.getDiaChi());
            ps.setString(8, gh.getSdt());
            ps.setInt(9, gh.getTinhTrang());
            ps.setString(10, id);

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
        String Delete = "DELETE dbo.GioHang WHERE Id = ?";
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
    public GioHang getObj(String id) {
        String sql = "SELECT Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang FROM dbo.GioHang  WHERE Id = ?";
        GioHang gh = new GioHang();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                gh.setId(rs.getString("Id"));

                KhachHang kh = khRepo.getObj(rs.getString("IdKH"));
                gh.setIdKh(kh);

                NhanVien nv = nvRepo.getObj(rs.getString("IdNV"));
                gh.setIdNv(nv);

                gh.setMa(rs.getString("Ma"));
                gh.setNgayTao(rs.getDate("NgayTao"));
                gh.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                gh.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                gh.setDiaChi(rs.getString("DiaChi"));
                gh.setSdt(rs.getString("Sdt"));
                gh.setTinhTrang(rs.getInt("TinhTrang"));

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gh;
    }

}
