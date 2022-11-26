/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI4_XuLyNgoaiLe;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dungna89
 */
public class S3_ThrowVaThows {
   /*
        Từ khoá throw trong java được sử dụng để ném ra một ngoại lệ (exception) cụ thể.        
        throw được sử dụng để phát sinh một ngoại lệ throw new RuntimeException(“Lỗi”);
        
        throws được sử dụng để quăng ngoại lệ ra ngoài
        phương thức. Ngoại lệ sẽ được xử lý khi gọi phương thức
        ❖void method() throws FileNotFoundException{…}
        
        Từ khóa throws trong java được sử dụng để khai báo một ngoại lệ. 
        Nó thể hiện thông tin cho lập trình viên rằng có thể xảy ra một ngoại lệ, 
        vì vậy nó là tốt hơn cho các lập trình viên để cung cấp các mã xử lý ngoại lệ để duy trì luồng 
        bình thường của chương trình.
   */
  public static void main(String[] args) {
    try {
      kiemTraTuoiLayVo(17);
      method1Dungna();
    } catch (IOException ex) {
      Logger.getLogger(S3_ThrowVaThows.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  static void kiemTraTuoiLayVo(int tuoi){
    if (tuoi < 18) {
      throw new NumberFormatException("Bạn chưa đủ tuổi lấy vợ");
    }else{
      System.out.println("Bạn đã được phép lấy vợ");
    }
  }
  static void method1Dungna()throws IOException{
    throw new IOException("Lỗi rồi");
  }
  
}
