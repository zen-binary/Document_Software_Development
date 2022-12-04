/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Admin
 */
public class QuanLyDiemViewModel {
    private String maSv;
    private String hoTen;
    private Integer tiengAnh;
    private Integer tinHoc;
    private Integer gdtc;
    private double avg;

    public QuanLyDiemViewModel() {
    }

    public QuanLyDiemViewModel(String maSv, String hoTen, Integer tiengAnh, Integer tinHoc, Integer gdtc, double avg) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
        this.avg = avg;
    }
    
    

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(Integer tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public Integer getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(Integer tinHoc) {
        this.tinHoc = tinHoc;
    }

    public Integer getGdtc() {
        return gdtc;
    }

    public void setGdtc(Integer gdtc) {
        this.gdtc = gdtc;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return maSv;
    }
    
    
    
    
    
}
