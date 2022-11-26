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
public class S3_TaoThread_ThongQuaInterface implements Runnable{

  @Override
  public void run() {
    int i = 0;
    while (true) {
      try {
        System.out.println(i++);
        Thread.sleep(3000);
      } catch (InterruptedException ex) {
        break;
      }
    }
  }
  public static void main(String[] args) {
    S3_TaoThread_ThongQuaInterface s3 = new S3_TaoThread_ThongQuaInterface();
    Thread thread1 = new Thread(s3);
    thread1.start();
    Thread thread2 = new Thread(new S3_TaoThread_ThongQuaInterface());
    thread2.start();
  }
}
