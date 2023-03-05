/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonChiTietReposetory {
    public List<HoaDonChiTiet> getLstDb();
    public boolean addLstDb(HoaDonChiTiet hdct);
    public boolean updateLstDb(String idHd, String idCtSp, HoaDonChiTiet hdct);
    public boolean deleteLstDb(String idHd, String idCtSp);
    public HoaDonChiTiet getObj(String idHd, String idCtSp);
}
