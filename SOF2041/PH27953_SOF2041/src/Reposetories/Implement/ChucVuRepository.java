/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.ChucVu;
import Reposetories.IChucVuReposetory;
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
public class ChucVuRepository implements IChucVuReposetory {

    private final String SELECT = "SELECT Id, Ma, Ten FROM dbo.ChucVu";
    private final String INSERT = "INSERT INTO dbo.ChucVu(Ma, Ten)VALUES(?,?)";
    private final String UPDATE = "UPDATE dbo.ChucVu SET Ma = ?, Ten = ? WHERE Id = ?";
    private final String DELETE = "DELETE dbo.ChucVu WHERE Id = ?";

    @Override
    public List<ChucVu> getLstDb() {
        List<ChucVu> lst = new ArrayList<>();

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setId(rs.getString("Id"));
                cv.setMa(rs.getString("Ma"));
                cv.setTen(rs.getString("Ten"));
                lst.add(cv);
            }

            conn.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean addLstDb(ChucVu cv) {
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT);

            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());

            check = ps.executeUpdate();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(Object oj, ChucVu cv) {
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE);

            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.setObject(3, oj);
            check = ps.executeUpdate();
            return check > 0;

        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean deleteLstDb(Object oj) {
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE);
            ps.setObject(1, oj);
            check = ps.executeUpdate();
            return check > 0;

        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public ChucVu getObj(String id) {
        ChucVu cv = new ChucVu();
        try {
            String sql = "SELECT Id, Ma, Ten FROM dbo.ChucVu WHERE Id = ?";
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cv.setId(rs.getString("Id"));
                cv.setMa(rs.getString("Ma"));
                cv.setTen(rs.getString("Ten"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cv;
    }

}
