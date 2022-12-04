/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.implement;

import Model.Users;
import Repositories.LoginRepository;
import Services.ILoginService;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LoginServiceImplement implements ILoginService{
    private LoginRepository loginRepo;

    public LoginServiceImplement() {
        loginRepo = new LoginRepository();
    }

    @Override
    public ArrayList<Users> getLstDb(String user, String pass) {
        return loginRepo.getLstUser(user, pass);
    }

    @Override
    public boolean checkLstDb(String user, String pass) {
        return loginRepo.checkUser(user, pass);
    }
    
    
}
