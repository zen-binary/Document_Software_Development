/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

/**
 *
 * @author Admin
 */
public class NoTaxProduct extends Product{

    public NoTaxProduct() {
    }

    public NoTaxProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void inRaThongTin() {
        super.inRaThongTin();
    }

    @Override
    public double getImportTax() {
        return 0; 
    }
    
}
