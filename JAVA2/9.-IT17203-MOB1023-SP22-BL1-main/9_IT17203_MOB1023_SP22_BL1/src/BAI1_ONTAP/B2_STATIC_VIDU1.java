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
public class B2_STATIC_VIDU1 {
  //Khối static
  static {
    System.out.println("Đây là khối static 1");
  }
  static {
    System.out.println("Đây là khối static 2");
  }

  public B2_STATIC_VIDU1() {
    System.out.println("Đã vào main");
  }
  public static void main(String[] args) {
    B2_STATIC_VIDU1 vd1 = new B2_STATIC_VIDU1();    
  }
}
