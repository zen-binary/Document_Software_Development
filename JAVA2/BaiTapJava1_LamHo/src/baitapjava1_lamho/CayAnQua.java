/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitapjava1_lamho;

/**
 *
 * @author Admin
 */
public class CayAnQua extends ThucVat {

    private int muaRaQua;

    public CayAnQua() {
    }

    public CayAnQua(int muaRaQua, String maTV, String ten, String khuVuc, int canNang) {
        super(maTV, ten, khuVuc, canNang);
        this.muaRaQua = muaRaQua;
    }

    public int getMuaRaQua() {
        return muaRaQua;
    }

    public void setMuaRaQua(int muaRaQua) {
        this.muaRaQua = muaRaQua;
    }
    public String getMua(){
        int mua = getMuaRaQua();
        return mua == 1 ? "Xuân": mua==2?"Hạ":mua==3?"Thu": mua==4?"Đông":"Mùa bạn nhập ko có";
    }

    @Override
    public void display() {
        System.out.println("Mã Tv: " + getMaTV() + " Tên: " + getTen() +
                " Khu vực: " + getKhuVuc() + " Cân nặng: " + getCanNang() + " Mùa Ra Quả: " + getMua());
    }

    
}
