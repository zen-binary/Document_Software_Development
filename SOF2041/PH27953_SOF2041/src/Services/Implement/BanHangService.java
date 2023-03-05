/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Reposetories.IChiTietSPReposetory;
import Reposetories.IGioHangChiTietReposetory;
import Reposetories.IGioHangReposetory;
import Reposetories.IHoaDonChiTietReposetory;
import Reposetories.IHoaDonReposetory;
import Reposetories.IKhachHangReposetory;
import Reposetories.INhanVienReposetory;
import Reposetories.Implement.ChiTietSPReposetory;
import Reposetories.Implement.GioHangChiTietReposetory;
import Reposetories.Implement.GioHangReposetory;
import Reposetories.Implement.HoaDonChiTietReposetory;
import Reposetories.Implement.HoaDonRepository;
import Reposetories.Implement.KhachHangRepository;
import Reposetories.Implement.NhanVienReposetory;
import Services.IBanHangService;
import Utilities.DbContext;
import ViewModels.BanHangGioHangViewModel;
import ViewModels.BanHangHoaDonViewModel;
import ViewModels.BanHangSanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class BanHangService implements IBanHangService {

    IHoaDonChiTietReposetory hdCtRepo = new HoaDonChiTietReposetory();
    IChiTietSPReposetory ctSPRepo = new ChiTietSPReposetory();
    IGioHangChiTietReposetory ghCtRepo = new GioHangChiTietReposetory();
    IHoaDonReposetory hdRepo = new HoaDonRepository();
    IGioHangReposetory ghRepo = new GioHangReposetory();

    @Override
    public List<HoaDon> getLstHoaDon() {
        return hdRepo.getLstDb();
    }

    @Override
    public List<BanHangHoaDonViewModel> getLstHoaDonView() {
        List<BanHangHoaDonViewModel> lst = new ArrayList<>();

        for (HoaDon hd : getLstHoaDon()) {
            BanHangHoaDonViewModel bhhdView = new BanHangHoaDonViewModel();
            
            bhhdView.setId(hd.getId());
            bhhdView.setMaHD(hd.getMa());
            bhhdView.setNgayTao(hd.getNgayTao());
            bhhdView.setTinhTrang(hd.getTinhTrang());
            bhhdView.setTenNV(hd.getIdNv().getTen());

            lst.add(bhhdView);
        }

        return lst;
    }

    @Override
    public List<ChiTietSP> getLstSanPham() {
        return ctSPRepo.getLstDb();
    }

    @Override
    public List<BanHangSanPhamViewModel> getLstSanPhamView() {
        List<BanHangSanPhamViewModel> lst = new ArrayList<>();
        for (ChiTietSP ctsp : getLstSanPham()) {
            BanHangSanPhamViewModel bhSpView = new BanHangSanPhamViewModel();
            bhSpView.setId(ctsp.getId());
            bhSpView.setMaSp(ctsp.getIdSp().getMa());
            bhSpView.setTenSp(ctsp.getIdSp().getTen());
            bhSpView.setNamBh(ctsp.getNamBh());
            bhSpView.setMoTa(ctsp.getMoTa());
            bhSpView.setSoLuongSp(ctsp.getSoLuongTon());
            bhSpView.setGiaNhap(ctsp.getGiaNhap());
            bhSpView.setGiaBan(ctsp.getGiaBan());

            lst.add(bhSpView);
        }

        return lst;
    }

    @Override
    public List<GioHangChiTiet> getLstGioHang() {
        return ghCtRepo.getLstDb();
    }

    @Override
    public List<BanHangGioHangViewModel> getLstGioHangView(String IdHoaDon) {
        List<BanHangGioHangViewModel> lst = new ArrayList<>();
        String idKhHoaDon = hdRepo.getObj(IdHoaDon).getIdKh().getId();
        System.out.println("Id Khach Hang Hoa Don: " + idKhHoaDon);
        for (GioHangChiTiet ghCt : getLstGioHang()) {

            if (ghCt.getIdGioHang().getIdKh().getId().equalsIgnoreCase(idKhHoaDon)) {

                BanHangGioHangViewModel bhghView = new BanHangGioHangViewModel();
                bhghView.setIdGioHang(ghCt.getIdGioHang().getId());
                bhghView.setIdCtSp(ghCt.getIdChiTietSp().getId());
                bhghView.setMaSp(ghCt.getIdChiTietSp().getIdSp().getMa());
                bhghView.setTenSp(ghCt.getIdChiTietSp().getIdSp().getTen());
                int sl = ghCt.getSoLuong();
                bhghView.setSoLuong(sl);
                double donGia = ghCt.getDonGia();
                bhghView.setDonGia(donGia);
                double thanhTien = sl * donGia;
                bhghView.setThanhTien(thanhTien);
                lst.add(bhghView);
            }
        }

        return lst;
    }

    @Override
    public String updateThanhToan(String IdHoaDon) {
        HoaDon hd = hdRepo.getObj(IdHoaDon);
        hd.setTinhTrang(0);
        if (hdRepo.updateLstDb(IdHoaDon, hd)) {
            return "Thanh toán Ok";
        }

        return "Thanh toan loi";
    }

    @Override
    public String updateGioHang(String idHoaDon, String idCtSp) {

        String idGioHangKh = "";
        String idKhHoaDon = hdRepo.getObj(idHoaDon).getIdKh().getId();
       
        
        
        for (GioHang gh : ghRepo.getLstDb()) {
            if (gh.getIdKh().getId().equalsIgnoreCase(idKhHoaDon)) {
                idGioHangKh = gh.getId();
            }
        }
        System.out.println("Id Gio Hang kh: " + idGioHangKh);

        GioHangChiTiet ghct = ghCtRepo.getObj(idGioHangKh, idCtSp);
        
        if (ghct.getIdGioHang() == null) {
            ChiTietSP ctSp = ctSPRepo.getObj(idCtSp);
            ghct.setSoLuong(1);
            ghct.setDonGia(ctSp.getGiaBan());
            ghct.setDonGiaKhiGiam(0);
            ghct.setIdGioHang(ghRepo.getObj(idGioHangKh));
            ghct.setIdChiTietSp(ctSp);
            if (ghCtRepo.addLstDb(ghct)) {
                return "Them sp new ok";
            }
        } else {

            ghct.setSoLuong(ghct.getSoLuong() + 1);
            if (ghCtRepo.updateLstDb(idGioHangKh, idCtSp, ghct)) {
                return "Thêm sl ok ";
            }
        }

        return "Them loi";
    }

    @Override
    public String deleteGioHang(String idGioHang, String idCtSp) {

        GioHangChiTiet ghct = ghCtRepo.getObj(idGioHang, idCtSp);
        

        if (ghct.getSoLuong() == 1) {
            if (ghCtRepo.deleteLstDb(idGioHang, idCtSp)) {
                return "delete ok ";
            }
        } else {

            ChiTietSP ctSp = ctSPRepo.getObj(idCtSp);
            ghct.setDonGia(ctSp.getGiaBan());
            ghct.setDonGiaKhiGiam(0);
            ghct.setIdGioHang(ghRepo.getObj(idGioHang));
            ghct.setIdChiTietSp(ctSPRepo.getObj(idCtSp));
            ghct.setSoLuong(ghct.getSoLuong() - 1);

            if (ghCtRepo.updateLstDb(idGioHang, idCtSp, ghct)) {
                return "bo sl ok ";
            }
        }

        return "Bo ok";
    }

    @Override
    public List<BanHangSanPhamViewModel> timKiemSanPham(String name) {
        List<BanHangSanPhamViewModel> lst = new ArrayList<>();

        for (BanHangSanPhamViewModel bhSpView : getLstSanPhamView()) {
            if (bhSpView.getTenSp().equalsIgnoreCase(name) || bhSpView.getMaSp().equalsIgnoreCase(name)) {
                lst.add(bhSpView);
            }

        }

        return lst;
    }

    @Override
    public String addHoaDon() {
        Random rd = new Random();
        IKhachHangReposetory khRepo = new KhachHangRepository();
        INhanVienReposetory nvRepo = new NhanVienReposetory();
        HoaDon hd = new HoaDon();
        hd.setIdKh(khRepo.getObj("1babf0b6-b1f9-4180-ba8f-f199baa04e2f"));
        hd.setIdNv(nvRepo.getObj("62466d58-6c20-46ea-bb66-abc247c50e76"));
        hd.setMa("HD"+rd.nextInt(100000));
        hd.setNgayTao(new Date());
        hd.setNgayShip(new Date());
        hd.setNgayThanhToan(new Date());
        hd.setNgayNhan(new Date());
        hd.setTinhTrang(1);
        hdRepo.addLstDb(hd);
        return "add ok";
        
    }
   

}
