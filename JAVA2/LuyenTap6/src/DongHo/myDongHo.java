/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DongHo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class myDongHo implements Runnable{
    
    JLabel txt;

    public myDongHo(JLabel txt) {
        this.txt = txt;
    }

    public myDongHo() {
    }
    
    

    @Override
    public void run() {
        try {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
            txt.setText(sdf.format(d));
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    
}
