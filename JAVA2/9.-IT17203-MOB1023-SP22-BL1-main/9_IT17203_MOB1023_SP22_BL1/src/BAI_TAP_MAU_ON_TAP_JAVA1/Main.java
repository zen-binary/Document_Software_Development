/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_ON_TAP_JAVA1;

import java.util.Scanner;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author Dungna89
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String choice;
    IStudentService iStudentService = new StudentService();
    do {
      System.out.println("Phần mềm FPOLY");
      System.out.println("1. Quản lý SV");
      System.out.println("2. Quản lý GV");
      System.out.println("3. Thoát");
      System.out.println("Mời bạn chọn chức năng: ");
      choice = sc.nextLine();
      switch (choice) {
        case "1":  
          do {
            System.out.println("QLSV");
            System.out.println("1.Thêm");
            System.out.println("2.Sửa");
            System.out.println("3.Xóa");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Xuất ds");
            System.out.println("6.Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            choice = sc.nextLine();
            switch (choice) {
              case "1":
                System.out.println(iStudentService.add());
                break;
              case "5":
               iStudentService.inDs();
                break;
              default:
                System.out.println("Chức năng không tồn tại");
            }
          } while (!choice.equals("6"));
          break;
        case "2":
          break;
        case "3":
          System.out.println("Chào tạm biệt");
          break;
        default:
          System.out.println("Chức năng không tồn tại");
      }
    } while (!choice.equals("3"));

  }
}
