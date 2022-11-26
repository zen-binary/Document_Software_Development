package lab3;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
    static Scanner sc = new Scanner(System.in);
    public static void Bai1() {
        

        int n;
        boolean a = false;

        System.out.println("Nhap so nguyen: ");
        n = Integer.parseInt(sc.nextLine());
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    a = true;
                    break;
                }
            }

        } else {
            System.out.println("Vui long nhap lai");

        }
        if (a) {
            System.out.println(n + " Khong phai la so nguyen to");
        } else {
            
            System.out.println(n + " La so nguyen to");
        }
    }

    public static void Bai2() {
       
        int a, b;
        System.out.println("chuong trinh xuat bang cuu chung theo khoang");
        System.out.println("Nhap khoang 1: ");
        a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap khoang 2: ");
        b = Integer.parseInt(sc.nextLine());
        
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            System.out.println("Bang cuu chuong " + i);
            for (int j = 1; j <=10 ; j++) {
                System.out.printf("%d x %d = %d \n", i , j ,i*j );
            }
        }
    }
    
    public static void Bai3(){
        
        int n;
        int[] arrSoNguyen;
        System.out.println("Nhap so luong: ");
        n = Integer.parseInt(sc.nextLine());
        arrSoNguyen = new int[n];
        for (int i = 0; i < arrSoNguyen.length; i++) {
            System.out.println("Nhap so "+(i+1)+" :");
            arrSoNguyen[i]= Integer.parseInt(sc.nextLine());
        }
        
        Arrays.sort(arrSoNguyen);
        for (int i : arrSoNguyen) {
            System.out.println(" " + i);
        }
        
        int min = arrSoNguyen[0];
        int tong = 0;
        int dem = 0;
        for (int i = 0; i < arrSoNguyen.length; i++) {
            if (min > arrSoNguyen[i]) {
                min=arrSoNguyen[i];
            }
            
            if (arrSoNguyen[i]%3==0) {
                tong=tong+arrSoNguyen[i];
                dem++;
            }
        }
        System.out.println("SO be nhat: "+ min);
        int tbc= tong/dem;
        System.out.println("Tb cong: " + tbc);
        
    }
    public static void Bai4(){
        
        int n;
        System.out.println("Moi nhap so luong: ");
        n = Integer.parseInt(sc.nextLine());
        
        String[] hoTen = new String[n];
        double[] diem = new double[n];
        String[] hocLuc = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("----------");
            System.out.println("Nhap Ho Ten: ");
            hoTen[i]=sc.nextLine();
            System.out.println("Nhap diem: ");
            diem[i] = Double.parseDouble(sc.nextLine());
        
            
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                double temp;
                temp =diem[i];
                diem[i]=diem[j];
                diem[j]=temp;
            }
        }
        for (int i = 0; i < n; i++) {
            double diemHl=diem[i];
            if (diemHl<5) {
                hocLuc[i]="Yeu";
                
            }else if (diemHl<=5&&diemHl<6.5) {
                hocLuc[i]="Trung binh";
                
            }else if (diemHl<=6.5&&diemHl<7.5) {
                hocLuc[i]="Kha";
            }else if (diemHl<=7.5&&diemHl<9) {
                hocLuc[i]="Gioi";
            }else{
                hocLuc[i]="Xuat sac";
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("-----------");
            System.out.println("Ho Ten: "+ hoTen[i]);
            System.out.println("Diem: "+ diem[i]);
            System.out.println("Hoc luc: "+ hocLuc[i]);
        }
        
        
        
    }

    public static void main(String[] args) {
        String chon;
        do {            
            System.out.println("-------------------------");
            System.out.println("1. Bai 1");
            System.out.println("2. Bai 2");
            System.out.println("3. Bai 3");
            System.out.println("4. Bai 4");
            System.out.println("-------------------------");
            System.out.println("Chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    Bai1();
                    break;
                case "2":
                    Bai2();
                    break;
                case "3":
                    Bai3();
                    break;
                case "4":
                    Bai4();
                    break;
                default:
                    System.out.println("Nhap lai");
            }
        } while (true);
        
        
        

    }

}
