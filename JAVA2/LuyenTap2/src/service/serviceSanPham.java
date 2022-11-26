/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Repositories.SanPhamRepositories;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class serviceSanPham implements IService{
     ArrayList<SanPham> _lst = new ArrayList<>();
     SanPhamRepositories Sprepo = new SanPhamRepositories();
    @Override
    public void addLst(SanPham sp) {
        Sprepo.Add(sp);
    }

    @Override
    public ArrayList<SanPham> getLst() {
        return Sprepo.getSP();
    }

    @Override
    public void updateLst(String ma, SanPham sp) {
           Sprepo.updateSp(ma, sp);
    }

    @Override
    public void deleteLst(int vt) {
        _lst.remove(vt);
    }

    @Override
    public void setLst(ArrayList<SanPham> ds) {
        _lst = ds;
    }
        
  
    
    
    
}
