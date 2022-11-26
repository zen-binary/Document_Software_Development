
package lab1;

import java.util.ArrayList;
import java.util.Scanner;


public class bai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Product pr; 
        ArrayList<Product> arrlst = new ArrayList<>();
        int i=0;
        while (i<5) { 
            pr = new Product();
            System.out.println("Nhap name: ");
            pr.setName(sc.nextLine());
            System.out.println("Nhap price: ");
            pr.setPrice(Double.parseDouble(sc.nextLine()));
            arrlst.add(pr);
            i++;
        }
        
        System.out.println("------------------------");
        for (Product p : arrlst) {
            p.inRaThongTin();
        }
        
    }
}
