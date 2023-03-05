/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposetories.Implement;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Reposetories.IChiTietSPReposetory;
import Reposetories.IDongSPReposetory;
import Reposetories.IMauSacReposetory;
import Reposetories.INSXReposetory;
import Reposetories.ISanPhamReposetory;
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
public class ChiTietSPReposetory implements IChiTietSPReposetory {

    ISanPhamReposetory spRepo = new SanPhamReposetory();
    IMauSacReposetory msRepo = new MauSacReposetory();
    IDongSPReposetory dongSpRepo = new DongSPReposetory();
    INSXReposetory nsxRepo = new NSXReposetory();

    @Override
    public List<ChiTietSP> getLstDb() {
        List<ChiTietSP> lst = new ArrayList<>();
        String Select = "SELECT Id, IdSP, IdNsx, IdMauSac, IdDongSP, NamBH,  MoTa, SoLuongTon, GiaNhap, GiaBan FROM dbo.ChiTietSP";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSP ctCP = new ChiTietSP();
                ctCP.setId(rs.getString("Id"));

                SanPham sp = spRepo.getObj(rs.getString("IdSP"));
                ctCP.setIdSp(sp);

                NSX nsx = nsxRepo.getObj(rs.getString("IdNsx"));
                ctCP.setIdNsx(nsx);

                MauSac ms = msRepo.getObj(rs.getString("IdMauSac"));
                ctCP.setIdMauSac(ms);

                DongSP dongSp = dongSpRepo.getObj(rs.getString("IdDongSP"));
                ctCP.setIdDongSp(dongSp);

                ctCP.setNamBh(rs.getInt("NamBH"));
                ctCP.setMoTa(rs.getString("MoTa"));
                ctCP.setSoLuongTon(rs.getInt("SoLuongTon"));
                ctCP.setGiaNhap(rs.getDouble("GiaNhap"));
                ctCP.setGiaBan(rs.getDouble("GiaBan"));

                lst.add(ctCP);

            }

            conn.close();

        } catch (Exception e) {
        }

        return lst;

    }

    @Override
    public boolean addLstDb(ChiTietSP ctSp) {
        int check = 0;
        String Insert = "INSERT INTO dbo.ChiTietSP(Id, IdSP, IdNsx, IdMauSac, IdDongSP, NamBH,  MoTa, SoLuongTon, GiaNhap, GiaBan)VALUES(NEWID(), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Insert);
            ps.setString(1, ctSp.getIdSp().getId());
            ps.setString(2, ctSp.getIdNsx().getId());
            ps.setString(3, ctSp.getIdMauSac().getId());
            ps.setString(4, ctSp.getIdDongSp().getId());
            ps.setInt(5, ctSp.getNamBh());
            ps.setString(6, ctSp.getMoTa());
            ps.setInt(7, ctSp.getSoLuongTon());
            ps.setDouble(8, ctSp.getGiaNhap());
            ps.setDouble(9, ctSp.getGiaBan());

            check = ps.executeUpdate();
            conn.close();
            return check > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean updateLstDb(Object oj, ChiTietSP ctSp) {
        String Update = "UPDATE dbo.ChiTietSP SET IdSP = ?, IdNsx = ?, IdMauSac = ?, IdDongSP = ?, NamBH = ?, MoTa = ?, SoLuongTon = ?, GiaNhap = ?, GiaBan = ? WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Update);
            ps.setString(1, ctSp.getIdSp().getId());
            ps.setString(2, ctSp.getIdNsx().getId());
            ps.setString(3, ctSp.getIdMauSac().getId());
            ps.setString(4, ctSp.getIdDongSp().getId());
            ps.setInt(5, ctSp.getNamBh());
            ps.setString(6, ctSp.getMoTa());
            ps.setInt(7, ctSp.getSoLuongTon());
            ps.setDouble(8, ctSp.getGiaNhap());
            ps.setDouble(9, ctSp.getGiaBan());
            ps.setString(10, (String) oj);

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
        String Delete = "DELETE dbo.ChiTietSP WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(Delete);
            ps.setString(1, (String) oj);

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ChiTietSP getObj(String id) {
        ChiTietSP ctSp = new ChiTietSP();

        String sql = "SELECT Id, IdSP, IdNsx, IdMauSac, IdDongSP, NamBH,  MoTa, SoLuongTon, GiaNhap, GiaBan FROM dbo.ChiTietSP WHERE Id = ?";

        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                ctSp.setId(rs.getString("Id"));

                SanPham sp = spRepo.getObj(rs.getString("IdSP"));
                ctSp.setIdSp(sp);

                NSX nsx = nsxRepo.getObj(rs.getString("IdNsx"));
                ctSp.setIdNsx(nsx);

                MauSac ms = msRepo.getObj(rs.getString("IdMauSac"));
                ctSp.setIdMauSac(ms);

                DongSP dongSp = dongSpRepo.getObj(rs.getString("IdDongSP"));
                ctSp.setIdDongSp(dongSp);

                ctSp.setNamBh(rs.getInt("NamBH"));
                ctSp.setMoTa(rs.getString("MoTa"));
                ctSp.setSoLuongTon(rs.getInt("SoLuongTon"));
                ctSp.setGiaNhap(rs.getDouble("GiaNhap"));
                ctSp.setGiaBan(rs.getDouble("GiaBan"));

            }

            conn.close();

        } catch (Exception e) {
        }

        return ctSp;

    }

}
