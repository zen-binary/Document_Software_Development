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

        private List<HocVien> _lstHv = new List<HocVien>

        {
            new HocVien("P01","A" , "a@a.com", 6),
            new HocVien("P02","B" , "a@a.com", 4),
            new HocVien("P03","C" , "a@a.com", 7),
            new HocVien("P04","D" , "a@a.com", 9),
            new HocVien("P05","E" , "a@a.com", 4)
        };
        private HocVien _Hv;
        private string _input;


        public void addHv()
        {
            Console.WriteLine("Chuong trinh nhap danh sach hoc vien");
            Console.WriteLine("Moi nhap so luong: ");
            _input = Console.ReadLine();
            for (int i = 0; i < Convert.ToInt32(_input); i++)
            {

                _Hv = new HocVien();
                Console.WriteLine("Nhap MsHV: ");
                _Hv.MsHv = Console.ReadLine();
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
            foreach (var x in _lstHv)
            {
                x.InRaManHinh();
            }
            Console.ReadKey();

        }
        public void timDiem()
        {
            Console.WriteLine("Chuong trinh tim kiem hoc vien theo khoang diem nhap vao tu ban phim");
            Console.WriteLine("Nhap diem khoang 1 muon tim: ");
            float k1 = Convert.ToSingle(Console.ReadLine());
            Console.WriteLine("Nhap diem khoang 2 muon tim: ");
            float k2 = Convert.ToSingle(Console.ReadLine());
            Console.WriteLine("Sinh vien co diem tu {0} den {1} ", k1, k2);
            for (int i = 0; i < _lstHv.Count; i++)
            {
                if (Math.Min(k1, k2) <= _lstHv[i].Diem && Math.Max(k1, k2) >= _lstHv[i].Diem)
                {

                    _lstHv[i].InRaManHinh();
                }
            }
        }
        public void timHocLuc()
        {
            //Console.WriteLine("Chuong trinh tim hoc vien theo hoc luc nhap vao tu ban phim");
            //Console.WriteLine("Moi chon hoc luc");
            //Console.WriteLine("1. Kem");
            //Console.WriteLine("2. Yeu");
            //Console.WriteLine("3. Trung Binh");
            //Console.WriteLine("4. Kha");
            //Console.WriteLine("5. Gioi");
            //Console.WriteLine("6. Xuat Xac");
            //Console.Write("chon: ");
            //string HL = "";
            //_input = Console.ReadLine();
            //switch (_input)
            //{
            //    case "1":
            //        HL = "Kem";
            //        break;
            //    case "2":
            //        HL = "Yeu";
            //        break;
            //    case "3":
            //        HL = "Trung Binh";
            //        break;
            //    case "4":
            //        HL = "Kha";
            //        break;
            //    case "5":
            //        HL = "Gioi";
            //        break;
            //    case "6":
            //        HL = "Xuat Xac";
            //        break;
            //    default:
            //        Console.WriteLine("Vui long chon lai");
            //        break;

            //}
            //for (int i = 0; i < _lstHv.Count; i++)
            //{
            //    if ()
            //    {
            //        _lstHv[i].InRaManHinh();
            //    }
            //}
        }
        public void timMaHv()
        {
            Console.WriteLine("Chuong trinh tim hoc vien theo ma so hoc vien ");
            Console.WriteLine("Nhap mshv: ");
            _input = Console.ReadLine();
            int vitri = 0;
            for (int i = 0; i < _lstHv.Count; i++)
            {
                if (_input == _lstHv[i].MsHv)
                {
                    vitri = i;
                    _lstHv[i].InRaManHinh();
                }
            }

            string input1;
            string input2;
            Console.WriteLine("Ban muon update khong:");
            Console.Write("y/n: ");

            input1 = Console.ReadLine();
            switch (input1)
            {
                case "y":
                    {
                        Console.WriteLine("Ban muon sua:");
                        Console.WriteLine("1. Ten");
                        Console.WriteLine("2. Email");
                        Console.WriteLine("3. Diem");
                        input2 = Console.ReadLine();
                        switch (input2)
                        {
                            case "1":
                                Console.WriteLine("Vui long nhap ten moi");
                                _lstHv[Convert.ToInt32(vitri)].HoTen = Console.ReadLine();
                                break;
                            case "2":
                                Console.WriteLine("Vui long nhap email moi");
                                _lstHv[Convert.ToInt32(vitri)].Email = Console.ReadLine();
                                break;
                            case "3":
                                Console.WriteLine("Vui long nhap diem moi");
                                _lstHv[Convert.ToInt32(vitri)].Diem = Convert.ToSingle(Console.ReadLine());
                                break;
                            default:
                                Console.WriteLine("Vui long chon lai");
                                break;
                        }
                    }
                    break;
                case "n":
                    Console.WriteLine("Ban chon NO");
                    break;
                default:
                    Console.WriteLine("Vui long chon lai");
                    break;
            }
        }
        public void SapXep()
        {
            Console.WriteLine("Chuong trinh Sap xep hoc vien theo diem ");
            _lstHv=_lstHv.OrderByDescending(a => a.Diem).ToList();
            


        }
        public void Top5()
        {
            Console.WriteLine("Chuong trinh xuat 5 hoc vien co diem cao nhat ");
            SapXep();
            for (int i = 0; i < 5; i++)
            {
                _lstHv[i].InRaManHinh();

            }
        }
        public void DiemTB()
        {
            Console.WriteLine("Chuong trinh tinh diem trung binh cua lop");

            float dTB = 0;
            int temp = 0;
            for (int i = 0; i < _lstHv.Count; i++)
            {
                dTB = dTB + _lstHv[i].Diem;
                temp++;
            }
            dTB = dTB / temp;
            Console.WriteLine("Diem Trung Binh cua lop: " + dTB);
        }
        public void DsHocVienTb()
        {
            Console.WriteLine("Chuong trinh xuat danh sach hoc vien co diem trung binh cao hon trung binh lop");
            float dTB = 0;
            int temp = 0;
            for (int i = 0; i < _lstHv.Count; i++)
            {
                dTB = dTB + _lstHv[i].Diem;
                temp++;
            }

            dTB = dTB / temp;
            Console.WriteLine("Diem Trung Binh cua lop: " + dTB);
            for (int i = 0; i < _lstHv.Count; i++)
            {
                if (_lstHv[i].Diem > dTB)
                {
                    _lstHv[i].InRaManHinh();
                }
            }

        }
        public void HvTheoHl()
        {
            Console.WriteLine("Chuong trinh tong hop so hoc vien theo hoc luc");
            int a;
            int b;
                int c;
            int kem = 0;
            int yeu = 0;
            int tb = 0;
            int kha = 0;
            int gioi = 0;
            int xuatxac = 0;
            for (int i = 0; i < _lstHv.Count; i++)
            {
                if (_lstHv[i].Diem < 3)
                {
                    kem++;
                }
                else if (_lstHv[i].Diem >= 3 && _lstHv[i].Diem < 5)
                {
                    yeu++;
                }
                else if (_lstHv[i].Diem >= 5 && _lstHv[i].Diem < 6.5)
                {
                    tb++;
                }
                else if (_lstHv[i].Diem >= 6.5 && _lstHv[i].Diem < 7.5)
                {
                    kha++;
                }
                else if (_lstHv[i].Diem >= 7.5 && _lstHv[i].Diem < 9)
                {
                    gioi++;
                }
                else if (_lstHv[i].Diem >= 9)
                {
                    xuatxac++;
                }
            }

            Console.WriteLine("kem = " + kem);
            Console.WriteLine("Yeu = " + yeu);
            Console.WriteLine("trung binh = " + tb);
            Console.WriteLine("kha = " + kha);
            Console.WriteLine("gioi = " + gioi);
            Console.WriteLine("xuatxac = " + xuatxac);


        }
    }
}
