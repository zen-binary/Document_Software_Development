/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.lab5;

public class MainClass {
    public static void main(String[] args) {
        try {
            byte[] data = XFile.read("D:\\JAVA2\\file01.txt");
            XFile.write("file01.txt", data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
