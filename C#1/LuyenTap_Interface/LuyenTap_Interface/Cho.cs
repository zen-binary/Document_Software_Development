using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LuyenTap_Interface
{
    internal class Cho : Animal
    {
        public void an()
        {
            Console.WriteLine("Cơm");
        }

        public void diChuyen()
        {
            Console.WriteLine("Chạy");
        }

        public void keu()
        {
            Console.WriteLine("Meoww");
        }
    }
}
