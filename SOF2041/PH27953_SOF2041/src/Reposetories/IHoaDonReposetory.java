/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonReposetory {
    public List<HoaDon> getLstDb();
    public boolean addLstDb(HoaDon hd);
    public boolean updateLstDb(String id, HoaDon hd);
    public boolean deleteLstDb(String id);
    public HoaDon getObj(String id);
}
