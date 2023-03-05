/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IMauSacReposetory {
    public List<MauSac> getLstDb();

    public boolean addLstDb(MauSac ms);

    public boolean updateLstDb(String id, MauSac ms);

    public boolean deleteLstDb(String id);

    public MauSac getObj(String id);
}
