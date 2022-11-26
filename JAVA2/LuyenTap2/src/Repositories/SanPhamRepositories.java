/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

/**
 *
 * @author Admin
 */
import model.SanPham;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class SanPhamRepositories {

    public SanPhamRepositories() {
    }
    
    public boolean Add(SanPham s){
        try(Connection conn = DBConnext.getConnection()) {
            Statement st = conn.createStatement();
            String Insert_Sp = "INSERT INTO dbo.SanPham(maSp,tenSp,doanhMuc,tinhTrang,donGia,NgaySx)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(Insert_Sp);
            ps.setString(1, s.getMaSp());
            ps.setString(2, s.getTenSp());
            ps.setString(3, s.getDoanhMuc());
            ps.setBoolean(4, s.isTinhTrang());
            ps.setDouble(5, s.getDonGia());
            ps.setString(6, s.getNgaySx());
            ps.execute();
            System.out.println("Truy van ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public ArrayList<SanPham> getSP(){
        ArrayList<SanPham> lst = new ArrayList<>();
        
        try {
            Connection conn = DBConnext.getConnection();
            String sql = "SELECT *FROM dbo.SanPham";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String maSp = rs.getString(1);
                String tenSp = rs.getString(2);
                String doanhMuc = rs.getString(3);
                boolean tinhTrang = rs.getBoolean(4);
                double donGia = rs.getDouble(5);
                String ngaySX = rs.getString(6);
                SanPham sp = new SanPham(maSp, tenSp,  doanhMuc, tinhTrang, donGia, ngaySX);
                lst.add(sp);
            }
            System.out.println("Truy van ok4");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lst;
    }
    
    public boolean updateSp(String ma, SanPham sp){
        try {
            Connection conn = DBConnext.getConnection();
            String sql = "UPDATE dbo.SanPham"
                    + "SET maSp = ?, tenSp = ?, doanhMuc = ?, tinhTrang = ?,"
                    + "donGia = ? , NgaySx = ? WHERE maSp = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSp());
            ps.setString(2, sp.getTenSp());
            ps.setString(3, sp.getDoanhMuc());
            ps.setBoolean(4, sp.isTinhTrang());
            ps.setDouble(5, sp.getDonGia());
            ps.setString(6, sp.getNgaySx());
            ps.setString(7, ma);
            ps.execute();
            System.out.println("Up truy van ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
}
