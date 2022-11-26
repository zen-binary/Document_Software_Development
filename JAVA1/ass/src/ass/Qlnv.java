package ass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Qlnv {

    static public Scanner sc = new Scanner(System.in);
    private ArrayList<NhanVien> _arrNv = new ArrayList<>();
    private NhanVien _Nv;
    private TiepThi _TThi;
    private TruongPhong _Tphong;

    public Qlnv() {
        _arrNv.add(new NhanVien("a1", "A", 10000));
        _arrNv.add(new TiepThi("a2", "B", 3000, 100, 100));
        _arrNv.add(new NhanVien("a3", "C", 9000));
        _arrNv.add(new TruongPhong("a4", "D", 8000, 100));
        _arrNv.add(new NhanVien("a5", "E", 60000));
        _arrNv.add(new NhanVien("a6", "E", 60000));

    }

    public void add() {
        String chon;
        do {            
            System.out.println("-------------------------------");
            System.out.println("1. Nhap ds nhan vien");
            System.out.println("2. Nhap ds tiep thi");
            System.out.println("3. Nhap ds truong phong");
            System.out.println("0. Thoat");
            System.out.println("-------------------------------");
            System.out.println("chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    addNv();
                    break;
                case "2":
                    addTt();
                    break;
                case "3":
                    addTp();
                    break;
                default:
                    System.out.println("Vui long chon lai");
            }
        } while (!chon.equalsIgnoreCase("0"));

    }

    public void addNv() {
        String chon;
        do {
            System.out.println("Moi nhap so luong: ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                _Nv = new NhanVien();
                System.out.println("Nhap MaNv: ");
                _Nv.setMaNv(sc.nextLine());
                System.out.println("Nhap Ho Ten: ");
                _Nv.setHoTen(sc.nextLine());
                System.out.println("Nhap luong: ");
                _Nv.setLuong(Double.parseDouble(sc.nextLine()));
                _arrNv.add(_Nv);
            }
            System.out.println("Ban co muon chon tiep hay khong Y/N");
            chon = sc.nextLine();
        } while (chon.equalsIgnoreCase("y"));
    }

    public void addTt() {
        String chon;
        do {
            System.out.println("Moi nhap so luong: ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                _TThi = new TiepThi();
                System.out.println("Nhap MaTt: ");
                _TThi.setMaNv(sc.nextLine());
                System.out.println("Nhap Ho Ten: ");
                _TThi.setHoTen(sc.nextLine());
                System.out.println("Nhap luong: ");
                _TThi.setLuong(Double.parseDouble(sc.nextLine()));
                System.out.println("Nhap danh so:");
                _TThi.setDoanhSo(Double.parseDouble(sc.nextLine()));
                System.out.println("Nhap hue hong:");
                _TThi.setHueHong(Double.parseDouble(sc.nextLine()));
                _arrNv.add(_TThi);
            }
            System.out.println("Ban co muon chon tiep hay khong Y/N");
            chon = sc.nextLine();
        } while (chon.equalsIgnoreCase("y"));

    }
    public void addTp() {
        String chon;
        do {
            System.out.println("Moi nhap so luong: ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                _Tphong = new TruongPhong();
                System.out.println("Nhap MaTt: ");
                _Tphong.setMaNv(sc.nextLine());
                System.out.println("Nhap Ho Ten: ");
                _Tphong.setHoTen(sc.nextLine());
                System.out.println("Nhap luong: ");
                _Tphong.setLuong(Double.parseDouble(sc.nextLine()));
                System.out.println("Nhap danh so:");
                _Tphong.setTrachNhiem(Double.parseDouble(sc.nextLine()));
                System.out.println("Nhap hue hong:");
                _arrNv.add(_Tphong);
            }
            System.out.println("Ban co muon chon tiep hay khong Y/N");
            chon = sc.nextLine();
        } while (chon.equalsIgnoreCase("y"));

    }

    public void xuat() {

        for (NhanVien nv : _arrNv) {
            nv.xuatThongTin();
        }
    }

    public int getViTri(String ViTri) {
        for (int i = 0; i < _arrNv.size(); i++) {
            if (ViTri.equalsIgnoreCase(_arrNv.get(i).getMaNv())) {
                return i;
            }
        }
        return -1;
    }

    public void tim() {
        System.out.println("Nhap Ma can tim: ");

        int temp = getViTri(sc.nextLine());
        if (temp == -1) {
            System.out.println("Khong tim thay");
            return;
        }
        _arrNv.get(temp).xuatThongTin();
    }

    public void xoa() {
        System.out.println("Nhap Ma Nhan vien: ");
        String manv = sc.nextLine();
        int temp = getViTri(manv);
        if (temp == -1) {
            System.out.println("Khong tim thay ");
            return;
        }
        _arrNv.remove(temp);
        System.out.println("Da xoa nhan vien co ma " + manv);
    }

    public void capNhat() {
        System.out.println("Nhap Ma can tim: ");
        String manv = sc.nextLine();
        int temp = getViTri(manv);
        if (temp == -1) {
            System.out.println("Khong tim thay ");
            return;
        }
        String input;
        System.out.println("Ban muon cap nhap");
        System.out.println("1. Ma ");
        System.out.println("2. Ten ");
        System.out.println("3. Luong");
        System.out.println("Chon: ");
        input = sc.nextLine();
        switch (input) {
            case "1":
                System.out.println("Nhap ma moi: ");
                _arrNv.get(temp).setMaNv(sc.nextLine());
                break;
            case "2":
                System.out.println("Nhap ho ten moi");
                _arrNv.get(temp).setHoTen(sc.nextLine());
                break;
            case "3":
                System.out.println("Nhap luong moi");
                _arrNv.get(temp).setLuong(Double.parseDouble(sc.nextLine()));
                break;
            default:
                System.out.println("Vui luong chon lai");

        }
    }

    public void timLuong() {
        double luong1, luong2;
        boolean n = true;
        System.out.println("Nhap khoang luong 1: ");
        luong1 = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap khoang luong 2: ");
        luong2 = Integer.parseInt(sc.nextLine());
        int min = (int) Math.min(luong1, luong2);
        int max = (int) Math.max(luong1, luong2);

        for (int i = 0; i < _arrNv.size(); i++) {
            if (_arrNv.get(i).getLuong() >= min && _arrNv.get(i).getLuong() <= max) {
                _arrNv.get(i).xuatThongTin();
                n = false;
            }
        }
        if (n) {
            System.out.println("Khong tim thay khoang luong ban nhap");
            
        }

    }

    public void sapXepTen() {
        Collections.sort(_arrNv, (o1, o2) -> {
            return o1.getHoTen().compareTo(o2.getHoTen());
        });
        System.out.println("sap xep thanh cong");
        System.out.println("--------------------------");
        xuat();

    }

    public void luong() {
        Collections.sort(_arrNv, (o1, o2) -> {
            return o1.getLuong() < o2.getLuong() ? 1 : -1;
        });
    }

    public void sapXepLuong() {
        luong();
        System.out.println("sap xep thanh cong");
        System.out.println("--------------------------");
        xuat();
    }
    
//    public void sapxep(){
//        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
//            @Override
//            public int compare(NhanVien o1, NhanVien o2) {
//                return o1.getHoTen().compareTo(o2.getHoTen());
//            }
//            
//        };
//        Collections.sort(_arrNv, comp);

//        Collections.sort(_arrNv, (o1, o2) -> {
//            return o1.getHoTen().compareTo(o2.getHoTen()); 
//        });
          
//    }

    public void top5() {
        luong();
        for (int i = 0; i < 5; i++) {
            _arrNv.get(i).xuatThongTin();
        }
    }

}
