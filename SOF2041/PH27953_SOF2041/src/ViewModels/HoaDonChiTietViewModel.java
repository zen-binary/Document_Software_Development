/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietViewModel {
    private HoaDon idHoaDon;
    private ChiTietSP idChiTietSp;
    private Integer soLuong;
    private Double donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(HoaDon idHoaDon, ChiTietSP idChiTietSp, Integer soLuong, Double donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public ChiTietSP getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(ChiTietSP idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    
    
    
}
