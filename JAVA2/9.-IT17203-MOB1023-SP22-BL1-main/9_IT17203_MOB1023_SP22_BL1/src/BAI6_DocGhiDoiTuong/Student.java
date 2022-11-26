/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI6_DocGhiDoiTuong;


import java.io.Serializable;



/**
 *
 * @author Dungna89
 */
//implements Serializable Giúp trong quá trình ghi vào file các thuộc tính và đối tượng sắp được sắp xếp thứ tự và không xáo trộn dữ liệu
public class Student extends Person implements Serializable{
  private String msv;
  private String nganhHoc;
  
  public Student() {
  }

  public Student(String msv, String nganhHoc, int id, String ten, String sdt, int gioiTinh) {
    super(id, ten, sdt, gioiTinh);
    this.msv = msv;
    this.nganhHoc = nganhHoc;
  }
  public String getMsv() {
    return msv;
  }

  public void setMsv(String msv) {
    this.msv = msv;
  }

  public String getNganhHoc() {
    return nganhHoc;
  }

  public void setNganhHoc(String nganhHoc) {
    this.nganhHoc = nganhHoc;
  }

  @Override
  public void inRaManHinh() {
    System.out.printf("ID: %d | Tên: %s | Sđt: %s | Msv: %s | Ngành: %s \n",getId(),getTen(),getSdt(),getMsv(),getNganhHoc());
  }
  
}
