/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitapjava1_lamho;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThucVatService implements IThucVat{
    private ArrayList<ThucVat> _lstTv = new ArrayList<>();

    public ThucVatService() {
        _lstTv.add(new ThucVat("a1", "abc", "Hm", 5));
        _lstTv.add(new ThucVat("a1", "abc", "Hm", 3));
        _lstTv.add(new ThucVat("a1", "abc", "Hm", 8));
        _lstTv.add(new ThucVat("a1", "abc", "Hm", 4));
        _lstTv.add(new ThucVat("a1", "abc", "Hm", 6));

    }
    
    @Override
    public void addList(ThucVat tv) {
       _lstTv.add(tv);
    }

    @Override
    public ArrayList<ThucVat> getList() {
        return _lstTv;
    }

    
    
}
