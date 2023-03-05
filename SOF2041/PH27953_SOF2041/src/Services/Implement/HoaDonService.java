/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.HoaDon;
import Services.IHoaDonService;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService {

    @Override
    public List<HoaDon> getLst() {
        return hdRepo.getLstDb();
    }

    @Override
    public List<HoaDonViewModel> getLstView() {
        List<HoaDonViewModel> lst = new ArrayList<>();
        for (HoaDon hd : getLst()) {
            HoaDonViewModel hdView = new HoaDonViewModel();
            hdView.setIdKh(hd.getIdKh());
            hdView.setIdNv(hd.getIdNv());
            hdView.setMa(hd.getMa());
            hdView.setNgayNhan(hd.getNgayNhan());
            hdView.setNgayShip(hd.getNgayShip());
            hdView.setNgayTao(hd.getNgayTao());
            hdView.setNgayThanhToan(hd.getNgayThanhToan());
            hdView.setDiaChi(hd.getDiaChi());
            hdView.setSdt(hd.getSdt());
            hdView.setTenNguoiNhan(hd.getTenNguoiNhan());
            hdView.setTinhTrang(hd.getTinhTrang());

            lst.add(hdView);

        }

        return lst;

    }

    @Override
    public String addLst(HoaDonViewModel hdView) {
        //Validate
        
        HoaDon hd = new HoaDon();
        hd.setIdKh(hdView.getIdKh());
        hd.setIdNv(hdView.getIdNv());
        hd.setMa(hdView.getMa());
        hd.setNgayNhan(hdView.getNgayNhan());
        hd.setNgayShip(hdView.getNgayShip());
        hd.setNgayTao(hdView.getNgayTao());
        hd.setNgayThanhToan(hdView.getNgayThanhToan());
        hd.setDiaChi(hdView.getDiaChi());
        hd.setSdt(hdView.getSdt());
        hd.setTenNguoiNhan(hdView.getTenNguoiNhan());
        hd.setTinhTrang(hdView.getTinhTrang());
        if (hdRepo.addLstDb(hd)) {
            return "Add ok";
        }

        return "Add loi";
    }

    @Override
    public String updateLst(String id, HoaDonViewModel hdView) {
        HoaDon hd = new HoaDon();
        hd.setIdKh(hdView.getIdKh());
        hd.setIdNv(hdView.getIdNv());
        hd.setMa(hdView.getMa());
        hd.setNgayNhan(hdView.getNgayNhan());
        hd.setNgayShip(hdView.getNgayShip());
        hd.setNgayTao(hdView.getNgayTao());
        hd.setNgayThanhToan(hdView.getNgayThanhToan());
        hd.setDiaChi(hdView.getDiaChi());
        hd.setSdt(hdView.getSdt());
        hd.setTenNguoiNhan(hdView.getTenNguoiNhan());
        hd.setTinhTrang(hdView.getTinhTrang());
        if (hdRepo.updateLstDb(id, hd)) {
            return "Update ok";
        }
        
        return "Update ok";
    }

    @Override
    public String deleteLst(String id) {
         if (hdRepo.deleteLstDb(id)) {
            return "Delete ok";
        }
        
        return "Delete ok";
    }

    @Override
    public HoaDon getObj(String id) {
       return hdRepo.getObj(id);
    }

}
