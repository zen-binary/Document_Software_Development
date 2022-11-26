package BaiTapThem;

import java.util.Scanner;

public class main {

    static Scanner sc = new Scanner(System.in);
    static void checkSoNguyenTo(int n){
        
        boolean a = true;
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    a = false;
                    break;
                }
            }
        }
        if (a) {
            System.out.printf("%d \t",n);
        
        }
        
        
    }
    public static void main(String[] args) {
//        -Nhập vào 1 mảng
//        - Xuất mảng đó 
//        -Xuất các phần tử là số lẻ trong mảng vừa nhập
//        - Tính tổng các phần tử trong mảng 
//        -hiển thị các phần tử trong mảng là số nguyên tố

        int[] arrSo;
        int n;
        System.out.println("Nhap so luong");
        n = Integer.parseInt(sc.nextLine());
        arrSo = new int[n];
        for (int i = 0; i < arrSo.length; i++) {
            System.out.println("Nhap so thu " + (i + 1));
            arrSo[i] = Integer.parseInt(sc.nextLine());

        }
        System.out.println("----------xuat--------");
        for (int x : arrSo) {
            System.out.println(x);

        }
        int tong = 0;
        System.out.println("xuat cac so le trong mang");
        for (int i = 0; i < arrSo.length; i++) {
            if (arrSo[i] % 2 != 0) {
                System.out.printf("%d \t",arrSo[i]);
            }
            tong = tong + arrSo[i];

        }
        System.out.println("");
        System.out.println("-----------so nguyen to----------");
        
        for (int i = 0; i < arrSo.length; i++) {
            if (arrSo[i] > 2) {
                checkSoNguyenTo(arrSo[i]);
            } 
        }
        System.out.println("");

    }

}
