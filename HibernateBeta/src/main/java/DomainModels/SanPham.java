/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Gia")
    private double gia;
    @Column(name = "MoTa")
    private String moTa;
    
    @ManyToOne
    @JoinColumn(name = "IdLoai")
    private Loai idLoai;
    
    @ManyToMany
    @JoinTable(
            name = "SanPham_NSX",
            joinColumns = {@JoinColumn(name = "IdSP")},
            inverseJoinColumns = {@JoinColumn(name = "IdNSX")}
    )
    private Set<NSX> nsx;
    
    

    public SanPham() {
    }

    public SanPham(int id, String ma, String ten, double gia, String moTa, Loai idLoai, Set<NSX> nsx) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.idLoai = idLoai;
        this.nsx = nsx;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Loai getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(Loai idLoai) {
        this.idLoai = idLoai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", gia=" + gia + ", moTa=" + moTa + ", idLoai=" + idLoai + '}';
    }

    /**
     * @return the nsx
     */
    public Set<NSX> getNsx() {
        return nsx;
    }

    /**
     * @param nsx the nsx to set
     */
    public void setNsx(Set<NSX> nsx) {
        this.nsx = nsx;
    }
    
    
    
}
