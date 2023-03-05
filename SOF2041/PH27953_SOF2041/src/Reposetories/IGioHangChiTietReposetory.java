/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.GioHangChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGioHangChiTietReposetory {
     public List<GioHangChiTiet> getLstDb();
    public boolean addLstDb(GioHangChiTiet gh);
    public boolean updateLstDb(String idGh,String idCtSp, GioHangChiTiet ghCt);
    public boolean deleteLstDb(String idGh,String idCtSp);
    public GioHangChiTiet getObj(String idGh, String idCtSp);
}
