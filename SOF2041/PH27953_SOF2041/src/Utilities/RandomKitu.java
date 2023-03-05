/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class RandomKitu {
    public static void main(String[] args) {
        System.out.println(randomStr());
    }
    public static String randomStr(){
        
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        sb.append(rd.nextInt());
        
        return sb.toString();
    }
}
