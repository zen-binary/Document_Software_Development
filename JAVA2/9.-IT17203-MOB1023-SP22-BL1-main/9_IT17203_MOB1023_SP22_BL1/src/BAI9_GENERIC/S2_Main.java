/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI9_GENERIC;

/**
 *
 * @author Dungna89
 */
public class S2_Main {
  public static void main(String[] args) {
    Integer arrSoNguyen[] = {2000,2001,2003};//Gác lại chỗ này
    
    S2_IService<Integer> iService = new S2_Service<>(arrSoNguyen);
    System.out.println(iService.checkSoChan(201));
  }
}
