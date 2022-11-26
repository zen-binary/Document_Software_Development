/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IService {
    public void addLst(NhanVien nv);
    public ArrayList<NhanVien> getLst();
    public void updateLst(int vt, NhanVien nv);
    public void deleteLst(int vt);
    public String docFile(String file);
    public String ghiFile(String file);
    
}
