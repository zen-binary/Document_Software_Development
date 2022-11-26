/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DongHo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class MyDongHo implements Runnable{
    
    JLabel txt;

    public MyDongHo() {
    }

    public MyDongHo(JLabel txt) {
        this.txt = txt;
    }
    
    
    @Override
    public void run() {
        while (true) {            
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        txt.setText(sdf.format(d));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    
    }
    
}
