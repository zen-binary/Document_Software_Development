package lab4;

import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChucNang cn = new ChucNang();
        String chon;
        do {
            System.out.println("-------");
            System.out.println("1. add");
            System.out.println("2. in ");
            System.out.print("chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    cn.add();
                    break;
                case "2":
                    cn.xuat();
                    break;
                
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

}
