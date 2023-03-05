/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.SanPham;
import Reposetories.ISanPhamReposetory;
import Utilities.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamReposetory implements ISanPhamReposetory {

    @Override
    public List<SanPham> getLstDb() {
        List<SanPham> lst = new ArrayList<>();
        String Select = "SELECT Id, Ma, Ten FROM dbo.SanPham";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getString("Id"));
                sp.setId(rs.getString("Ma"));
                sp.setId(rs.getString("Ten"));

                lst.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    @Override
    public boolean addLstDb(SanPham sp) {
        String Insert = "INSERT INTO dbo.SanPham(Id, Ma, Ten)VALUES(NEWID(),?,?)";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(Object oj, SanPham sp) {
        String Update = "UPDATE dbo.SanPham SET Ma = ?, Ten = ? WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, (String) oj);

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean deleteLstDb(Object oj) {
        String Delete = "DELETE dbo.SanPham WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Delete);
            ps.setString(1, (String) oj);
            check = ps.executeUpdate();
            conn.close();

            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public SanPham getObj(String id) {
        String sql = "SELECT Id, Ma, Ten FROM dbo.SanPham WHERE Id = ?";
        SanPham sp = new SanPham();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                sp.setId(rs.getString("Id"));
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

}
