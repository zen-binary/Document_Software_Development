using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThucHanh
{
    sealed class Developer : NhanVien 
    {

        public string viTri;
        public string capBac;

        
        public Developer(string ten, int tuoi, int namSinh, string viTri, string capBac) : base(ten,tuoi,namSinh)
        {
            this.viTri = viTri;
            this.capBac = capBac;
        }


        public void ReportDeveloper()
        {
            Console.WriteLine("Bao cao dev");
        }

        public void suaLoiCode()
        {
            Console.WriteLine("fix loi");
        }
    }
}
