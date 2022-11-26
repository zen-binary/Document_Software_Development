/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI_TAP_MAU_CRUD_SINHVIEN_DOCGIFILE;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dungna89
 */
public class Utilities {

  public Utilities() {
  }

  boolean checkSo(String text) {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(text);
    return matcher.matches();
  }

  //Viết hoa chữ cái đầu trong từ
  String convertFullName(String fullName) {//nguyen van tung
    String[] arrName = fullName.split("\\s+");
    String fullN = "";
    for (String x : arrName) {
      fullN += vietHoaChuCaiDau(x) + " ";
    }
    return fullN;//Nguyen Van Tung
  }

  String vietHoaChuCaiDau(String text) {//DŨNG
    var temp = text.trim().toLowerCase();//dũng
    return String.valueOf(temp.charAt(0)).toUpperCase() + text.substring(1);//Dũng
  }

  /*
    Nguyễn Văn Tùng = TungnvPH123
   */
  public String zenMA(String fullName, int id) {
    String[] arrName = fullName.split("\\s+");//nguyễn văn tùng
    var name = vietHoaChuCaiDau(arrName[arrName.length - 1]);//Tùng
    for (int i = 0; i < arrName.length - 1; i++) {
      name += String.valueOf(arrName[i].charAt(0));//Tùngnv
    }
    name += "PH" + String.valueOf(id);//TùngnvPH1
    return unAccent(name);
  }

  //TùngNV = TungNV
  public String unAccent(String s) {//Convert từ tiếng việt có dấu về tiếng việt 0 dấu
    String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
  }
}
