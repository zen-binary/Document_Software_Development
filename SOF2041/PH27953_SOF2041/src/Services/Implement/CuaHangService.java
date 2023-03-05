/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.CuaHang;
import Services.ICuaHangService;
import ViewModels.CuaHangViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CuaHangService implements ICuaHangService {

    @Override
    public List<CuaHang> getLst() {
        return cuaHangRepo.getLstDb();
    }
    
    @Override
    public List<CuaHangViewModel> getLstView() {
        List<CuaHangViewModel> lst = new ArrayList<>();
        for (CuaHang ch : getLst()) {
            CuaHangViewModel chView = new CuaHangViewModel();

            chView.setId(ch.getId());
            chView.setMa(ch.getMa());
            chView.setTen(ch.getTen());
            chView.setDiaChi(ch.getDiaChi());
            chView.setThanhPho(ch.getThanhPho());
            chView.setQuocGia(ch.getQuocGia());

            lst.add(chView);
        }

        return lst;
    }

    @Override
    public boolean addLst(CuaHangViewModel chView) {
        CuaHang ch = new CuaHang();
        ch.setId(null);
        ch.setMa(chView.getMa());
        ch.setTen(chView.getTen());
        ch.setDiaChi(chView.getDiaChi());
        ch.setThanhPho(chView.getThanhPho());
        ch.setQuocGia(chView.getQuocGia());
        return cuaHangRepo.addLstDb(ch);
    }

    @Override
    public boolean updateLst(Object oj, CuaHangViewModel chView) {
        CuaHang ch = new CuaHang();
        ch.setId(null);
        ch.setMa(chView.getMa());
        ch.setTen(chView.getTen());
        ch.setDiaChi(chView.getDiaChi());
        ch.setThanhPho(chView.getThanhPho());
        ch.setQuocGia(chView.getQuocGia());
        return cuaHangRepo.updateLstDb((String) oj, ch);
        
    }

    @Override
    public boolean deleteLst(Object oj) {
        return cuaHangRepo.deleteLstDb((String) oj);
    }

    @Override
    public CuaHang getObj(String id) {
        return cuaHangRepo.getObj(id);
    }

    

}
