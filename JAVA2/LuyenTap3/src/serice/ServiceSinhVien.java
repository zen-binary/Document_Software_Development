
package serice;

import java.util.ArrayList;
import model.SinhVien;

public class ServiceSinhVien {
    
    ArrayList<SinhVien> lst ;

    public ServiceSinhVien() {
        lst = new ArrayList<>();
    }
    
    public void addLst(SinhVien sv){
        lst.add(sv);
    }
    
    public ArrayList<SinhVien> getLst(){
        return lst;
    }
    
    public void updateLst(int vt, SinhVien sv){
        lst.set(vt, sv);
    }
    
    public void deleteLst(int vt){
        lst.remove(vt);
    }
}
