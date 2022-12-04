/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.implement;

import Model.Students;
import Repositories.QuanLySinhVienRepositoty;
import Services.IQuanLySinhVienService;
import ViewModel.QuanLyDiemViewModel;
import ViewModel.QuanLySinhVienViewModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class QuanLySinhVienServiceImplement implements IQuanLySinhVienService {

    QuanLySinhVienRepositoty qlsvRepo = new QuanLySinhVienRepositoty();

    @Override
    public ArrayList<QuanLySinhVienViewModel> getLst() {
        ArrayList<Students> lstStudents = qlsvRepo.getLstDb();
        ArrayList<QuanLySinhVienViewModel> lstQlSvViewModels = new  ArrayList<>();
        
        for (Students s : lstStudents) {
            QuanLySinhVienViewModel qlsv = new QuanLySinhVienViewModel();
            qlsv.setMaSv(s.getMaSv());
            qlsv.setHoTen(s.getHoTen());
            qlsv.setEmail(s.getEmail());
            qlsv.setSoDt(s.getSoDt());
            qlsv.setDiaChi(s.getDiaChi());
            qlsv.setGioiTinh(s.isGioiTinh());
            qlsv.setHinh(s.getHinh());
            lstQlSvViewModels.add(qlsv);
        }
        
        return lstQlSvViewModels;
    }

    @Override
    public String addLst(Students s) {

        for (Students students : qlsvRepo.getLstDb()) {
            if (s.getMaSv().equalsIgnoreCase(students.getMaSv())) {
                return "Mã SV đã tồn tại";
            }
        }

        if (qlsvRepo.saveLstDb(s)) {
            return "Thêm ok";
        }

        return "Thêm loi";
    }

    @Override
    public String updateLst(String maSv, Students s, int i) {

        if (!s.getMaSv().equalsIgnoreCase(qlsvRepo.getLstDb().get(i).getMaSv())) {
            return "Không thể thay đổi mã SV " + qlsvRepo.getLstDb().get(i).getMaSv();
        }

        if (qlsvRepo.updateLstDb(maSv, s)) {
            return "Update thành công";
        }
        return "Update lôi";
    }

    @Override
    public String deleteLst(String maSv) {
        if (qlsvRepo.deleteLstDb(maSv)) {
            return "Delete thành công";
        }
        return "Delete lôi";
    }

    @Override
    public ArrayList<QuanLySinhVienViewModel> searchLst(String nameStr) {    
        ArrayList<Students> lstStudents = qlsvRepo.searchSvDb(nameStr);
        ArrayList<QuanLySinhVienViewModel> lstQlSvViewModels = new  ArrayList<>();
        
        for (Students s : lstStudents) {
            QuanLySinhVienViewModel qlsv = new QuanLySinhVienViewModel();
            qlsv.setMaSv(s.getMaSv());
            qlsv.setHoTen(s.getHoTen());
            qlsv.setEmail(s.getEmail());
            qlsv.setSoDt(s.getSoDt());
            qlsv.setDiaChi(s.getDiaChi());
            qlsv.setGioiTinh(s.isGioiTinh());
            qlsv.setHinh(s.getHinh());
            lstQlSvViewModels.add(qlsv);
        }
        
        return lstQlSvViewModels;
    }
}
