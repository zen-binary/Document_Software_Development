using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace ThucHanh
{
    internal class Program
    {
        static void Main(string[] args)
        {
            NhanVien Nv1 = new NhanVien();
            NhanVien Nv2 = new NhanVien();


            ArrayList arrlst = new ArrayList();
            arrlst.Add(Nv1);
            arrlst.Add(Nv2);

        }
    }
}
