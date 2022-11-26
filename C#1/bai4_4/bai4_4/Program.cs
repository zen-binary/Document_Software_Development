using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace bai4_4
{
    //Tạo 1 lớp sinh viên chưa các thông tin : mã sv, tên sv, điểm(C#,Js)
    //Tạo các phương thức tăng điểm giảm điểm và in ra thông tin sv
    //trong hàm Main tạo ra 1 mảng 10 sv chứa nó trong 1 mảng.
    //Nhập vào từ bản phím các thông tin sinh viên và in ra dưới dạng  bảng
    internal class Program
    {
        class SinhVien
        {
            //property
            public string Ten_SinhVien, MaSinhVien;
            public float DiemCSharp, DiemJS;


            //Cóntructior không chưa tham số
            public SinhVien()
            {
                this.MaSinhVien = "0";
                this.Ten_SinhVien = "";
                this.DiemCSharp = 0.00f;
                this.DiemJS = 0.00f;
            }

            //Constructor có chưa tham số
            public SinhVien(string MaSinhVien, string TenSinhVien, float DiemCSharp, float DiemJS)
            {
                this.MaSinhVien = MaSinhVien;
                this.Ten_SinhVien = TenSinhVien;
                this.DiemCSharp = DiemCSharp;
                this.DiemJS = DiemJS;
            }


            //Method tăng điểm
            public void tangDiem()
            {
                this.DiemCSharp++;
            }

            //Method giảm điểm
            public void giamDiem()
            {
                this.DiemJS--;
            }


            //Method xuất thông tin sinh viên dưới dạng bảng
            public void OutputSinhVien()
            {
                Console.WriteLine("\n\tMa Sinh Vien\t|\tTen Sinh Vien\t|\tC#\t|\tJS  |");
                Console.WriteLine($"    {0}   |   {1}   |\t{2}\t|\t{3}\t|", this.MaSinhVien, this.Ten_SinhVien, this.DiemCSharp, this.DiemJS);
            }

        }

        static void Main(string[] args)
        {

            //Khai bảo mảng sinh viên chưa n phần tử
            int n = 2;
            SinhVien[] sinhvien = new SinhVien[n];

            Console.WriteLine("Nhap thong tin sinh vien :");
            //Nhập thông tin sinh viên
            for (int i = 0; i < n; i++)
            {
                //sinhvien[i] = new SinhVien();
                Console.Write("Nhap ma sinh vien thu {0} : ", i + 1);
                string MaSinhVien = Console.ReadLine();
                Console.Write("Nhap ho ten sinh vien thu {0} :", i + 1);
                string TenSinhVien = Console.ReadLine();
                Console.Write("Nhap diem mon CSharp cua sinh vien thu {0} : ", i + 1);
                float DiemCSharp = Convert.ToSingle(Console.ReadLine());
                Console.Write("Nhap diem mon JS cua sinh vien thu {0} : ", i + 1);
                float DiemJS = Convert.ToSingle(Console.ReadLine());
                Console.WriteLine("-----------------------------------------------------------");

                sinhvien[i] = new SinhVien(MaSinhVien, TenSinhVien, DiemCSharp, DiemJS);
            }
            Console.WriteLine("--------------------------------------------------------------");
            Console.WriteLine("\n\tMa Sinh Vien\t|\tTen Sinh Vien\t|\tC#\t|\tJS  |");
            Console.WriteLine("--------------------------------------------------------------");

            //Xuất thông tin sinh viên
            for (int i = 0; i < n; i++)
            {
                sinhvien[i].OutputSinhVien();
                Console.WriteLine("--------------------------------------------------------------");
            }
        }
    }
}