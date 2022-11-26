/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI6_DocGhiDoiTuong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dungna89
 */
public class S1_DocGhiDoiTuong {
  public static void main(String[] args) {
    try {
      ghiFile();
      docFile();
    } catch (Exception e) {
    }
  }
  
  static void ghiFile() throws IOException{
    //Check file tồn tại nếu không có sẽ tiền hành tạo file
    File file = new File("dataObject.txt");
    if (!file.exists()) {//Kiểm tra sự tồn tại của file
      file.createNewFile();//Tạo mới file
    }
     List<Student> _lstStudents = new ArrayList<Student>();
    _lstStudents.add(new Student("DungnaPh01", "C#", 1, "Nguyễn Anh Dũng", "0123456", 0));
    _lstStudents.add(new Student("HoangnaPh02", "C#", 2, "Nguyễn Anh Hoàng", "0123456", 1));
    _lstStudents.add(new Student("DungnaPh03", "Java", 3, "Nguyễn Anh Dũng", "0123456", 1));
    
     FileOutputStream fos = new FileOutputStream(file);
     ObjectOutputStream oos = new ObjectOutputStream(fos);
     for (Student x : _lstStudents) {
      oos.writeObject(x);
    }
     oos.close();
     fos.close();
  }
  static void docFile() throws FileNotFoundException, IOException, ClassNotFoundException{
    File file = new File("dataObject.txt");
    if (!file.exists()) {//Kiểm tra sự tồn tại của file
      System.out.println("File này không tìm thấy");
      return;
    }
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);
    List<Student> lstNew = new ArrayList<>();
    while (fis.available() > 0) {
      Student temp = (Student)ois.readObject();//Đọc 1 đối tượng lên gán cho biến temp
     //(Student)ois.readObject() Ép kiểu từ object về đối tượng sinh viên
      lstNew.add(temp);
    }
    ois.close();
    fis.close();
    //Muốn kiểm tra xem đã đọc được hay chưa
    for (Student x : lstNew) {
      x.inRaManHinh();
    }
  }
  
}
