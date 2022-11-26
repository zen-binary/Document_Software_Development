/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitapjava1_lamho;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BaiTapJava1_LamHo {

    public static Scanner sc = new Scanner(System.in);
    public static ThucVatService _tvService = new ThucVatService();
    public static void menu(){
        System.out.println("-------------------------------");
        System.out.println("1.Thêm tV");
        System.out.println("2.In tv");
        System.out.println("3.Tìm tv");
        System.out.println("4.Kế thừa");
        System.out.println("0.Thoát");
        System.out.println("-------------------------------");
        System.out.print("Chọn:");
    }
    
    
    public static void add(ThucVat tv){
        
        System.out.println("Nhập mã tv: ");
        tv.setMaTV(sc.nextLine());
        System.out.println("Nhập ten: ");
        tv.setTen(sc.nextLine());
        System.out.println("Nhập Khu vực: ");
        tv.setKhuVuc(sc.nextLine());
        System.out.println("Nhập cân nặng: ");
        tv.setCanNang(Integer.valueOf(sc.nextLine()));
    }
 
    public static void addTv(){
        ThucVat tv = new ThucVat();
        add(tv);
        _tvService.addList(tv);
        
    }
    
    public static void inDs(){
        for (ThucVat tv : _tvService.getList()) {
            System.out.println("Mã Tv: " + tv.getMaTV() + " Tên: " + tv.getTen() + " Khu vực: " + tv.getKhuVuc() + " Cân nặng: " + tv.getCanNang());
        }
    }
    public static void timTv(){
        int c1,c2; 
        System.out.println("Nhập Cân nặng 1: ");
        c1 = Integer.valueOf(sc.nextLine()) ;
        System.out.println("Nhập Cân nặng 2: ");
        c2 = Integer.valueOf(sc.nextLine()) ;
        for (ThucVat tv : _tvService.getList()) {
            if (tv.getCanNang() >= Math.min(c1, c2) && tv.getCanNang() <= Math.max(c1, c2)) {
                System.out.println("Mã Tv: " + tv.getMaTV() + " Tên: " + tv.getTen() + " Khu vực: " + tv.getKhuVuc() + " Cân nặng: " + tv.getCanNang());
            }
        }
    }
    
    public static void keThuaAnQua(){
        CayAnQua caq = new CayAnQua();
        add(caq); 
            System.out.println("Nhập mùa 1-4: ");
            caq.setMuaRaQua(Integer.valueOf(sc.nextLine()));
        _tvService.addList(caq);
        caq.display();
    }
    
    public static void main(String[] args) {
        String chon;
        
        do {            
            menu();
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    addTv();
                    break;
                case "2":
                    inDs();
                    break;
                case "3":
                    timTv();
                    break;
                case "4":
                    keThuaAnQua();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại ");
            }
        } while (true);
    }
    
}
