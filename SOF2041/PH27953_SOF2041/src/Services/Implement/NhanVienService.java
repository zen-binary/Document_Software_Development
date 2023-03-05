/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Reposetories.Implement.ChucVuRepository;
import Reposetories.Implement.CuaHangRepository;
import Services.INhanVienService;
import ViewModels.NhanVienViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienService implements INhanVienService {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    @Override
    public List<NhanVien> getLst() {
        return nvRepo.getLstDb();
    }

    @Override
    public List<NhanVienViewModel> getLstView() {
        List<NhanVienViewModel> lst = new ArrayList<>();
        ChucVuRepository cvRepo = new ChucVuRepository();
        CuaHangRepository chRepo = new CuaHangRepository();
        for (NhanVien nv : getLst()) {
            NhanVienViewModel nvView = new NhanVienViewModel();

            nvView.setMa(nv.getMa());
            nvView.setTen(nv.getTen().trim());
            nvView.setTenDem(nv.getTenDem().trim());
            nvView.setHo(nv.getHo().trim());
            nvView.setGioiTinh(nv.getGioiTinh());
            nvView.setNgaySinh(nv.getNgaySinh());
            nvView.setDiaChi(nv.getDiaChi());
            nvView.setSdt(nv.getSdt());
            nvView.setMatKhau(nv.getMatKhau());

            nvView.setIdCh(nv.getIdCh());
            nvView.setIdCv(nv.getIdCv());
            
            nvView.setIdGuiBc(nv.getIdGuiBc());
            nvView.setTrangThai(nv.getTrangThai());

            lst.add(nvView);
        }

        return lst;
    }

    @Override
    public String addLst(NhanVienViewModel nvView) {
        if (nvView.getMa().isEmpty() || nvView.getTen().isEmpty() || nvView.getTenDem().isEmpty() ||
                nvView.getHo().isEmpty() || nvView.getDiaChi().isEmpty() || nvView.getSdt().isEmpty() || 
                nvView.getMatKhau().isEmpty() ) {
            return "Khong duoc de rong";
        }
        try {
            sdf.format(nvView.getNgaySinh());
        } catch (Exception e) {
            return "Vui long nhap ngay sinh dung dinh dang dd/mm/yyyy";
            
        }

        
        NhanVien nv = new NhanVien();
        nv.setId(null);
        nv.setMa(nvView.getMa());
        nv.setTen(nvView.getTen());
        nv.setTenDem(nvView.getTenDem());
        nv.setHo(nvView.getHo());
        nv.setGioiTinh(nvView.getGioiTinh());
        nv.setNgaySinh(nvView.getNgaySinh());
        nv.setDiaChi(nvView.getDiaChi());
        nv.setSdt(nvView.getSdt());
        nv.setMatKhau(nvView.getMatKhau());
          
        nv.setIdCh(nvView.getIdCh());
        nv.setIdCv(nvView.getIdCv());
        
        nv.setIdGuiBc(nvView.getIdGuiBc());
        nv.setTrangThai(nvView.getTrangThai());

        if (nvRepo.addLstDb(nv)) {
            return "Add ok";
        }
        return "Add loi";
    }

    @Override
    public String updateLst(Object oj, NhanVienViewModel nvView) {
        if (nvView.getMa().isEmpty() || nvView.getTen().isEmpty() || nvView.getTenDem().isEmpty() ||
                nvView.getHo().isEmpty() || nvView.getDiaChi().isEmpty() || nvView.getSdt().isEmpty() || 
                nvView.getMatKhau().isEmpty() ) {
            return "Khong duoc de rong";
        }
        try {
            sdf.format(nvView.getNgaySinh());
        } catch (Exception e) {
            return "Vui long nhap ngay sinh dung dinh dang dd/mm/yyyy";
            
        }
        
        NhanVien nv = new NhanVien();
        nv.setId(null);
        nv.setMa(nvView.getMa());
        nv.setTen(nvView.getTen());
        nv.setTenDem(nvView.getTenDem());
        nv.setHo(nvView.getHo());
        nv.setGioiTinh(nvView.getGioiTinh());
        nv.setNgaySinh(nvView.getNgaySinh());
        nv.setDiaChi(nvView.getDiaChi());
        nv.setSdt(nvView.getSdt());
        nv.setMatKhau(nvView.getMatKhau());
        
        CuaHang ch = new CuaHang();
        ch.setId(nvView.getIdCh().getId());
        nv.setIdCh(ch);
        
        ChucVu cv = new ChucVu();
        cv.setId(nvView.getIdCv().getId());
        nv.setIdCv(cv);
        
        nv.setIdGuiBc(nvView.getIdGuiBc());
        nv.setTrangThai(nvView.getTrangThai());
        
        if (nvRepo.updateLstDb((String) oj, nv)) {
            return "Update ok";
        }
        
        return "Update loi";
    
    }

    @Override
    public String deleteLst(Object oj) {
         
        if (nvRepo.deleteLstDb((String) oj)) {
            return "Delete ok";
        }
        
        return "Delete loi";
    }

    @Override
    public NhanVien getObj(String id){
        return nvRepo.getObj(id);
    }
}
