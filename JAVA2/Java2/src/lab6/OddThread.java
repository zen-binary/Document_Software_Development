/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author Admin
 */
public class OddThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {

                System.out.print(" " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
        }

    }

}
