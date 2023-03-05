/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.HoaDonChiTiet;
import Services.IHoaDonChiTietService;
import ViewModels.HoaDonChiTietViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRervice implements IHoaDonChiTietService{

    @Override
    public List<HoaDonChiTiet> getLst() {
       return hdCtRepo.getLstDb();
    }

    @Override
    public List<HoaDonChiTietViewModel> getLstView() {
        List<HoaDonChiTietViewModel> lst = new ArrayList<>();
        for (HoaDonChiTiet hdCt : getLst()) {
            HoaDonChiTietViewModel hdCtView = new HoaDonChiTietViewModel();
            hdCtView.setIdHoaDon(hdCt.getIdHoaDon());
            hdCtView.setIdChiTietSp(hdCt.getIdChiTietSp());
            hdCtView.setDonGia(hdCt.getDonGia());
            hdCtView.setSoLuong(hdCt.getSoLuong());
            lst.add(hdCtView);
        }
        return lst;

    }

    @Override
    public String addLst(HoaDonChiTietViewModel hdCtView) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateLst(String id, HoaDonChiTietViewModel hdCtView) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String deleteLst(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonChiTiet getObj(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
