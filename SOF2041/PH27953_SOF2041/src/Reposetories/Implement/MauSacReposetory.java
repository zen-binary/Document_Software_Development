/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.MauSac;

import Reposetories.IMauSacReposetory;
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
public class MauSacReposetory implements IMauSacReposetory {

    @Override
    public List<MauSac> getLstDb() {
        List<MauSac> lst = new ArrayList<>();
        String Select = "SELECT Id, Ma, Ten FROM dbo.MauSac";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getString("Id"));
                ms.setId(rs.getString("Ma"));
                ms.setId(rs.getString("Ten"));

                lst.add(ms);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    @Override
    public boolean addLstDb(MauSac ms) {
        String Insert = "INSERT INTO dbo.MauSac(Id, Ma, Ten)VALUES(NEWID(),?,?)";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, MauSac ms) {
        String Update = "UPDATE dbo.MauSac SET Ma = ?, Ten = ? WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
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
        String Delete = "DELETE dbo.MauSac WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Delete);
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
    public MauSac getObj(String id) {
        String sql = "SELECT Id, Ma, Ten FROM dbo.DongSP WHERE Id = ?";
        MauSac ms = new MauSac();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ms.setId(rs.getString("Id"));
                ms.setId(rs.getString("Ma"));
                ms.setId(rs.getString("Ten"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

}
