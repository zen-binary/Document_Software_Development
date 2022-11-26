/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_ON_TAP_JAVA1;

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
  public String add();
  public String update();
  public String delete();
  public String find();
  public void inDs();
}
