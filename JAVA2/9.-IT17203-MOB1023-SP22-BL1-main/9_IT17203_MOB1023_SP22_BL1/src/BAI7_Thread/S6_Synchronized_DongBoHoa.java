/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI7_Thread;

/**
 *
 * @author Dungna89
 */
public class S6_Synchronized_DongBoHoa implements Runnable{

  @Override
  public synchronized void run() {
   int i = 0;
    while (true) {
      try {
        System.out.println(i++);
        Thread.sleep(1000);
          if (i == 10) {
              break;
              
          }
      } catch (InterruptedException ex) {
        break;
      }
    }
  }
  public static void main(String[] args) {
    //Hôm Sau làm ví dụ nốt về thằng này đang chưa đủ vì 2 luồng t1 và t2 đang chạy độc lập cần gộp luồng lại với nhau
    S6_Synchronized_DongBoHoa run = new S6_Synchronized_DongBoHoa();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.start();//
        t2.start();
  }
   /*
        ĐỒNG BỘ HÓA THREAD
        ❑Nếu nhiều thread đang hoạt động đồng thời mà
        sử dụng chung một tài nguyên nào đó thì sẽ xảy
        ra xung đột
        ❑Đồng bộ hóa chính là việc sắp xếp thứ tự các
        thread khi truy xuất vào cùng đối tượng sao cho
        không có sự xung đột dữ liệu.
        ❑Để đảm bảo rằng một nguồn tài nguyên chia sẻ
        được sử dụng bởi một thread tại một thời điểm,
        chúng ta sử dụng đồng bộ hóa
        (synchronization).
        */
  
}
