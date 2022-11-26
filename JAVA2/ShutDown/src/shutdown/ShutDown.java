/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shutdown;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class ShutDown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       Runtime run = Runtime.getRuntime();
       Process proc = run.exec("shutdown -a");
    }
    
}
