/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI1_ONTAP;

/**
 *
 * @author Dungna89
 */
public class B2_STATIC_VIDU2 {
  //private int count = 0;
  private static int count = 0;//Biến static chỉ được khởi tạo 1 lần duy nhất có thể bị thay đổi giá trị
  public static void main(String[] args) {
    B2_STATIC_VIDU2 sv1 = new B2_STATIC_VIDU2();
    sv1.demSoSV();
    B2_STATIC_VIDU2 sv2 = new B2_STATIC_VIDU2();
    sv2.demSoSV();
    B2_STATIC_VIDU2 sv3 = new B2_STATIC_VIDU2();
    sv3.demSoSV();
  }
  void demSoSV(){
    count++;
    inRa();
  }
  void inRa(){
    System.out.println("Đây là sv số: " + count);
  }
}
