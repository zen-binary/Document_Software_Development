/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reposetories;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhanVienReposetory {

    public List<NhanVien> getLstDb();

    public boolean addLstDb(NhanVien nv);

    public boolean updateLstDb(String id, NhanVien nv);

    public boolean deleteLstDb(String id);

    public NhanVien getObj(String id);

}
