package lab2;

import java.util.Scanner;

public class Lab2 {

    static public void Bai1() {
        Scanner sc = new Scanner(System.in);
        float a, b;
        System.out.println("Nhap a: ");
        a = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap b: ");
        b = Float.parseFloat(sc.nextLine());
        if (a == 0) {
            if (b == 0) {
                System.out.println("Vo so nghiem");
            } else {
                System.out.println("Vo nghiem");
            }
        } else {
            System.out.println("Nghiem: " + -b / a);
        }
    }

    static public void Bai2() {
        Scanner sc = new Scanner(System.in);
        float a, b, c;
        System.out.println("Nhap a: ");
        a = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap b: ");
        b = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap c: ");
        c = Float.parseFloat(sc.nextLine());
        if (a == 0) {
            System.out.println("Pt bac nhat: " + -b / a);

        } else {

            float delTa = (float) Math.pow(b, 2) - 4 * a * c;
            System.out.println("Delta: " + delTa);
            if (delTa < 0) {
                System.out.println("Vo nghiem");
            } else if (delTa == 0) {
                System.out.println("Nghiem kep: " + -b / (2 * a));
            } else {
                System.out.println("2 Nghiem phan biet");
                float x1 = (float) (-b + Math.sqrt(delTa) / (2 * a));
                float x2 = (float) (-b - Math.sqrt(delTa) / (2 * a));
                System.out.println("x1= " + x1);
                System.out.println("x1= " + x2);
            }
        }
    }

    static void Bai3() {
        Scanner sc = new Scanner(System.in);
        float soDien;
        System.out.println("Nhap so dien: ");
        soDien = Float.parseFloat(sc.nextLine());
        if (soDien < 50) {
            System.out.println("So dien la: " + soDien * 1000);
        } else {
            System.out.println("So dien la: " + soDien * 1000 + (soDien - 50) * 1200);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {

            System.out.println("---------------");
            System.out.println("1.B1");
            System.out.println("2.B2");
            System.out.println("3.B3");
            System.out.println("0.Thoat");
            System.out.println("Chon: ");
            input = sc.nextLine();
            switch (input) {
                case "1":
                    Bai1();

                    break;
                case "2":
                    Bai2();

                    break;
                case "3":
                    Bai3();

                    break;
                case "0":

                    break;

                default:
                    throw new AssertionError();
            }
        } while (input != "0");
    }

}
