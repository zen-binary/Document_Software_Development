/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Model.Students;
import ViewModel.QuanLyDiemViewModel;
import ViewModel.QuanLySinhVienViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IQuanLySinhVienService {
    public ArrayList<QuanLySinhVienViewModel> getLst();
    public String addLst(Students s);
    public String updateLst(String maSv, Students s, int i);
    public String deleteLst(String maSv);
    public ArrayList<QuanLySinhVienViewModel> searchLst(String nameStr);
}
