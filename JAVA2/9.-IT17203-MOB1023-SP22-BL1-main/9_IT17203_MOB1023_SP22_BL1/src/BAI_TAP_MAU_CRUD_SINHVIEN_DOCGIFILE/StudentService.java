/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_CRUD_SINHVIEN_DOCGIFILE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

  }

  public void fakeData() {
    _lstStudents.add(new Student("DungnaPh01", "C#", 1, "Nguyễn Anh Dũng", "0123456", 0));
    _lstStudents.add(new Student("HoangnaPh02", "C#", 2, "Nguyễn Anh Hoàng", "0123456", 1));
    _lstStudents.add(new Student("DungnaPh03", "Java", 3, "Nguyễn Anh Dũng", "0123456", 1));
  }

  @Override
  public String add(Student st) {
    _lstStudents.add(st);
    return "Thêm thành công";
  }

  @Override
  public String update(Student st) {
    int temp = getIndexByID(st.getId());
    if (temp == -1) {
      return "Không tìm thấy";
    }
    _lstStudents.get(temp).setTen(st.getTen());
    _lstStudents.get(temp).setSdt(st.getSdt());
    _lstStudents.get(temp).setMsv(st.getMsv());
    _lstStudents.get(temp).setNganhHoc(st.getNganhHoc());
    return "Sửa thành công";
  }

  @Override
  public String delete(int id) {
    int temp = getIndexByID(id);
    if (temp == -1) {
      return "Không tìm thấy";
    }
    _lstStudents.remove(temp);
    return "Xóa thành công";
  }

  @Override
  public List<Student> findST(String text) {//Tìm kiếm gần đúng theo tên hoặc msv
    var lstTemp = new ArrayList<Student>();
    for (Student x : _lstStudents) {
      System.out.println(x.getMsv().toLowerCase().contains(text.toLowerCase()));
      if (x.getTen().toLowerCase().contains(text.toLowerCase()) || x.getMsv().toLowerCase().startsWith(text.toLowerCase())) {
        lstTemp.add(x);
      }
    }
    return lstTemp;
  }

  @Override
  public List<Student> getLstStudent() {
    return _lstStudents;
  }

  private int getIndexByID(int ID) {
    for (int i = 0; i < _lstStudents.size(); i++) {
      if (ID == _lstStudents.get(i).getId()) {
        return i;
      }
    }
    return -1;
  }

  public int getMaxID() {//Tìm ra khóa chính có số lớn nhất là
    if (_lstStudents.isEmpty()) {//Nếu danh sách rỗng sẽ trả ra id = 1 là id mặc định
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

  @Override
  public String docFile() {
    try {
      File file = new File("dataObject.txt");
      if (!file.exists()) {//Kiểm tra sự tồn tại của file
        return "File không tìm thấy";
      }
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);

      while (fis.available() > 0) {
        Student temp = (Student) ois.readObject();//Đọc 1 đối tượng lên gán cho biến temp
        //(Student)ois.readObject() Ép kiểu từ object về đối tượng sinh viên
        _lstStudents.add(temp);
      }
      ois.close();
      fis.close();
      return "Đọc thành công";
    } catch (Exception e) {
      return "Đọc thất bại";
    }
  }

  @Override
  public String ghiFile() {
    try {
      File file = new File("dataObject.txt");
      if (!file.exists()) {//Kiểm tra sự tồn tại của file
        file.createNewFile();//Tạo mới file
      }
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      for (Student x : _lstStudents) {
        oos.writeObject(x);
      }
      oos.close();
      fos.close();
      return "Lưu thành công";
    } catch (Exception e) {
      return "Lưu file thất bại";
    }
    
  }

}
