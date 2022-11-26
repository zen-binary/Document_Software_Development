/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServiceNhanVien implements IService{
    
    ArrayList<NhanVien> _lst = new ArrayList<>();
    
    
    @Override
    public void addLst(NhanVien nv) {
        _lst.add(nv);
        
    }

    @Override
    public ArrayList<NhanVien> getLst() {
        return _lst;
    }

    @Override
    public void updateLst(int vt, NhanVien nv) {
        _lst.set(vt, nv);
    }

    @Override
    public void deleteLst(int vt) {
        _lst.remove(vt);
    }

    @Override
    public void docFile(String file) {
        try {
            
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            _lst =  (ArrayList<NhanVien>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    @Override
    public void ghiFile(String file) {
        try {
            File f = new File(file);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(_lst);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
