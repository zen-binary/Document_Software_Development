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
    private ArrayList<NhanVien> _lst = new ArrayList<>();
    
    
    @Override
    public void addLst(NhanVien nv) {
       _lst.add(nv);
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
    public String docFile(String file) {
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            _lst = (ArrayList<NhanVien>) ois.readObject();
            ois.close();
            fis.close();
            return "Đọc Thành Công";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Đọc thất bại";
    }

    @Override
    public String ghiFile(String file) {
        try {
            File f = new File(file);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(_lst);
            
            
            oos.close();
            fos.close();
            return "Ghi Thành Công";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ghi Thất Bại";
    }

    @Override
    public ArrayList<NhanVien> getLst() {
        return _lst;
    }
    
}
