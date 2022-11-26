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
public class B2_STATIC {
  /*
  Từ khóa static trong Java được sử dụng chính để quản lý bộ nhớ. Chúng ta có thể áp dụng từ khóa static với các biến, các phương thức, các khối, các lớp lồng nhau(nested class). Từ khóa static thuộc về lớp chứ không thuộc về instance(thể hiện) của lớp.

Trong java, Static có thể là:

Biến static: Khi bạn khai báo một biến là static, thì biến đó được gọi là biến tĩnh, hay biến static.
Phương thức static: Khi bạn khai báo một phương thức là static, thì phương thức đó gọi là phương thức static.
Khối static: Được sử dụng để khởi tạo thành viên dữ liệu static.
   */
  public static void main(String[] args) {
    B2_STATIC b2 = new B2_STATIC();
    b2.method1();
   
    //method1();
   
    //Khi gọi trực tiếp phương thức static thì phải cùng là static thì mới gọi được hoặc phải khởi tạo lớp để gọi
  }
  void method1(){
    
  }
}
