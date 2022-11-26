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
public class F1 extends F0 {

  private String variable3;//Thuộc tính riêng của lớp con

  public F1() {
  }

  public F1(String variable3, String variable1, String variable2) {
    super(variable1, variable2);
    this.variable3 = variable3;
    //this: Tham chiếu đến thuộc tính và phương thức của lớp hiện tại
    //super: Tham chiếu đến thuộc tính và phương thức của lớp cha
    
  }

  public String getVariable3() {
    return variable3;
  }

  public void setVariable3(String variable3) {
    this.variable3 = variable3;
  }

  @Override
  public void method1(int a, double b) {
   //Lớp con được triển khai lại code ở đây
  }

  @Override
  public String method2(String a) {
    return super.method2(a); //To change body of generated methods, choose Tools | Templates.
  }
  
  
}
