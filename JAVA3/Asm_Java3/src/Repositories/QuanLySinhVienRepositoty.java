/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Model.Students;
import Utilities.DbContext;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class QuanLySinhVienRepositoty {

    public ArrayList<Students> getLstDb() {
        ArrayList<Students> lst = new ArrayList<>();
        String sql = "SELECT MaSv, HoTen, Email, SoDT, GioiTinh, DiaChi, Hinh FROM dbo.Students";
        try {

            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Students s = new Students();
                s.setMaSv(rs.getString("MaSv"));
                s.setHoTen(rs.getString("HoTen"));
                s.setEmail(rs.getString("Email"));
                s.setSoDt(rs.getString("SoDT"));
                s.setGioiTinh(rs.getBoolean("GioiTinh"));
                s.setDiaChi(rs.getString("DiaChi"));
                s.setHinh(rs.getString("Hinh"));

                lst.add(s);

            }
            conn.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean saveLstDb(Students s) {

        String sql = "INSERT INTO dbo.Students(MaSv, HoTen, Email, SoDT, GioiTinh, DiaChi, Hinh)VALUES(?,?,?,?,?,?,?)";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSv());
            ps.setString(2, s.getHoTen());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getSoDt());
            ps.setBoolean(5, s.isGioiTinh());
            ps.setString(6, s.getDiaChi());
            ps.setString(7, s.getHinh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean updateLstDb(String maSv, Students s) {
        String sql = "UPDATE dbo.Students SET HoTen = ?, Email = ?, SoDT = ?, GioiTinh = ?, DiaChi = ?, Hinh = ? WHERE MaSv = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getHoTen());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getSoDt());
            ps.setBoolean(4, s.isGioiTinh());
            ps.setString(5, s.getDiaChi());
            ps.setString(6, s.getHinh());
            ps.setString(7, maSv);
            check = ps.executeUpdate();
            conn.close();
            System.out.println("update " + check);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean deleteLstDb(String maSv) {

        String sql = "DELETE dbo.Students WHERE MaSv = ?";
        int check = 0;
        deleteFkDb(maSv);
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            check = ps.executeUpdate();
            conn.close();

            System.out.println("delete " + check);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean deleteFkDb(String maSv) {
        String sql = "DELETE dbo.Grade WHERE MaSv = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            check = ps.executeUpdate();
            conn.close();
            System.out.println("xoa grade vs mã " + maSv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }
    
    public ArrayList<Students> searchSvDb(String nameStr){
        String sql = "SELECT MaSv, HoTen, Email, SoDT, GioiTinh, DiaChi, Hinh FROM dbo.Students WHERE MaSv = ? OR HoTen = ?";
        ArrayList<Students> lst = new ArrayList<>();
        
       
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nameStr);
            ps.setString(2, nameStr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Students s = new Students();
                s.setMaSv(rs.getString("MaSv"));
                s.setHoTen(rs.getString("HoTen"));
                s.setEmail(rs.getString("Email"));
                s.setSoDt(rs.getString("SoDT"));
                s.setGioiTinh(rs.getBoolean("GioiTinh"));
                s.setDiaChi(rs.getString("DiaChi"));
                s.setHinh(rs.getString("Hinh"));
                lst.add(s);
                System.out.println("tim ok");
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return lst;
    }
    

}
