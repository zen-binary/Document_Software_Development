/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI7_Thread;

import javax.crypto.AEADBadTagException;

/**
 *
 * @author Dungna89
 */
public class S4_ThongTinThread extends Thread{
  public static void main(String[] args) {
    S4_ThongTinThread thread1 = new S4_ThongTinThread();
    thread1.start();
    Thread t2 = Thread.currentThread();
    System.out.println("Định danh thread: " + t2.getId());
    System.out.println("Tên thread: " + t2.getName());
    System.out.println("Độ ưu tiên thread: " + t2.getPriority());
    System.out.println("Trạng thái thread: " + t2.getState());
    System.out.println("Đang hoạt động: " + t2.isAlive());
    System.out.println("Số lượng thread: " + Thread.activeCount());
    
  }
}
