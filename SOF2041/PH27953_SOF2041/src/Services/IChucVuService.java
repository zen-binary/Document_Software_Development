/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import ViewModels.ChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IChucVuService {
    public List<ChucVu> getLst();
    public List<ChucVuViewModel> getLstView();
    public boolean addLst(ChucVuViewModel cvView);
    public boolean updateLst(Object oj,ChucVuViewModel cvView);
    public boolean deleteLst(Object oj);
    public ChucVu getObj(String id); 
    
}
