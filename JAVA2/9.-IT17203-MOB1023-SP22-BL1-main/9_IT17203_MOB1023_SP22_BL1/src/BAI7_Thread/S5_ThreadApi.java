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
public class S5_ThreadApi extends Thread {
 /*
        final String getName() Lấy ra tên của thread
        final int getPriority() Lấy ra thứ tự ưu tiên của thread
        final boolean isAlive() Kiểm tra 1 thread vẫn còn chạy hay không
        final void join() Chờ đến khi 1 thread ngừng hoạt động
        void run() Chạy một một thread
        static void sleep(long
        milliseconds)
        Tạm ngừng hoạt động của 1 thread với một khoảng
        thời gian là mili giây
        void start() Bắt đầu 1 thread bằng cách gọi run()
        
        THỨ TỰ ƯU TIÊN THREAD
        ❑Các hằng số biểu thị độ ưu tiên
        ❖NORM_PRIORITY 5
        ❖MAX_PRIORITY 10
        ❖MIN_PRIORITY 1
        ❑Giá trị mặc định cho thứ tự ưu tiên
        ❖NORM_PRIORITY
        ❑Đọc/ghi độ ưu tiên của Thread
        ❖final void setPriority(int p)
        ❖final int getPriority()
        ❑Trong trường hợp xảy ra tranh chấp tài nguyên
        thì thread có độ ưu tiên cao hơn sẽ thực hiện
         */
  @Override
  public void run() {
    int i = 0;
    while (true) {
      System.out.println(i++);
      try {
        Thread.sleep(1000);
        if (i == 15) {
          break;
        }
      } catch (Exception e) {
        break;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    S5_ThreadApi t1 = new S5_ThreadApi();
    t1.start();
    t1.join();//Join dược sử dụng để đợi một thread nào đó kết thúc
    //t2 sẽ phải đợi đến khi t1 kết thúc
    S5_ThreadApi t2 = new S5_ThreadApi();
    t2.start();

  }
}
