/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_CRUD_SINHVIEN_DOCGIFILE;

import java.io.Serializable;



/**
 *
 * @author Dungna89
 */
public abstract class Person implements Serializable{//Lớp cha abstract
  private int id;
  private String ten;
  private String sdt;
  private int gioiTinh;//Thuộc tính bổ sung
  
  public Person() {
  }

  public Person(int id, String ten, String sdt, int gioiTinh) {
    this.id = id;
    this.ten = ten;
    this.sdt = sdt;
    this.gioiTinh = gioiTinh;
  }

  public int getGioiTinh() {
    return gioiTinh;
  }

  public void setGioiTinh(int gioiTinh) {
    this.gioiTinh = gioiTinh;
  }

  

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }
  
  public abstract void inRaManHinh();
}
