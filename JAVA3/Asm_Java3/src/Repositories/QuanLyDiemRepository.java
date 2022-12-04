/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Model.Grade;
import Utilities.DbContext;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class QuanLyDiemRepository {

    public ArrayList<Grade> getLstDb() {
        ArrayList<Grade> lst = new ArrayList<>();
        String sql = "SELECT Id, Students.MaSv, HoTen, TiengAnh, TinHoc, GDTC, ROUND((TinHoc+TiengAnh+GDTC)/3, 2) AS 'AVG' FROM dbo.Grade JOIN dbo.Students ON Students.MaSv = Grade.MaSv ORDER BY AVG DESC";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Grade g = new Grade();
                g.setId(rs.getInt("Id"));
                g.setMaSv(rs.getString("MaSv"));
                g.setTiengAnh(rs.getInt("TiengAnh"));
                g.setTinHoc(rs.getInt("TinHoc"));
                g.setGdtc(rs.getInt("GDTC"));
                lst.add(g);
            }
            System.out.println("ok");
            conn.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean searchLstDb(String maSv) {

        String sql = "SELECT Id, MaSv, TiengAnh, TinHoc, GDTC FROM dbo.Grade WHERE MaSv = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check++;
            }
            System.out.println("tim ok");
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateLstDb(String maSv, Grade g) {

        String sql = "UPDATE dbo.Grade SET TiengAnh = ?, TinHoc = ?, GDTC = ? WHERE MaSv = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, g.getTiengAnh());
            ps.setInt(2, g.getTinHoc());
            ps.setInt(3, g.getGdtc());
            ps.setString(4, maSv);
            check = ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean deleteLstDb(String maSv) {

        String sql = "DELETE dbo.Grade WHERE MaSv = ?";
        int check = 0;

        try {

            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            check = ps.executeUpdate();
            conn.close();
            System.out.println("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public String getHoTenStudents(String maSv) {
        String sql = "SELECT HoTen FROM dbo.Students WHERE MaSv = ?";
        String Hoten = "null";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoten = rs.getString("HoTen");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Hoten;
    }
    
    public boolean insertLstDb(Grade g){
        String sql = "INSERT INTO dbo.Grade(MaSv,TiengAnh,TinHoc,GDTC)VALUES(?,?,?,?)";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, g.getMaSv());
            ps.setInt(2, g.getTiengAnh());
            ps.setInt(3, g.getTinHoc());
            ps.setInt(4, g.getGdtc());
            check = ps.executeUpdate();
            System.out.println("ok");
            conn.close();
        } catch (Exception e) {
        }
        
        return check > 0;
    }
}
