/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Model.Grade;
import ViewModel.QuanLyDiemViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IQuanLyDiemSinhVienService {
    public ArrayList<QuanLyDiemViewModel> getLst();
    public String addLst(Grade g);
    public String deleteLst(String maSv);
    public String searchLst(String maSv);
    public String updateLst(String maSv, Grade g);
    public String getHoTen(String maSv);
    
}
