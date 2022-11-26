/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI8_ENUM;

/**
 *
 * @author Dungna89
 */
public class S2_Enum2 {

  enum CacLoaiPhuongTien {
    //Vì bên trong có contructor vì vậy các phần tử này luôn là static final
    CAR(5), TRUCK(2);

    private int giaTri;

    //Constructor chỉ sử cho nội bộ của enum
    //Constructor luôn là private
    CacLoaiPhuongTien(int a) {
      this.giaTri = a;
    }
    //Viết 1 phương thức static method lấy ra các giá trị
    //CacLoaiPhuongTien Kiểu dữ liệu trả về Enum
    public static CacLoaiPhuongTien getValuePhuongTien(int value) {
      for (CacLoaiPhuongTien x : CacLoaiPhuongTien.values()) {
        if (x.giaTri == value) {
          return x;//Phương thức này chỉ trả ra 1 giá trị
        }
      }
      return null;
    }
  }
  enum CacLoaiPhuongTien1{
    
  }
  public static void main(String[] args) {
    //1. Hướng dẫn in edum + value
    for (CacLoaiPhuongTien x : CacLoaiPhuongTien.values()) {
      System.out.println(x + " = " + x.giaTri);
    }
    //2. Sử dụng phương thức static method enum
    CacLoaiPhuongTien c = CacLoaiPhuongTien.getValuePhuongTien(5);
    System.out.println("Giá trị 5 là của Enum = " + c);
    
    CacLoaiPhuongTien d;
    d = CacLoaiPhuongTien.TRUCK;//Phép gán giá trị cho 1 Enum
   
    CacLoaiPhuongTien1 d1;
    //d1 = CacLoaiPhuongTien.TRUCK;//Phép gán lỗi
  }
}
