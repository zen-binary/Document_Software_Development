/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public interface IServiceNV {
    public void addLst(NhanVien nv);
    public ArrayList<NhanVien> getLst();
    public void deleteLst(int vt);
    public void updateLst(int vt, NhanVien nv);
    public void setlst(ArrayList<NhanVien> lst);
    public String docFile(String file);
    public String ghiFile(String file);
}
