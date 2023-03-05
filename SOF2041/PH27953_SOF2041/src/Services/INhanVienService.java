/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import Reposetories.Implement.NhanVienReposetory;
import ViewModels.NhanVienViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhanVienService {

    public NhanVienReposetory nvRepo = new NhanVienReposetory();

    public List<NhanVien> getLst();

    public List<NhanVienViewModel> getLstView();

    public String addLst(NhanVienViewModel nvView);

    public String updateLst(Object oj, NhanVienViewModel nvView);

    public String deleteLst(Object oj);
    
    public NhanVien getObj(String id);

}
