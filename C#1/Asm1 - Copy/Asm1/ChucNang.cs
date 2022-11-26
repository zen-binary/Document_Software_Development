using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Asm1
{
    internal class ChucNang
    {
        private List<HocVienCon> _lstHv = new List<HocVienCon>
        {
            new HocVienCon("A" , "a@a.com", 6),
            new HocVienCon("B" , "a@a.com", 4),
            new HocVienCon("C" , "a@a.com", 7),
            new HocVienCon("D" , "a@a.com", 9),
            new HocVienCon("E" , "a@a.com", 4)
        };
        private HocVienCon _Hv;
        private string _input;


        public void addHv()
        {
            Console.WriteLine("Chuong trinh nhap danh sach hoc vien");
            Console.WriteLine("Moi nhap so luong: ");
            _input = Console.ReadLine();
            for (int i = 0; i < Convert.ToInt32(_input); i++)
            {
                _Hv = new HocVienCon();
                Console.WriteLine("Nhap ten: ");
                _Hv.HoTen = Console.ReadLine();
                Console.WriteLine("Nhap email: ");
                _Hv.Email = Console.ReadLine();
                Console.WriteLine("Nhap diem: ");
                _Hv.Diem = Convert.ToSingle(Console.ReadLine());

                _lstHv.Add(_Hv);
            }


        }
        public void inHv()
        {
            Console.WriteLine("Chuong trinh xuat danh sach sinh vien");
            foreach ( var x in _lstHv)
            {
                x.InRaManHinh();
            }

        }
        public void timDiem()
        {
            Console.WriteLine("Chuong trinh tim kiem hoc vien theo khoang diem nhap vao tu ban phim");
        }
        public void timHocLuc()
        {
            Console.WriteLine("Chuong trinh tim hoc vien theo hoc luc nhap vao tu ban phim");
        }
        public void timMaHv()
        {
            Console.WriteLine("Chuong trinh tim hoc vien theo ma so hoc vien ");
        }
        public void SapXep()
        {
            Console.WriteLine("Chuong trinh Sap xep hoc vien theo diem ");
        }
        public void Top5()
        {
            Console.WriteLine("Chuong trinh xuat 5 hoc vien co diem cao nhat ");
        }
        public void DiemTB()
        {
            Console.WriteLine("Chuong trinh tinh diem trung binh cua lop");
        }
        public void DsHocVienTb()
        {
            Console.WriteLine("Chuong trinh xuat danh sach hoc vien co diem trung binh cao hon trung binh lop");
        }
        public void HvTheoHl()
        {
            Console.WriteLine("Chuong trinh tong hop so hoc vien theo hoc luc");
        }
    }
}
