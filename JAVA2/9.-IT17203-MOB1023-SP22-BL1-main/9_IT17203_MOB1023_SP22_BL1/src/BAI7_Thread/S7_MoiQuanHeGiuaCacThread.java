/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI7_Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungna29
 */
public class S7_MoiQuanHeGiuaCacThread {
    double tienTrongVi = 50000;
    public static void main(String[] args) {
        S7_MoiQuanHeGiuaCacThread funtion = new S7_MoiQuanHeGiuaCacThread();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    funtion.rutTien(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(S7_MoiQuanHeGiuaCacThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    funtion.napTien(40000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(S7_MoiQuanHeGiuaCacThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        t2.start();
        
    }
    synchronized void rutTien(double soTienRut) throws InterruptedException{
        System.out.println("Bạn đang rút tiền......");
        if (soTienRut  > tienTrongVi) {
            Thread.sleep(2000);
            System.out.println("Chia buồn với bạn không đủ tiền trong thẻ");
            wait();//
        }
        tienTrongVi -= soTienRut;
        System.out.println("Số tiền còn lại sau khi rút: " + tienTrongVi);
    }
    synchronized void napTien(double soTienNap) throws InterruptedException{
        System.out.println("Bạn đang nạp tiền.....");
        Thread.sleep(2000);
        tienTrongVi += soTienNap;
        Thread.sleep(2000);
        System.out.println("Tổng tiền sau khi nạp: " + tienTrongVi);
        notify();
    }
    
}
