/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietSP;
import DomainModels.GioHangChiTiet;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import ViewModels.BanHangGioHangViewModel;
import ViewModels.BanHangHoaDonViewModel;
import ViewModels.BanHangSanPhamViewModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IBanHangService {

    public List<HoaDon> getLstHoaDon();

    public List<BanHangHoaDonViewModel> getLstHoaDonView();

    public List<ChiTietSP> getLstSanPham();

    public List<BanHangSanPhamViewModel> getLstSanPhamView();

    public List<GioHangChiTiet> getLstGioHang();

    public List<BanHangGioHangViewModel> getLstGioHangView(String IdHoaDon);

    public String updateThanhToan(String IdHoaDon);

    public String updateGioHang(String idKhHoaDon, String idCtSp);
    public String deleteGioHang(String idGioHang, String idCtSp);

    public List<BanHangSanPhamViewModel> timKiemSanPham(String name);
    
    
    public String addHoaDon();
}
