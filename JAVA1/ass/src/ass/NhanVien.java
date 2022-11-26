package ass;

public class NhanVien {

    private String maNv;
    private String hoTen;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String maNv, String hoTen, double luong) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    
    public String getMaNv() {
        return maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public double getThueTN() {
        double thue;
        if (getLuong() < 9000) {
            thue = 0;
        } else if (getLuong() >= 9000 && getLuong() < 15000) {
            thue = getLuong() * 0.1;
        } else {
            thue = getLuong() * 0.12;
        }
        return thue;
    }

    public double getThuNhap() {
        return getLuong() - getThueTN();
    }

    public void xuatThongTin() {
        System.out.println("Nhan vien - "+"Ma: " + getMaNv() + " Ho Ten: " + getHoTen() + " Luong: " + getThuNhap() + " Thue: " + getThueTN());
    }
}
