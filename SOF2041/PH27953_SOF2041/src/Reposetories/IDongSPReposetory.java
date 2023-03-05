/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IDongSPReposetory {
    public List<DongSP> getLstDb();

    public boolean addLstDb(DongSP dongSP);

    public boolean updateLstDb(String id, DongSP dongSP);

    public boolean deleteLstDb(String id);

    public DongSP getObj(String id);
}
