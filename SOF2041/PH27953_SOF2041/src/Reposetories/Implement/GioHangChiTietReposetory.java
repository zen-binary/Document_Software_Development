/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import Reposetories.IChiTietSPReposetory;
import Reposetories.IGioHangChiTietReposetory;
import Reposetories.IGioHangReposetory;
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
public class GioHangChiTietReposetory implements IGioHangChiTietReposetory {

    IGioHangReposetory ghRepo = new GioHangReposetory();
    IChiTietSPReposetory ctSpRepo = new ChiTietSPReposetory();

    @Override
    public List<GioHangChiTiet> getLstDb() {
        List<GioHangChiTiet> lst = new ArrayList<>();
        String Select = "SELECT IdGioHang,IdChiTietSP,SoLuong,DonGia,DonGiaKhiGiam FROM dbo.GioHangChiTiet";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GioHangChiTiet ghCt = new GioHangChiTiet();

                GioHang gh = ghRepo.getObj(rs.getString("IdGioHang"));
                ghCt.setIdGioHang(gh);

                ChiTietSP ctSp = ctSpRepo.getObj(rs.getString("IdChiTietSP"));
                ghCt.setIdChiTietSp(ctSp);

                ghCt.setSoLuong(rs.getInt("SoLuong"));
                ghCt.setDonGia(rs.getDouble("DonGia"));
                ghCt.setDonGiaKhiGiam(rs.getDouble("DonGiaKhiGiam"));

                lst.add(ghCt);

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;

    }

    @Override
    public boolean addLstDb(GioHangChiTiet gh) {
        String Insert = "INSERT INTO dbo.GioHangChiTiet(IdGioHang,IdChiTietSP,SoLuong,DonGia,DonGiaKhiGiam)VALUES(?,?,?,?,?)";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, gh.getIdGioHang().getId());
            ps.setString(2, gh.getIdChiTietSp().getId());
            ps.setInt(3, gh.getSoLuong());
            ps.setDouble(4, gh.getDonGia());
            ps.setDouble(5, gh.getDonGiaKhiGiam());

            check = ps.executeUpdate();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String idGh, String idCtSp, GioHangChiTiet ghCt) {
        String Update = "UPDATE dbo.GioHangChiTiet SET SoLuong = ?, DonGia = ?, DonGiaKhiGiam = ? WHERE IdGioHang = ? AND IdChiTietSP = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setInt(1, ghCt.getSoLuong());
            ps.setDouble(2, ghCt.getDonGia());
            ps.setDouble(3, ghCt.getDonGiaKhiGiam());
            ps.setString(4, idGh);
            ps.setString(5, idCtSp);

            check = ps.executeUpdate();
            conn.close();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteLstDb(String idGh, String idCtSp) {
        String Delete = "DELETE dbo.GioHangChiTiet WHERE IdGioHang = ? AND IdChiTietSP = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Delete);
            ps.setString(1, idGh);
            ps.setString(2, idCtSp);

            check = ps.executeUpdate();
            conn.close();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public GioHangChiTiet getObj(String idGh, String idCtSp) {
        String sql = "SELECT IdGioHang,IdChiTietSP,SoLuong,DonGia,DonGiaKhiGiam FROM dbo.GioHangChiTiet WHERE IdGioHang = ? AND IdChiTietSP = ?";
        GioHangChiTiet ghCt = new GioHangChiTiet();
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idGh);
            ps.setString(2, idCtSp);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                GioHang gh = ghRepo.getObj(rs.getString("IdGioHang"));
                ghCt.setIdGioHang(gh);

                ChiTietSP ctSp = ctSpRepo.getObj(rs.getString("IdChiTietSP"));
                ghCt.setIdChiTietSp(ctSp);

                ghCt.setSoLuong(rs.getInt("SoLuong"));
                ghCt.setDonGia(rs.getDouble("DonGia"));
                ghCt.setDonGiaKhiGiam(rs.getDouble("DonGiaKhiGiam"));

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ghCt;
    }

}
