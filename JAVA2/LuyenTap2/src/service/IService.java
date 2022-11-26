/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author Admin
 */
public interface IService {
    
    public void addLst(SanPham sp);
    public ArrayList<SanPham> getLst();
    public void updateLst(String ma, SanPham sp);
    public void deleteLst(int vt);
    public void setLst(ArrayList<SanPham> ds);
}
