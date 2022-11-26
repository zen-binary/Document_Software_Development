using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Asm1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ChucNang cs = new ChucNang();
            string input;
            do
            {


                Console.WriteLine("------------------------------------------------------------------");
                Console.WriteLine("1. Nhap danh sach hoc vien ");
                Console.WriteLine("2. Xuat danh sach hoc vien ");
                Console.WriteLine("3. Tim kiem hoc vien theo khoang diem nhap tu ban phim");
                Console.WriteLine("4. Tim hoc vien theo hoc luc nhap vao tu ban phim");
                Console.WriteLine("5. Tim hoc vien theo ma so va cap nhat thong tin sinh vien");
                Console.WriteLine("6. Sap xep hoc vien theo diem");
                Console.WriteLine("7. Xuat 5 hoc vien co diem cao nhat");
                Console.WriteLine("8. Tinh diem trung binh cua lop");
                Console.WriteLine("9. Xuat danh sach hoc vien co diem cao hon diem trung binh lop");
                Console.WriteLine("10. Tong hop so hoc vien theo hoc luc");
                Console.WriteLine("0. Thoat");
                Console.WriteLine("------------------------------------------------------------------");
                Console.Write("Vui long chon chuc nang:");
                input = Console.ReadLine();
                switch (input)
                {
                    case "1":
                        cs.addHv();

                        break;
                    case "2":
                        cs.inHv();
                        break;
                    case "3":
                        cs.timDiem();
                        break;
                    case "4":

                        break;
                    case "5":
                        cs.timMaHv();
                        break;
                    case "6":
                        cs.SapXep();
                        break;
                    case "7":
                        cs.Top5();
                        break;
                    case "8":
                        cs.DiemTB();
                        break;
                    case "9":
                        cs.DsHocVienTb();
                        break;
                    case "10":
                        cs.HvTheoHl();
                        break;
                    case "0":
                        Console.WriteLine("Ban da thoat!!");
                        break;

                    default:
                        Console.WriteLine("Vui long chon nhung thu co trong menu");
                        break;
                }

            } while (input != "0");
        }
    }
}
