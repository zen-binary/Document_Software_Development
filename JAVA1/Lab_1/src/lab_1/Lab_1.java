/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_1;

import java.util.Scanner;

public class Lab_1 {

    static public void bai1() {
        Scanner sc = new Scanner(System.in);
        String ten;
        double diemTb;
        System.out.println("Nhap Ten: ");
        ten = sc.nextLine();
        System.out.println("DIem Tb: ");
        diemTb = Double.parseDouble(sc.nextLine());
        System.out.println("Ten : " + ten + " Diem Tb: " + diemTb);
    }

    static public void bai2() {
        Scanner sc = new Scanner(System.in);
        Double dai, rong, chuVi, dienTich;
        System.out.println("Nhap chieu dai: ");
        dai = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap chieu rong: ");
        rong = Double.parseDouble(sc.nextLine());
        chuVi = (dai + rong) * 2;
        dienTich = dai * rong;
        System.out.println("Chu vi: " + chuVi);
        System.out.println("DIen tich: " + dienTich);
        System.out.println("Canh nho nhat: " + Math.min(dai, rong));

    }

    static public void bai3() {
        Scanner sc = new Scanner(System.in);
        double canh, theTich;
        System.out.println("Nhap chieu dai: ");
        canh = Double.parseDouble(sc.nextLine());
        theTich = (double) Math.pow(canh, 3);
        System.out.println("The tich: " + theTich);
    }

    static public void bai4() {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        System.out.println("Nhap a: ");
        a = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap b: ");
        b = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap c: ");
        c = Double.parseDouble(sc.nextLine());
        double delTa = (double) Math.pow(b, 2) - 4 * a * c;
        double canDelTa = Math.sqrt(delTa);
        System.out.println("Delta : " + delTa);
        System.out.println("Can delta: " + canDelTa);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("---------------");
        System.out.println("B1");
        System.out.println("B2");
        System.out.println("B3");
        System.out.println("B4");
        System.out.println("Chon: ");
        input=sc.nextLine();
        switch (input) {
            case "1":
                bai1();

                break;
            case "2":
                bai2();

                break;
            case "3":
                bai3();

                break;
            case "4":
                bai4();

                break;

            default:
                throw new AssertionError();
        }

    }

}
