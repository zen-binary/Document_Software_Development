/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.ChiTietSP;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IChiTietSPReposetory {
    public List<ChiTietSP> getLstDb();
    public boolean addLstDb(ChiTietSP ctSp);
    public boolean updateLstDb(Object oj, ChiTietSP ctSp);
    public boolean deleteLstDb(Object oj);
    public ChiTietSP getObj(String id);
}
