/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI7_Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dungna89
 */
public class S2_TaoThread extends Thread{

  @Override
  public void run() {
    int i = 0;
    while (true) {
      try {
        System.out.println(i++);
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        break;
      }
    }
  }
  
  public static void main(String[] args) {
    S2_TaoThread thread1 = new S2_TaoThread();//Khởi tạo 1 đối tượng
    thread1.start();//Khởi động thread
    S2_TaoThread thread2 = new S2_TaoThread();//Khởi tạo 1 đối tượng
    thread2.start();//Khởi động thread
  }
}
