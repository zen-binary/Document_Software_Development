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
public class F2 extends F1{
  private String variable4;

  public F2() {
  }

  public F2(String variable4, String variable3, String variable1, String variable2) {
    super(variable3, variable1, variable2);
    this.variable4 = variable4;
  }

  public String getVariable4() {
    return variable4;
  }

  public void setVariable4(String variable4) {
    this.variable4 = variable4;
  }

  @Override
  public String method2(String a) {
    return super.method2(a); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void method1(int a, double b) {
    super.method1(a, b); //To change body of generated methods, choose Tools | Templates.
  }
  
  
}
