/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class SinhVien implements Serializable{
    private String hoTen;
    private double diem;
    private String nganh;
    private String hocLuc;
    private boolean thuong;
    private Date ngaySinh;
    private boolean gioiTinh;

    public SinhVien() {
    }

    public SinhVien(String hoTen, double diem, String nganh, String hocLuc, boolean thuong) {
        this.hoTen = hoTen;
        this.diem = diem;
        this.nganh = nganh;
        this.hocLuc = hocLuc;
        this.thuong = thuong;
    }

    public SinhVien(String hoTen, double diem, String nganh, String hocLuc, boolean thuong, Date ngaySinh, boolean gioiTinh) {
        this.hoTen = hoTen;
        this.diem = diem;
        this.nganh = nganh;
        this.hocLuc = hocLuc;
        this.thuong = thuong;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    public boolean isThuong() {
        return thuong;
    }

    public void setThuong(boolean thuong) {
        this.thuong = thuong;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }



    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public void setDate(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/YYYY");
        this.ngaySinh = sdf.parse(date);
    }
    
    public Date getdate(){
        
        return ngaySinh;
    }
    
    
}
