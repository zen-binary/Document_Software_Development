/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Model.Users;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ILoginService {
    public ArrayList<Users> getLstDb(String user, String pass);
    public boolean checkLstDb(String user, String pass);
}
