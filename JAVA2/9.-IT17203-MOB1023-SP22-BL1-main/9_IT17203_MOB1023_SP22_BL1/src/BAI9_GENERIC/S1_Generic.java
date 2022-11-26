/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI9_GENERIC;

/**
 *
 * @author Dungna89
 */
public class S1_Generic {

  /*
    Generics là một tính năng của Java giúp cho lập trình viên có thể chỉ định rõ kiểu dữ liệu 
    mà họ muốn làm việc với một class, một interface hay một phương thức nào đó.
    Đặt tên kiểu tham số là rất quan trọng để học Genericics. Nó không bắt buộc, 
    tuy nhiên chúng ta nên đặt theo quy ước chung để dễ đọc, dễ bảo trì. 
    Các kiểu tham số thông thường như sau:
   
    Một số quy ước đặt tên kiểu tham số Generic
    E- Element (phần tử – được sử dụng phổ biến trong Collection Framework)
    K – Key (khóa)
    V – Value (giá trị)
    N – Number (kiểu số: Integer, Double, Float, …)
    T – Type (Kiểu dữ liệu bất kỳ thuộc Wrapper class: String, Integer, Long, Float, …)
    S, U, V … – được sử dụng để đại diện cho các kiểu dữ liệu (Type) thứ 2, 3, 4, …
   */

  public static void main(String[] args) {
    //Khi nào dùng thì mới phải định nghĩa kiểu dữ liệu cho nó
    S1_ListDungna<String> lstDNA = new S1_ListDungna<>();
    lstDNA.setA("S1_Generic");
    System.out.println(lstDNA.getA());
    
    S1_ListDungna<Double> lstDNA2 = new S1_ListDungna<>();
    lstDNA2.setA(8.6);
    System.out.println(lstDNA2.getA());
    
    //Em ko thích tạo kiểu dữ liệu có được ko?
    S1_ListDungna lstDNA3 = new S1_ListDungna();
    lstDNA3.setA("Dungna");
    lstDNA3.setA(1);
    lstDNA3.setA(1.9);
  }
}
