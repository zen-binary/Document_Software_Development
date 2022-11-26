using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testdethi1
{
    internal class SERVICE
    {
        private List<GiaoVien> _lstGv = new List<GiaoVien>();
        private GiaoVien _Gv;
        private string _input;

        public void addGV()
        {
            string n;

            do
            {
                Console.Write("Nhap so luong muon them: ");
                _input = Console.ReadLine();

                for (int i = 0; i < Convert.ToInt32(_input); i++)
                {
                    _Gv = new GiaoVien();
                    Console.WriteLine("Nhap id: ");
                    _Gv.Id = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Nhap ten: ");
                    _Gv.Ten = Console.ReadLine();
                    Console.WriteLine("Nhap so gio day: ");
                    _Gv.SoGioDay = Convert.ToDouble(Console.ReadLine());
                    _lstGv.Add(_Gv);
                }
                Console.WriteLine("Co nhap tiep hay k (y/n)");

                n = Console.ReadLine();

            } while (n=="y");

        }
        public void inGV()
        {
            if (_lstGv.Count == 0)
            {
                Console.WriteLine("Vui long them danh sach");
                addGV();
            }
            else
            {
                for (int i = 0; i < _lstGv.Count; i++)
                {
                    _lstGv[i].inRaManHinh();
                }
            }

            
        }
        public void inKhoangGioDay()
        {
            Console.WriteLine("Nhap khoang 1: ");
            double k1 = Convert.ToDouble(Console.ReadLine()); 
            Console.WriteLine("Nhap khoang 2: ");
            double k2 = Convert.ToDouble(Console.ReadLine());

            for (int i = 0; i < _lstGv.Count; i++)
            {
                if (_lstGv[i].SoGioDay > Math.Min(k1,k2) && _lstGv[i].SoGioDay < Math.Max(k1, k2))
                {
                    _lstGv[i].inRaManHinh();
                }
            }
        }
        public void deleGV()
        {
            int check=0;
            for (int i = 0; i < _lstGv.Count; i++)
            {
                if (_lstGv[i].Id %2==0)
                {
                    _lstGv.RemoveAt(i);
                    check++;
                }
                
            }
            if (check != 0)
            {
                Console.WriteLine("Da xoa: " + check);
            }
            else
            {
                Console.WriteLine("khong tim thay j ");
            }
            
        }

    }
}
