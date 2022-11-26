using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    internal class sinhvien
    {

        public string name;
        public string mssv;
        public int tuoi;


        

        public sinhvien(string name="hah", string masv="fg", int tuoi=6)
        {
            Console.WriteLine(this.GetHashCode());
            this.name = name;
            this.mssv = masv;
            this.tuoi = tuoi;
        }
    }
}
