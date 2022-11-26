using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            sinhvien sv = new sinhvien(name: "ba");
            Console.WriteLine(sv.name);
            sv.name = Console.ReadLine();
            Console.WriteLine(sv.name);
        }
    }
}
