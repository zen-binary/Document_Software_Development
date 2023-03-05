/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class BanHangGioHangViewModel {
    private String idGioHang;
    private String idCtSp;
    private String maSp;
    private String tenSp;
    private Integer soLuong;
    private Double donGia;
    private Double thanhTien;

    public BanHangGioHangViewModel() {
    }

    public BanHangGioHangViewModel(String idGioHang, String idCtSp, String maSp, String tenSp, Integer soLuong, Double donGia, Double thanhTien) {
        this.idGioHang = idGioHang;
        this.idCtSp = idCtSp;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdCtSp() {
        return idCtSp;
    }

    public void setIdCtSp(String idCtSp) {
        this.idCtSp = idCtSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    
    
    
    
}
