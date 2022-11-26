package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.NhanVien;

public class ServiceNhanVien implements IServiceNV {

    private ArrayList<NhanVien> _lst;

    public ServiceNhanVien() {
        _lst = new ArrayList<>();

    }

    @Override
    public void addLst(NhanVien nv) {
        _lst.add(nv);
    }

    @Override
    public ArrayList<NhanVien> getLst() {
        return _lst;
    }

    @Override
    public void deleteLst(int vt) {
        _lst.remove(vt);
    }

    @Override
    public void updateLst(int vt, NhanVien nv) {
        _lst.set(vt, nv);
    }

    @Override
    public void setlst(ArrayList<NhanVien> lst) {
        _lst = lst;
    }

    @Override
    public String docFile(String file) {
        try {
            File f = new File(file);
            if (f.exists() == false) {
                return "Không tìm thấy File";
            }
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            _lst = (ArrayList<NhanVien>) ois.readObject();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "Đọc thành công";
    }

    @Override
    public String ghiFile(String file) {

        try {
            File f = new File(file);

            if (f.exists() == false) {
                f.createNewFile();
            }
            
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(_lst);
            
            fos.close();
            oos.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return "Ghi file thành công";
    }

}
