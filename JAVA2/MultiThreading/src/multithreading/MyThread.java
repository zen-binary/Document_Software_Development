/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MyThread implements Runnable{
    private int count = 0;
    private String name;

    public MyThread() {
    }

    public MyThread(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public void run() {
        while (true) {            
            count++;
            System.out.println("Name: " + name +" " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}
