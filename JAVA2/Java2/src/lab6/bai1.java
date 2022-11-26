/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author Admin
 */
public class bai1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
    
}
