/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MoWeb;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class web {

    public static void main(String[] args) throws IOException {
        Runtime run = Runtime.getRuntime();

        String url = "https://www.facebook.com/";

        run.exec("rundll32 url.dll, FileProtocolHandler " + url);
        
    }

}
