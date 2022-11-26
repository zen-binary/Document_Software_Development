/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class MultiThreading implements Runnable{
    JLabel txt;

    public MultiThreading(JLabel txt) {
        this.txt = txt;
    }

    public MultiThreading() {
    }

    @Override
    public void run() {
        while (true) {            
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
            Date d = new Date();
            txt.setText(sdf.format(d));
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
     }
    
    
    
}
