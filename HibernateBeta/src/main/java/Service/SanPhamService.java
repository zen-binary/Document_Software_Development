/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.SanPham;
import Repositories.SanPhamReposetory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamService {
    SanPhamReposetory spRepo = new SanPhamReposetory();
    public List<SanPham> getLst(){
        return spRepo.getLstDb();
    }
    
    public boolean save(SanPham sp){
        return spRepo.save(sp);
    }
    
    public boolean delete(SanPham sp){
        return spRepo.delete(sp);
    }
    
    public SanPham getObj(String ma){
        return spRepo.getObj(ma);
    }
}
