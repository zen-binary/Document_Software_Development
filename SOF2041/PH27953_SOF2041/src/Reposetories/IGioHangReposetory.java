/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.GioHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGioHangReposetory {
     public List<GioHang> getLstDb();
    public boolean addLstDb(GioHang gh);
    public boolean updateLstDb(String id, GioHang gh);
    public boolean deleteLstDb(String id);
    public GioHang getObj(String id);
}
