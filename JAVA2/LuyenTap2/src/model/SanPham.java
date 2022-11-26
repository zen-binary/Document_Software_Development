/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class SanPham implements Serializable{
    private String tenSp;
    private String maSp;
    private String doanhMuc;
    private boolean tinhTrang;
    private double donGia;
    private String ngaySx;

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getDoanhMuc() {
        return doanhMuc;
    }

    public void setDoanhMuc(String doanhMuc) {
        this.doanhMuc = doanhMuc;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getNgaySx() {
        return ngaySx;
    }

    public void setNgaySx(String ngaySx) {
        this.ngaySx = ngaySx;
    }

    public SanPham(String tenSp, String maSp, String doanhMuc, boolean tinhTrang, double donGia, String ngaySx) {
        this.tenSp = tenSp;
        this.maSp = maSp;
        this.doanhMuc = doanhMuc;
        this.tinhTrang = tinhTrang;
        this.donGia = donGia;
        this.ngaySx = ngaySx;
    }

    public SanPham() {
    }
    
}
