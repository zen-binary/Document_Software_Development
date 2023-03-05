/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISanPhamReposetory {
    public List<SanPham> getLstDb();
    public boolean addLstDb(SanPham sp);
    public boolean updateLstDb(Object oj, SanPham sp);
    public boolean deleteLstDb(Object oj);
    public SanPham getObj(String id);
}
