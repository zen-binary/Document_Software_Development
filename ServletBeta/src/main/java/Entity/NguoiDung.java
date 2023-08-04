package Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "NguoiDung")
public class NguoiDung {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne()
    @JoinColumn(name = "IdCV")
    ChucVu idCV;
    @Column(name = "Ma")
    String ma;
    @Column(name = "Ten")
    String ten;
    @Column(name = "GioiTinh")
    Integer gioiTinh;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    Date ngaySinh;
    @Column(name = "DiaChi")
    String diaChi;
    @Column(name = "ThanhPho")
    String thanhPho;
    @Column(name = "MatKhau")
    String matKhau;

    public NguoiDung() {
    }

    public NguoiDung(Integer id, ChucVu idCV, String ma, String ten, Integer gioiTinh, Date ngaySinh, String diaChi, String thanhPho, String matKhau) {
        this.id = id;
        this.idCV = idCV;
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.matKhau = matKhau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChucVu getIdCV() {
        return idCV;
    }

    public void setIdCV(ChucVu idCV) {
        this.idCV = idCV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
