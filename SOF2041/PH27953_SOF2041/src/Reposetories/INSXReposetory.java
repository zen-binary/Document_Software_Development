/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INSXReposetory {
    public List<NSX> getLstDb();

    public boolean addLstDb(NSX nsx);

    public boolean updateLstDb(String id, NSX nsx);

    public boolean deleteLstDb(String id);

    public NSX getObj(String id);
}
