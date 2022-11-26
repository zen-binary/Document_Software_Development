
package baithi_ph27953;

public class SinhVien {
    
    private String maSv;
    private String hoTen;
    private String chuyenNganh;

    public SinhVien() {
    }

    public SinhVien(String maSv, String hoTen, String chuyenNganh) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.chuyenNganh = chuyenNganh;
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

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
    
    
    public void inThongTin(){
        System.out.println("Ma sv: " + getMaSv() + " Ho Ten: " + getHoTen() + " Chuyen nganh: " + getChuyenNganh());
    }
    
}
