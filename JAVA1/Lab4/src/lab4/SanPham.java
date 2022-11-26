package lab4;

public class SanPham {

    private String tenSp;
    private double donGia;
    private double giamGia;

    public SanPham() {
    }

    public SanPham(String tenSp, double donGia, double giamGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    public SanPham(String tenSp, double donGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
    }
    

    public String getTenSp() {
        return tenSp;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double thueNhapKhau() {
        double thue;
        thue = getDonGia() * 0.1;
        return thue;
    }

    public void inRaManHinh() {
        System.out.println("Ten Sp: "+ getTenSp());
        System.out.println("Don gia: "+ getDonGia());
        System.out.println("Giam gia: " + getGiamGia());
        System.out.println("Theu nhap khau: "+ thueNhapKhau());
        
    }
}
