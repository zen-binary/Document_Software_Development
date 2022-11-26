/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_ON_TAP_JAVA1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dungna89
 */
//Nơi triển khai CRUD đối tượng
public class StudentService implements IStudentService {

  Scanner _sc = new Scanner(System.in);
  String _input;
  List<Student> _lstStudents;
  Student _student;
  Utilities _Utilities;

  public StudentService() {
    _lstStudents = new ArrayList<Student>();
    _Utilities = new Utilities();
    fakeData();
  }

  private void fakeData() {
    _lstStudents.add(new Student("DungnaPh01", "C#", 1, "Nguyễn Anh Dũng", "0123456"));
    _lstStudents.add(new Student("HoangnaPh02", "C#", 2, "Nguyễn Anh Hoàng", "0123456"));
    _lstStudents.add(new Student("DungnaPh03", "Java", 3, "Nguyễn Anh Dũng", "0123456"));
  }

  @Override
  public String add() {
    System.out.println("Mời bạn nhập sl: ");
    _input = _sc.nextLine();
    for (int i = 0; i < Integer.parseInt(_input); i++) {
      _student = new Student();
      _student.setId(getMaxID());
      System.out.println("Mời bạn nhập tên: ");
      _student.setTen(_sc.nextLine());
      System.out.println("Mời bạn nhập sdt: ");
      _student.setSdt(_sc.nextLine());
      _student.setMsv(_Utilities.zenMA(_student.getTen(), _student.getId()));

      System.out.println("Chọn ngành: ");
      System.out.println("1. JAVA");
      System.out.println("2. C#1");
      System.out.println("Mời bạn chọn ngành: ");
      var nganh = _sc.nextLine();
      _student.setNganhHoc(nganh == "1" ? "JAVA" : "C#");
      _lstStudents.add(_student);
    }
    return "Thêm thành công";
  }

  @Override
  public String update() {
    int temp = getIndexByID(Integer.parseInt(getInputValue("id")));
    if (temp == -1) {
      return "Không tìm thấy";
    }
    System.out.println("Mời bạn nhập tên: ");
    _lstStudents.get(temp).setTen(_sc.nextLine());
    System.out.println("Mời bạn nhập sdt: ");
    _lstStudents.get(temp).setSdt(_sc.nextLine());
    System.out.println("Chọn ngành: ");
    System.out.println("1. JAVA");
    System.out.println("2. C#1");
    System.out.println("Mời bạn chọn ngành: ");
    var nganh = _sc.nextLine();
    _lstStudents.get(temp).setNganhHoc(nganh == "1" ? "JAVA" : "C#");
    return "Sửa thành công";
  }

  @Override
  public String delete() {
    int temp = getIndexByID(Integer.parseInt(getInputValue("id")));
    if (temp == -1) {
      return "Không tìm thấy";
    }
    _lstStudents.remove(temp);
    return "Xóa thành công";
  }

  @Override
  public String find() {
    int temp = getIndexByID(Integer.parseInt(getInputValue("id")));
    if (temp == -1) {
      return "Không tìm thấy";
    }
    _lstStudents.get(temp).inRaManHinh();
    return "Đã tìm thấy";
  }

  @Override
  public void inDs() {

    for (Student x : _lstStudents) {
      x.inRaManHinh();
    }
  }

  public void timKiemGanDung() {
    System.out.println("Mời bạn nhập tên hoặc mã: ");
    var temp = _sc.nextLine();
    for (Student x : _lstStudents) {
      if (x.getTen().contains(temp)||x.getMsv().contains(temp)) {
        x.inRaManHinh();
      }
    }
  }

  private int getIndexByID(int ID) {
    for (int i = 0; i < _lstStudents.size(); i++) {
      if (ID == _lstStudents.get(i).getId()) {
        return i;
      }
    }
    return -1;
  }

  private String getInputValue(String msg) {
    System.out.printf("Mời bạn nhập %s:", msg);
    return _sc.nextLine();
  }

  private int getMaxID() {//Tìm ra khóa chính có số lớn nhất là
    if (_lstStudents.isEmpty()) {
      return 1;
    }
    int max = _lstStudents.get(0).getId();
    for (int i = 1; i < _lstStudents.size(); i++) {
      if (max < _lstStudents.get(i).getId()) {
        max = _lstStudents.get(i).getId();
      }
    }
    return max + 1;
  }
}
