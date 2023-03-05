/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IChucVuReposetory {
    public List<ChucVu> getLstDb();
    public boolean addLstDb(ChucVu cv);
    public boolean updateLstDb(Object oj, ChucVu cv);
    public boolean deleteLstDb(Object oj);
    public ChucVu getObj(String id);
}
