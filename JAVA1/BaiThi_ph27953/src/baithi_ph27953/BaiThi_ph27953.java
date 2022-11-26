
package baithi_ph27953;

import java.util.Scanner;


public class BaiThi_ph27953 {
    public static void menu(){
        System.out.println("---------------------------");
        System.out.println("1. Nhap ds doi tuong");
        System.out.println("2. Xuat doi tuong");
        System.out.println("3. Tim sv theo ma");
        System.out.println("4. Sap xep ds sv theo nganh");
        System.out.println("5. Ke thua");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
        System.out.println("chon: ");
    }

    public static void main(String[] args) {
       
        QLSV ql = new QLSV();
        Scanner sc = new Scanner(System.in);
        
        String chon;
        do {            
            menu();
            chon = sc.nextLine();
            
            switch (chon) {
                case "1":
                    ql.add();
                    break;
                case "2":
                    ql.in();
                    break;
                case "3":
                    ql.timSV();
                    break;
                case "4":
                    ql.sapXepSv();
                    break;
                case "5":
                    SinhVienPoly svPl = new SinhVienPoly("PH01", "Chien", "Cntt", 1);
                    svPl.inThongTin();
                    break;
                case "0":
                    
                    break;
                default:
                    System.out.println("Vui long chon lai ");
            }
        } while (!chon.equals("0"));
        
        
    }
    
}
