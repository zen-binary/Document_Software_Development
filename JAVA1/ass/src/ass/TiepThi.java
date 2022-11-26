package ass;

public class TiepThi extends NhanVien {

    private double doanhSo;
    private double hueHong;

    public TiepThi() {
    }


    public TiepThi( String maNv, String hoTen, double luong, double doanhSo, double hueHong) {
        super(maNv, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    
    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap()+(getHueHong()*getDoanhSo());
    }

    @Override
    public void xuatThongTin() {
        System.out.println("Tiep thi - "+"Ma: " + getMaNv() + " Ho Ten: " + getHoTen() + " Luong: " + getThuNhap() + " Thue: " + getThueTN() + " Doanh so: " + getDoanhSo()+ " Hue Hong: " + getHueHong()) ; 
    }
    
    
    
}
