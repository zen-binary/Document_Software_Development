/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MultiThreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyThread mt1 = new MyThread("Thread 1");
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(new MyThread("Thread 2"));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
           
        }
        t2.start();
    }
    
}
