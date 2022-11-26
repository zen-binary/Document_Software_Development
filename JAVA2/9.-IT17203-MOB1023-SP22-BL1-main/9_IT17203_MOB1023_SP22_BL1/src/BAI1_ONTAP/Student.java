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
/*
Khi kế thừa 1 lớp abstract thì lớp con bắt buộc phải ghi đè lại các phương thức abstract của lớp cha còn các phương thức khác kế thừa hay không không quan trọng.
*/
public class Student extends Person {

  private String variable3;

  @Override
  public double method3(double a) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void method4(double a, int b) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  
}
