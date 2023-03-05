/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.CuaHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICuaHangRepository {

    public List<CuaHang> getLstDb();

    public boolean addLstDb(CuaHang ch);

    public boolean updateLstDb(String id, CuaHang ch);

    public boolean deleteLstDb(String id);

    public CuaHang getObj(String id);
}
