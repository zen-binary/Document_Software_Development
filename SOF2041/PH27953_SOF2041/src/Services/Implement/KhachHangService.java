/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.KhachHang;
import Services.IKhachHangService;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangService implements IKhachHangService {

    @Override
    public List<KhachHang> getLst() {
        return khRepo.getLstDb();
    }

    @Override
    public List<KhachHangViewModel> getLstView() {
        List<KhachHangViewModel> lst = new ArrayList<>();

        for (KhachHang kh : getLst()) {
            KhachHangViewModel khView = new KhachHangViewModel();
            khView.setMa(kh.getMa());
            khView.setTen(kh.getTen().trim());
            khView.setTenDem(kh.getTenDem().trim());
            khView.setHo(kh.getHo().trim());
            khView.setNgaySinh(kh.getNgaySinh());
            khView.setSdt(kh.getSdt());
            khView.setDiaChi(kh.getDiaChi());
            khView.setThanhPho(kh.getThanhPho());
            khView.setQuocGia(kh.getQuocGia());
            khView.setMatKhau(kh.getMatKhau());

            lst.add(khView);
        }

        return lst;
    }

    @Override
    public String addLst(KhachHangViewModel khView) {

        KhachHang kh = new KhachHang();
        kh.setId(null);
        kh.setMa(khView.getMa());
        kh.setTen(khView.getTen());
        kh.setTenDem(khView.getTenDem());
        kh.setHo(khView.getHo());
        kh.setNgaySinh(khView.getNgaySinh());
        kh.setSdt(khView.getSdt());
        kh.setDiaChi(khView.getDiaChi());
        kh.setThanhPho(khView.getThanhPho());
        kh.setQuocGia(khView.getQuocGia());
        kh.setMatKhau(khView.getMatKhau());

        if (khRepo.addLstDb(kh)) {
            return "Add ok";
        }

        return "Add Loi";
    }

    @Override
    public String updateLst(String id, KhachHangViewModel khView) {
        
        
        KhachHang kh = new KhachHang();
        kh.setId(null);
        kh.setMa(khView.getMa());
        kh.setTen(khView.getTen());
        kh.setTenDem(khView.getTenDem());
        kh.setHo(khView.getHo());
        kh.setNgaySinh(khView.getNgaySinh());
        kh.setSdt(khView.getSdt());
        kh.setDiaChi(khView.getDiaChi());
        kh.setThanhPho(khView.getThanhPho());
        kh.setQuocGia(khView.getQuocGia());
        kh.setMatKhau(khView.getMatKhau());

        if (khRepo.updateLstDb(id, kh)) {
            return "Update ok";
        }

        return "Update Loi";
    }

    @Override
    public String deleteLst(String id) {
      if (khRepo.deleteLstDb(id)) {
            return "Delete ok";
        }

        return "Delete Loi";
    }

    @Override
    public KhachHang getObj(String id) {
        return khRepo.getObj(id);
    }

}
