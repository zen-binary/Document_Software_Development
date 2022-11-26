
package baithi_ph27953;


public class SinhVienPoly extends SinhVien{
    private int chuyenNganhHep;

    public SinhVienPoly() {
    }

    public SinhVienPoly(String maSv, String hoTen, String chuyenNganh, int chuyenNganhHep) {
        super(maSv, hoTen, chuyenNganh);
        this.chuyenNganhHep = chuyenNganhHep;
    }

    public int getChuyenNganhHep() {
        return chuyenNganhHep;
    }

    public void setChuyenNganhHep(int chuyenNganhHep) {
        this.chuyenNganhHep = chuyenNganhHep;
    }
    
    public String checkChuyenNganh(){
        if (getChuyenNganhHep()== 1) {
            return "java";
        }
        return "C#";
    }

    @Override
    public void inThongTin() {
        System.out.println("Ma sv: " + getMaSv() + " Ho Ten: " + getHoTen() + " Chuyen nganh: " + getChuyenNganh() +" Chuyen nganh hep: "+ checkChuyenNganh());
    }
    
    
}
