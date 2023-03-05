/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.Loai;
import Repositories.LoaiReposetory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiService {
    LoaiReposetory loaiRepo = new LoaiReposetory();
    public List<Loai> getLst(){
        return loaiRepo.getLstDb();
    }
    
    public boolean save(Loai l){
        return loaiRepo.save(l);
    }
    
    public boolean delete(Loai l){
        return loaiRepo.delete(l);
    }
    
    public Loai getObj(String ma){
        return loaiRepo.getObj(ma);
    }
}
