/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import Reposetories.Implement.KhachHangRepository;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKhachHangService {

    public KhachHangRepository khRepo = new KhachHangRepository();

    public List<KhachHang> getLst();

    public List<KhachHangViewModel> getLstView();

    public String addLst(KhachHangViewModel khView);

    public String updateLst(String id, KhachHangViewModel khView);

    public String deleteLst(String id);
    
    public KhachHang getObj(String id);

}
