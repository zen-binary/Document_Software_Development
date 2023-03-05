/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.DongSP;
import Reposetories.IDongSPReposetory;
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
public class DongSPReposetory implements IDongSPReposetory {

    @Override
    public List<DongSP> getLstDb() {
        List<DongSP> lst = new ArrayList<>();
        String Select = "SELECT Id, Ma, Ten FROM dbo.DongSP";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSP dongSp = new DongSP();
                dongSp.setId(rs.getString("Id"));
                dongSp.setId(rs.getString("Ma"));
                dongSp.setId(rs.getString("Ten"));

                lst.add(dongSp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    @Override
    public boolean addLstDb(DongSP dongSP) {
        String Insert = "INSERT INTO dbo.DongSP(Id, Ma, Ten)VALUES(NEWID(),?,?)";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, dongSP.getMa());
            ps.setString(2, dongSP.getTen());

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, DongSP dongSP) {
        String Update = "UPDATE dbo.DongSP SET Ma = ?, Ten = ? WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, dongSP.getMa());
            ps.setString(2, dongSP.getTen());
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
        String Delete = "DELETE dbo.DongSP WHERE Id = ?";
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
    public DongSP getObj(String id) {
        String sql = "SELECT Id, Ma, Ten FROM dbo.DongSP WHERE Id = ?";
        DongSP dongSP = new DongSP();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dongSP.setId(rs.getString("Id"));
                dongSP.setId(rs.getString("Ma"));
                dongSP.setId(rs.getString("Ten"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }

}
