/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI4_XuLyNgoaiLe;

/**
 *
 * @author Dungna89
 */
public class HocSinhService {
  public void checkTuoiLayVo(int tuoi)throws LayVoException{
    if (tuoi < 18) {
      throw new LayVoException("Bạn chưa đủ tuổi để lấy vợ");
    }else{
      System.out.println("Bạn đã đủ tuổi để lấy vợ");
    }
  }
}
