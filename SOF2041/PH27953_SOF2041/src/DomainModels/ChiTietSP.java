/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Admin
 */
public class ChiTietSP {
    private String id;
    private SanPham idSp;
    private NSX idNsx;
    private MauSac idMauSac;
    private DongSP idDongSp;
    private Integer namBh;
    private String moTa;
    private Integer soLuongTon;
    private double giaNhap;
    private double giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham idSp, NSX idNsx, MauSac idMauSac, DongSP idDongSp, Integer namBh, String moTa, Integer soLuongTon, double giaNhap, double giaBan) {
        this.id = id;
        this.idSp = idSp;
        this.idNsx = idNsx;
        this.idMauSac = idMauSac;
        this.idDongSp = idDongSp;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getIdSp() {
        return idSp;
    }

    public void setIdSp(SanPham idSp) {
        this.idSp = idSp;
    }

    public NSX getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(NSX idNsx) {
        this.idNsx = idNsx;
    }

    public MauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(MauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public DongSP getIdDongSp() {
        return idDongSp;
    }

    public void setIdDongSp(DongSP idDongSp) {
        this.idDongSp = idDongSp;
    }

    public Integer getNamBh() {
        return namBh;
    }

    public void setNamBh(Integer namBh) {
        this.namBh = namBh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "id=" + id + ", idSp=" + idSp + ", idNsx=" + idNsx + ", idMauSac=" + idMauSac + ", idDongSp=" + idDongSp + ", namBh=" + namBh + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

    
    
    
    
}
