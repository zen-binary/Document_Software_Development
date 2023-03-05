/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.NSX;

import Reposetories.IMauSacReposetory;
import Reposetories.INSXReposetory;
import Utilities.DbContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class NSXReposetory implements INSXReposetory {

    @Override
    public List<NSX> getLstDb() {
        List<NSX> lst = new ArrayList<>();
        String Select = "SELECT Id, Ma, Ten FROM dbo.NSX";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX();
                nsx.setId(rs.getString("Id"));
                nsx.setId(rs.getString("Ma"));
                nsx.setId(rs.getString("Ten"));

                lst.add(nsx);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    @Override
    public boolean addLstDb(NSX nsx) {
        String Insert = "INSERT INTO dbo.NSX(Id, Ma, Ten)VALUES(NEWID(),?,?)";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, NSX nsx) {
        String Update = "UPDATE dbo.NSX SET Ma = ?, Ten = ? WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.setString(3, id);

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
        String Delete = "DELETE dbo.NSX WHERE Id = ?";
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
    public NSX getObj(String id) {
        String sql = "SELECT Id, Ma, Ten FROM dbo.NSX WHERE Id = ?";
        NSX nsx = new NSX();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nsx.setId(rs.getString("Id"));
                nsx.setId(rs.getString("Ma"));
                nsx.setId(rs.getString("Ten"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

}
