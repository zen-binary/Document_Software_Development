/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Model.Users;
import Utilities.DbContext;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class LoginRepository {
    
    
    public ArrayList<Users> getLstUser(String userName, String passWork){
        ArrayList<Users> lst = new ArrayList<>();
        String sql = "SELECT UserName, PassWord, Role FROM dbo.Users WHERE UserName = ? AND PassWord = ?";
        
        try {
            
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWork);
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {                
                    String user = rs.getString("UserName");
                    String pass = rs.getString("PassWord");
                    String role = rs.getString("Role");
                    Users u = new Users(user, pass, role);
                    lst.add(u);
                    System.out.println("Truy vấn thành công");
                   
            }
            conn.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    
    public boolean checkUser(String user, String pass){
        
        String sql = "SELECT UserName, PassWord, Role FROM dbo.Users WHERE UserName = ? AND PassWord = ?";
        
        boolean check = false;
        try {
            Connection conn = DbContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Không ok");
            e.printStackTrace();
        }
        return check;
    }
    
    
}
