/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import Reposetories.ICuaHangRepository;
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
public class CuaHangRepository implements ICuaHangRepository{

    private final String SELECT = "SELECT Id, Ma, Ten, DiaChi, ThanhPho, QuocGia FROM dbo.CuaHang";
    private final String INSERT = "INSERT INTO dbo.CuaHang(Id,Ma,Ten,DiaChi,ThanhPho,QuocGia)VALUES(NEWID(), ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE dbo.CuaHang SET Ma = ?, Ten = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ? WHERE Id = ?";
    private final String DELETE = "DELETE dbo.CuaHang WHERE Id =?";

    @Override
    public List<CuaHang> getLstDb() {
        List<CuaHang> lst = new ArrayList<>();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang ch = new CuaHang();

                ch.setId(rs.getString("Id"));
                ch.setMa(rs.getString("Ma"));
                ch.setTen(rs.getString("Ten"));
                ch.setDiaChi(rs.getString("DiaChi"));
                ch.setThanhPho(rs.getString("ThanhPho"));
                ch.setQuocGia(rs.getString("QuocGia"));

                lst.add(ch);
            }

            conn.close();

            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean addLstDb(CuaHang ch) {
        try {
            int check = 0;
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());

            check = ps.executeUpdate();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String id, CuaHang ch) {

        try {
            int check = 0;
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            ps.setString(6, id);

            check = ps.executeUpdate();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteLstDb(String id) {
        try {

            int check = 0;
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE);
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
    public CuaHang getObj(String id) {
        CuaHang ch = new CuaHang();
        try {
            String sql = "SELECT Id, Ma, Ten, DiaChi, ThanhPho, QuocGia FROM dbo.CuaHang WHERE Id = ?";
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ch.setId(rs.getString("Id"));
                ch.setMa(rs.getString("Ma"));
                ch.setTen(rs.getString("Ten"));
                ch.setDiaChi(rs.getString("DiaChi"));
                ch.setThanhPho(rs.getString("ThanhPho"));
                ch.setQuocGia(rs.getString("QuocGia"));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ch;
    }

}
