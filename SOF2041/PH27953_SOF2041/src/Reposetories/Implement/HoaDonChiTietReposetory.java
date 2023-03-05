/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Reposetories.IChiTietSPReposetory;
import Reposetories.IHoaDonChiTietReposetory;
import Reposetories.IHoaDonReposetory;
import Utilities.DbContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietReposetory implements IHoaDonChiTietReposetory {

    IHoaDonReposetory hdRepo = new HoaDonRepository();
    IChiTietSPReposetory ctSPRepo = new ChiTietSPReposetory();

    @Override
    public List<HoaDonChiTiet> getLstDb() {
        List<HoaDonChiTiet> lst = new ArrayList<>();
        String Select = "SELECT IdHoaDon, IdChiTietSP, SoLuong, DonGia FROM dbo.HoaDonChiTiet";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();

                HoaDon hd = hdRepo.getObj(rs.getString("IdHoaDon"));
                hdct.setIdHoaDon(hd);

                ChiTietSP ctSP = ctSPRepo.getObj(rs.getString("IdChiTietSP"));
                hdct.setIdChiTietSp(ctSP);

                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setDonGia(rs.getDouble("DonGia"));
                lst.add(hdct);

            }

        } catch (Exception e) {
        }

        return lst;
    }

    @Override
    public boolean addLstDb(HoaDonChiTiet hdct) {
        String Insert = "INSERT INTO dbo.HoaDonChiTiet (IdHoaDon, IdChiTietSP, SoLuong, DonGia )VALUES(?,?,?,?)";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, hdct.getIdHoaDon().getId());
            ps.setString(2, hdct.getIdChiTietSp().getId());
            ps.setInt(3, hdct.getSoLuong());
            ps.setDouble(4, hdct.getDonGia());

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateLstDb(String idHd, String idCtSp,HoaDonChiTiet hdct) {
        String Update = "UPDATE dbo.HoaDonChiTiet SET SoLuong = ?,DonGia = ? WHERE IdHoaDon = ? AND IdChiTietSP = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setInt(1, hdct.getSoLuong());
            ps.setDouble(2, hdct.getDonGia());
            ps.setString(3, idHd);
            ps.setString(4, idCtSp);

            check = ps.executeUpdate();
            conn.close();

            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteLstDb(String idHd, String idCtSp) {
        String Delete = "DELETE dbo.HoaDonChiTiet WHERE IdHoaDon = ? AND IdChiTietSP = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Delete);
            ps.setString(1, idHd);
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
    public HoaDonChiTiet getObj(String idHd, String idCtSp) {
        HoaDonChiTiet hdCt = new HoaDonChiTiet();
        String sql = "SELECT IdHoaDon, IdChiTietSP, SoLuong, DonGia FROM dbo.HoaDonChiTiet WHERE IdHoaDon = ? AND IdChiTietSP = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHd);
            ps.setString(2, idCtSp);
            ResultSet rs = ps.executeQuery();

            HoaDon hd = hdRepo.getObj(rs.getString("IdHoaDon"));
            hdCt.setIdHoaDon(hd);

            ChiTietSP ctSP = new ChiTietSP();
            ctSP.setId(rs.getString("IdChiTietSP"));
            hdCt.setIdChiTietSp(ctSP);

            hdCt.setSoLuong(rs.getInt("SoLuong"));
            hdCt.setDonGia(rs.getDouble("DonGia"));

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hdCt;
    }

}
