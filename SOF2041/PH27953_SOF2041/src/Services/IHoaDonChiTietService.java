/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import Reposetories.IHoaDonChiTietReposetory;
import Reposetories.Implement.HoaDonChiTietReposetory;
import ViewModels.HoaDonChiTietViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonChiTietService {

    public IHoaDonChiTietReposetory hdCtRepo = new HoaDonChiTietReposetory();

    public List<HoaDonChiTiet> getLst();

    public List<HoaDonChiTietViewModel> getLstView();

    public String addLst(HoaDonChiTietViewModel hdCtView);

    public String updateLst(String id, HoaDonChiTietViewModel hdCtView);

    public String deleteLst(String id);
    
    public HoaDonChiTiet getObj(String id);

}
