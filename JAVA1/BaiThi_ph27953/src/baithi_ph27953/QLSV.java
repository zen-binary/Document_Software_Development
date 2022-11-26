
package baithi_ph27953;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLSV {
    
    static public Scanner sc = new Scanner(System.in);
    
    ArrayList<SinhVien> arrSv = new ArrayList<>();
    
    SinhVien sv;

    public QLSV() {
        arrSv.add( new SinhVien("H1", "ABC1", "UDPM"));
        arrSv.add( new SinhVien("H2", "ABC2", "Web"));
        arrSv.add( new SinhVien("H3", "ABC3", "Moble"));
        arrSv.add( new SinhVien("H4", "ABC4", "Mkt"));
        arrSv.add( new SinhVien("H5", "ABC5", "Abc"));
    }
    
    
    public void add(){
        String chon;
        do {            
            sv = new SinhVien();
            
            System.out.println("Nhap ma sv: ");
            sv.setMaSv(sc.nextLine());
            System.out.println("Nhap ho ten: ");
            sv.setHoTen(sc.nextLine());
            System.out.println("Nhap chuyen nganh: ");
            sv.setChuyenNganh(sc.nextLine());
            
            arrSv.add(sv);
            System.out.println("Ban co muon nhap tiep ko(y/n)");
            chon = sc.nextLine();
        } while (chon.equalsIgnoreCase("y"));
    }
    
    
    public void in(){
        for (SinhVien ssv : arrSv) {
            ssv.inThongTin();
        }
    }
    
    
    public void timSV(){
        String n;
        int check=0;
        System.out.println("Nhap ma sv muon tim: ");
        n = sc.nextLine();
        for (int i = 0; i < arrSv.size(); i++) {
            if (arrSv.get(i).getMaSv().equalsIgnoreCase(n)) {
                arrSv.get(i).inThongTin();
                check++;
            }
            
        }
        if (check==0) {
            System.out.println("Khong tim thay sv");
        }
    }
    
    public void sapXepSv(){
        Collections.sort(arrSv, (o1, o2) -> {
            return o1.getChuyenNganh().compareTo(o2.getChuyenNganh()); 
        });
        in();
    }
    
}
