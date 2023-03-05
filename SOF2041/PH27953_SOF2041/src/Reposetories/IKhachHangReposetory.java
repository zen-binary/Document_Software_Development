/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKhachHangReposetory {
    public List<KhachHang> getLstDb();

    public boolean addLstDb(KhachHang kh);

    public boolean updateLstDb(String id, KhachHang kh);

    public boolean deleteLstDb(String id);

    public KhachHang getObj(String id);
}
