/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_CRUD_SINHVIEN_DOCGIFILE;

import java.util.List;

/**
 *
 * @author Dungna89
 */
public interface IStudentService {

  /*
    1. Phương thức trong interface không có body code
    2. Không được phép sử dụng private
    3. Các phương thử default mặc định là public
   */
  public String add(Student st);

  public String update(Student st);

  public String delete(int id);

  public List<Student> findST(String text);

  public List<Student> getLstStudent();
  public void fakeData();
  public int getMaxID();
  
  
  //Thêm chức năng lưu file đọc file ở Interface
  public String docFile();
  public String ghiFile();
}
