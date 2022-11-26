
package ass;

public class TruongPhong extends NhanVien {
    private double trachNhiem;

    public TruongPhong() {
    }


    public TruongPhong( String maNv, String hoTen, double luong,double trachNhiem) {
        super(maNv, hoTen, luong);
        this.trachNhiem = trachNhiem;
    }
    
    public double getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem(double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }
    
    @Override
    public double getThuNhap() {
        return super.getThuNhap() + getTrachNhiem();
    }

    @Override
    public void xuatThongTin() {
        System.out.println("Truong phong - "+"Ma NV: " + getMaNv() + " Ho Ten: " + getHoTen() + " Luong: " + getThuNhap() + " Thue: " + getThueTN() + " Trach nhiem: " + getTrachNhiem()) ; 
    }

    
    
    
    
    
}
