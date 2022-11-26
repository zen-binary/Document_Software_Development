/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI4_XuLyNgoaiLe;

/**
 *
 * @author Dungna89
 */
public class S2_CuPhapVaCachSuDung {

  /*
            ❑Mỗi khối try yêu cầu có ít nhất một khối catch
            hoặc/và duy nhất một khối finally.
            ❑Khối finally sẽ được thực hiện dù ngoại lệ có xuất
            hiện hay không.
        
            Các phương thức của lớp Exception
        STT	Phương thức và Miêu tả
        1 public String getMessage() Trả về một message cụ thể về exception đã xảy ra. Message này được khởi tạo bởi phương thức contructor của Throwable
        2 public Throwable getCause()Trả về nguyên nhân xảy ra exception biểu diễn bởi đối tượng Throwable
        3 public String toString()Trả về tên của lớp và kết hợp với kết quả từ phương thức getMessage()
        4 public void printStackTrace()In ra kết quả của phương thức toString cùng với stack trace đến System.err
        5 public StackTraceElement [] getStackTrace() Trả về một mảng chứa mỗi phần tử trên stack trace. Phần tử tại chỉ mục 0 biểu diễn phần trên cùng của Call Stack, và phần tử cuối cùng trong mảng biểu diễn phương thức tại dưới cùng của Call Stack
        6 public Throwable fillInStackTrace() Fills the stack trace of this Throwable object with the current stack trace, adding to any previous information in the stack trace.
   */
  public static void main(String[] args) {
    luuY();
  }

  static void CuPhaTryCatch() {
//    try {
//      //Code có thể ném ra ngoại lệ
//    } catch (Exception e) {
    //Code xử lý ngoại lệ
//    }
    try {
      int zero = 0, average = 10 / zero;
      System.out.println("Average" + average);
    } catch (Exception e) {
      System.out.println(e.toString());
      System.out.println("Thông báo lỗi: " + e.getMessage());
      e.printStackTrace();
    }
    System.out.println("Kế thúc được hàm");
  }

  static void Finally() {
    //       try {
    //    // code có thể ném ra ngoại lệ
    //} catch(Exception_class_Name_1 ex) {
    //    // code xử lý ngoại lệ 1
    //} catch(Exception_class_Name_2 ex) {
    //    // code xử lý ngoại lệ 2
    //} catch(Exception_class_Name_n ex) {
    //    // code xử lý ngoại lệ n
    //} finally {
    //    // code trong khối này luôn được thực thi
    //}

    String[] arr = {"1", "a", null};
    try {
      int a = Integer.parseInt(arr[0]);
      String temp = null;
      System.out.println(temp.length());
    } catch (NumberFormatException numberFormatException) {
      System.out.println("NumberFormatException");
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      System.out.println("ArrayIndexOutOfBoundsException");
    } catch (NullPointerException nullPointerException) {
      System.out.println("NullPointerException");
    } catch (Exception exception) {
      System.out.println("Exception");
    } finally {
      System.out.println("Chạy vào finally");
    }
    System.out.println("Phương thức chạy đến cuối");
  }
   /*
        Tại một thời điểm chỉ xảy ra một ngoại lệ và tại một thời điểm chỉ có một khối catch được thực thi. Khi exception đã bị bắt ở một catch thì các catch tiếp theo sẽ không được bắt.        
        Tất cả các khối catch phải được sắp xếp từ cụ thể nhất đến chung nhất (từ exception con đến exception cha), tức là phải khai báo khối lệnh catch để xử lý lỗi NullPointerException, ArithmeticException, … trước khi khai báo catch để xử lý lỗi Exception.        
        Khối lệnh finally luôn được thực thi dù chương trình có xảy ra ngoại lệ hay không (ngay cả sử dụng lệnh return).        
        Đối với mỗi khối try, có thể không có hoặc nhiều khối catch, nhưng chỉ có một khối finally.
        Khối finally sẽ không được thực thi nếu chương trình bị thoát bằng cách gọi System.exit() 
        hoặc xảy ra một lỗi (Error) không thể tránh khiến chương trình bị chết.
   */
  
  static void luuY(){
    String[] arr = {"1", "a", null};
    try {
      int a = Integer.parseInt(arr[0]);
      String temp = null;
      System.out.println(temp.length());
    } catch (NumberFormatException numberFormatException) {
      System.out.println("NumberFormatException");
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      System.out.println("ArrayIndexOutOfBoundsException");
    } catch (NullPointerException nullPointerException) {
      System.out.println("NullPointerException");
      //return;//Nếu có dùng return thì Finally vẫn được thực thi và các đoạn code nằm bên dưới cụm Try sẽ không thực thi
      System.exit(0);//Khối Finally sẽ không được thực thi
    } catch (Exception exception) {
      System.out.println("Exception");
    } finally {
      System.out.println("Chạy vào finally");
    }
    System.out.println("Phương thức chạy đến cuối");
  }
}