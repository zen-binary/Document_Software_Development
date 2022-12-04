/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Grade {
    
    private Integer id;
    private String maSv;
    private Integer tiengAnh;
    private Integer tinHoc;
    private Integer gdtc;

    public Grade() {
    }

    public Grade(Integer id, String maSv, Integer tiengAnh, Integer tinHoc, Integer gdtc) {
        this.id = id;
        this.maSv = maSv;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
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
    
    
    
    
}
