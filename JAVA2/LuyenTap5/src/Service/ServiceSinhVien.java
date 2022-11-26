/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SinhVien;
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
public class ServiceSinhVien implements IService{
    
    ArrayList<SinhVien> _lst = new ArrayList<>();
    
    
    @Override
    public void addLst(SinhVien sv) {
        _lst.add(sv);
    }

    @Override
    public ArrayList<SinhVien> getLst() {
        return _lst;
    }

    @Override
    public void updateLst(int vt, SinhVien sv) {
        _lst.set(vt, sv);
    }

    @Override
    public void docFile(String file) {
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
           _lst = (ArrayList<SinhVien>) ois.readObject();
            
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
