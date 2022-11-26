/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI8_ENUM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dungna89
 */
public class S5_Boxing_unBoxing {

  public static void main(String[] args) {
    //Quá trình boxing là đưa 1 giá trị vào trong một đối tượng
    //Quá trình unboxing là lấy 1 giá trị từ mootjd dối tượng ra
//        Integer objInt = new Integer(100);//Boxing
//        Integer objInt2 = 110;//Boxing
//        int a = objInt.intValue();//Unboxing
//        int x = Integer.valueOf(objInt);//Unboxing        
//        System.out.println("a = " + a);
//        System.out.println("x = " + x);
    
    List<Double> lst = new ArrayList<>();
    System.out.println("a" == "a");//True
    String a = "a", b = "a";
    System.out.println(a == b);//True
    System.out.println(a == "a");//True
    Scanner sc = new Scanner(System.in);
    String temp = sc.nextLine();
    System.out.println(temp.equals(a));//True
    System.out.println(temp== "a");//False
    if (temp == a) {
      System.out.println("Giống nhau");
    }
  }
}
