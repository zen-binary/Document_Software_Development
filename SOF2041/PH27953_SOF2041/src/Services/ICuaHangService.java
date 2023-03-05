/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.CuaHang;
import Reposetories.Implement.CuaHangRepository;
import ViewModels.CuaHangViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICuaHangService {

    public CuaHangRepository cuaHangRepo = new CuaHangRepository();

    public List<CuaHang> getLst();

    public List<CuaHangViewModel> getLstView();

    public boolean addLst(CuaHangViewModel chView);

    public boolean updateLst(Object oj, CuaHangViewModel chView);

    public boolean deleteLst(Object oj);

    public CuaHang getObj(String id);

}
