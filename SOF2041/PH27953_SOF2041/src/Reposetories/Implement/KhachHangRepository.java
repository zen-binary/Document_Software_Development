/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.KhachHang;
import Reposetories.IKhachHangReposetory;
import Utilities.DbContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class KhachHangRepository implements IKhachHangReposetory {

    @Override
    public List<KhachHang> getLstDb() {
        List<KhachHang> lst = new ArrayList<>();
        String Select = "SELECT Id, Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau FROM dbo.KhachHang";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getString("Id"));
                kh.setMa(rs.getString("Ma"));
                kh.setTen(rs.getString("Ten"));
                kh.setTenDem(rs.getString("TenDem"));
                kh.setHo(rs.getString("Ho"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setThanhPho(rs.getString("ThanhPho"));
                kh.setQuocGia(rs.getString("QuocGia"));
                kh.setMatKhau(rs.getString("MatKhau"));

                lst.add(kh);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;

    }

    @Override
    public boolean addLstDb(KhachHang kh) {
        int check = 0;
        String Insert = "INSERT INTO dbo.KhachHang(Id, Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau)VALUES(NEWID(),?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getTenDem());
            ps.setString(4, kh.getHo());
            ps.setDate(5, new java.sql.Date(kh.getNgaySinh().getTime()));
            ps.setString(6, kh.getSdt());
            ps.setString(7, kh.getDiaChi());
            ps.setString(8, kh.getThanhPho());
            ps.setString(9, kh.getQuocGia());
            ps.setString(10, kh.getMatKhau());

            check = ps.executeUpdate();
            conn.close();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean updateLstDb(String id, KhachHang kh) {
        int check = 0;
        String Update = "UPDATE dbo.KhachHang SET Ma = ?, Ten = ?, TenDem = ?, Ho = ?, NgaySinh = ?, Sdt = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, MatKhau = ? WHERE Id = ?";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getTenDem());
            ps.setString(4, kh.getHo());
            ps.setDate(5, new java.sql.Date(kh.getNgaySinh().getTime()));
            ps.setString(6, kh.getSdt());
            ps.setString(7, kh.getDiaChi());
            ps.setString(8, kh.getThanhPho());
            ps.setString(9, kh.getQuocGia());
            ps.setString(10, kh.getMatKhau());
            ps.setString(11, id);

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

        int check = 0;
        String Delete = "DELETE dbo.KhachHang WHERE Id = ?";

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
    public KhachHang getObj(String id) {

        String sql = "SELECT Id, Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau FROM dbo.KhachHang WHERE Id = ?";
        KhachHang kh = new KhachHang();

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                kh.setId(rs.getString("Id"));
                kh.setMa(rs.getString("Ma"));
                kh.setTen(rs.getString("Ten"));
                kh.setTenDem(rs.getString("TenDem"));
                kh.setHo(rs.getString("Ho"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setThanhPho(rs.getString("ThanhPho"));
                kh.setQuocGia(rs.getString("QuocGia"));
                kh.setMatKhau(rs.getString("MatKhau"));

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kh;
    }

}
