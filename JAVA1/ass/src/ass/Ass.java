package ass;

import java.util.Scanner;

public class Ass {

    static public Scanner sc = new Scanner(System.in);

    static void menu() {

        System.out.println("------------------------------");
        System.out.println("1. Nhap danh sach nhan vien");
        System.out.println("2. Xuat danh sach nhan vien");
        System.out.println("3. Tim va hien thi nhan vien");
        System.out.println("4. Xoa nhan vien theo masv");
        System.out.println("5. Cap nhat thong tin theo ma nhan vien");
        System.out.println("6. Tim cac nhan vien theo khoang luong");
        System.out.println("7. Sap xep nhan vien ho ten");
        System.out.println("8. Sap xep nhan vien theo thu nhap");
        System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
        System.out.println("0. Thoat");
        System.out.println("------------------------------");
        System.out.println("Chon: ");

    }

    public static void main(String[] args) {
        Qlnv nv = new Qlnv();
        int _input;
        do {            
            menu();
            _input = Integer.parseInt(sc.nextLine());
            switch (_input) {
                case 1:
                    nv.add();
                    break;
                case 2:
                    nv.xuat();
                    break;
                case 3:
                    nv.tim();
                    break;
                case 4:
                    nv.xoa();
                    break;
                case 5:
                    nv.capNhat();
                    break;
                case 6:
                    nv.timLuong();
                    break;
                case 7:
                    nv.sapXepTen();
                    break;
                case 8:
                    nv.sapXepLuong();
                    break;
                case 9:
                    nv.top5();
                    break;
                default:
                    System.out.println("Vui long chon trong menu");
            }
        } while (true);


    }

}
