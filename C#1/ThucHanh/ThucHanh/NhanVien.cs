using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace ThucHanh
{
    class NhanVien
    {
        public string ten;
        public int tuoi;
        public int namSinh;

        public NhanVien()
        {
            ten = "";
            tuoi = 0;
            namSinh = 0;

        }

        public NhanVien(string ten, int tuoi, int namSinh)
        {
            this.ten = ten;
            this.tuoi = tuoi;
            this.namSinh = namSinh;
        }

        public void Report()
        {
            Console.WriteLine("Bao cao");
        }

        
        

    }
}
