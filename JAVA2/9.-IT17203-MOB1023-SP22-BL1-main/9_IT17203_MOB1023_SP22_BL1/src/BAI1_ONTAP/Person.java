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

//abstract Class thì sẽ là 1 lớp cha hoàn toàn bình thường nhưng phải có sử dụng phương thức abstract
public abstract class Person {//Lớp cha

  private String variable1;
  private String variable2;

  public Person() {
  }

  public Person(String variable1, String variable2) {
    this.variable1 = variable1;
    this.variable2 = variable2;
  }

  public String getVariable1() {
    return variable1;
  }

  public void setVariable1(String variable1) {
    this.variable1 = variable1;
  }

  public String getVariable2() {
    return variable2;
  }

  public void setVariable2(String variable2) {
    this.variable2 = variable2;
  }

  public void method1(int a, double b) {

  }

  public String method2(String a) {
    return null;
  }
  
  //Phương thức abstract không có body code
  public abstract double method3(double a);
  public abstract void method4(double a,int b);
}
