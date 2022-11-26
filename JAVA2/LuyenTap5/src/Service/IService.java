/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.SinhVien;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IService {
    
    public void addLst(SinhVien sv);
    public ArrayList<SinhVien> getLst();
    public void updateLst(int vt, SinhVien sv);
    public void docFile(String file);
    public void ghiFile(String file);
    
    
    
}
