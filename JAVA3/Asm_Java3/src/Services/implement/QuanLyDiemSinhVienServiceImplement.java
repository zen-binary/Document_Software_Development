/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.implement;

import Model.Grade;
import Model.Students;
import Repositories.QuanLyDiemRepository;
import Repositories.QuanLySinhVienRepositoty;
import Services.IQuanLyDiemSinhVienService;
import ViewModel.QuanLyDiemViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QuanLyDiemSinhVienServiceImplement implements IQuanLyDiemSinhVienService {

    ArrayList<Grade> lst = new ArrayList<>();
    QuanLyDiemRepository qldRepo = new QuanLyDiemRepository();
    QuanLySinhVienRepositoty qlsvRepo = new QuanLySinhVienRepositoty();

    @Override
    public ArrayList<QuanLyDiemViewModel> getLst() {

        ArrayList<Grade> lstGrade = qldRepo.getLstDb();
        ArrayList<QuanLyDiemViewModel> lstQldViewModel = new ArrayList<>();
        for (Grade g : lstGrade) {
            QuanLyDiemViewModel qldViewModel = new QuanLyDiemViewModel();
            qldViewModel.setMaSv(g.getMaSv());
            qldViewModel.setHoTen(getHoTen(g.getMaSv()));
            qldViewModel.setTiengAnh(g.getTiengAnh());
            qldViewModel.setTinHoc(g.getTinHoc());
            qldViewModel.setGdtc(g.getGdtc());
            double avg = (double) (g.getGdtc() + g.getTiengAnh() + g.getTinHoc()) / 3 * 10;
            qldViewModel.setAvg((double) Math.round(avg) / 10);

            lstQldViewModel.add(qldViewModel);
        }

        return lstQldViewModel;
    }

    @Override
    public String deleteLst(String maSv) {
        if (qldRepo.deleteLstDb(maSv)) {
            return "Delete Ok";
        }

        return "Delete Lỗi";
    }

    @Override
    public String searchLst(String maSv) {
        if (maSv.trim().length() == 0) {
            return "Không được để trống";
        }
        if (qldRepo.searchLstDb(maSv)) {
            return "Tìm thấy";
        }
        return "Không Tìm Thấy Ma SV " + maSv;
    }

    @Override
    public String updateLst(String maSv, Grade g) {
        if (maSv.trim().length() == 0) {
            return "Không được để trống";
        }

        if (qldRepo.updateLstDb(maSv, g)) {
            return "Update ok";
        }
        return "Update lỗi";
    }

    @Override
    public String getHoTen(String maSv) {
        return qldRepo.getHoTenStudents(maSv);
    }

    @Override
    public String addLst(Grade g) {
        ArrayList<Students> lst = qlsvRepo.getLstDb();
        int check = 0;
        for (Students s : lst) {
            if (g.getMaSv().equals(s.getMaSv())) {
               check ++;
            }
        }
        for (QuanLyDiemViewModel v : this.getLst()) {
            if (v.getMaSv().equalsIgnoreCase(g.getMaSv())) {
                return "Trùng mã sv không thể thếm";
            }
        }
        if (check == 0) {
            return "Vui lòng báo phòng đào tạo để thêm sv";
        }
        if (qldRepo.insertLstDb(g)) {
            return "Add ok";
        }
        return "Add Loi";
    }

}
