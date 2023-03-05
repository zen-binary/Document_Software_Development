/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import Reposetories.IHoaDonReposetory;
import Reposetories.Implement.HoaDonRepository;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonService {

    public IHoaDonReposetory hdRepo = new HoaDonRepository();

    public List<HoaDon> getLst();

    public List<HoaDonViewModel> getLstView();

    public String addLst(HoaDonViewModel hdView);

    public String updateLst(String id, HoaDonViewModel hdView);

    public String deleteLst(String id);
    
    public HoaDon getObj(String id);

}
