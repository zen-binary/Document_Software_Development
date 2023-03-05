/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Implement;

import DomainModels.ChucVu;
import Reposetories.IChucVuReposetory;
import Reposetories.Implement.ChucVuRepository;
import Services.IChucVuService;
import ViewModels.ChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChucVuService implements IChucVuService {

    private IChucVuReposetory ChucVuRepo = new ChucVuRepository();

    @Override
    public List<ChucVu> getLst() {
        return ChucVuRepo.getLstDb();
    }

    @Override
    public List<ChucVuViewModel> getLstView() {
        List<ChucVuViewModel> lst = new ArrayList<>();
        for (ChucVu cv : getLst()) {
            ChucVuViewModel cvViewModel = new ChucVuViewModel();
            cvViewModel.setId(cv.getId());
            cvViewModel.setMa(cv.getMa());
            cvViewModel.setTen(cv.getTen());
            lst.add(cvViewModel);
        }

        return lst;
    }

    @Override
    public boolean addLst(ChucVuViewModel cvView) {
        ChucVu cv = new ChucVu();
        cv.setId(null);
        cv.setMa(cvView.getMa());
        cv.setTen(cvView.getTen());
        if (ChucVuRepo.addLstDb(cv)) {
            return true;
        }
        return false;

    }

    @Override
    public boolean updateLst(Object oj, ChucVuViewModel cvView) {
        ChucVu cv = new ChucVu();
        cv.setId(null);
        cv.setMa(cvView.getMa());
        cv.setTen(cvView.getTen());
        if (ChucVuRepo.updateLstDb(oj, cv)) {
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteLst(Object oj) {
        if (ChucVuRepo.deleteLstDb(oj)) {
            return true;
        }
        return false;
    }

    @Override
    public ChucVu getObj(String id) {
        return ChucVuRepo.getObj(id);
    }

}
