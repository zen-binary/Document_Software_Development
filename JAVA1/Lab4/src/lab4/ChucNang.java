package lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class ChucNang {

    Scanner sc = new Scanner(System.in);
    SanPham sanPham;
    ArrayList<SanPham> arrSv = new ArrayList<>();

    public void add() {
        int n;
        System.out.println("Nhap so luong sv: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            sanPham = new SanPham();
            System.out.println("Nhap Ten Sp: ");
            sanPham.setTenSp(sc.nextLine());
            System.out.println("Nhap ten don gia: ");
            sanPham.setDonGia(Double.parseDouble(sc.nextLine()));
            System.out.println("Nhap Giam gia: ");
            sanPham.setGiamGia(Double.parseDouble(sc.nextLine()));
            arrSv.add(sanPham);
        }

    }

    public void xuat() {
       
        for (SanPham sv : arrSv) {
            sv.inRaManHinh();
            
        }

    }
}
