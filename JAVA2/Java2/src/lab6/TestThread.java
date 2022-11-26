/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TestThread {
    public static void main(String[] args) {
        OddThread ot = new OddThread();
        EvenThread et = new EvenThread();
        
        Thread t1 = new Thread(ot);
        Thread t2 = new Thread(et);
        
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        t2.start();
    }
}
