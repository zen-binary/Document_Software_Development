using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testdethi1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            SERVICE sv = new SERVICE();
            string _input;
            do
            {
                Console.WriteLine("-----------------------------");
                Console.WriteLine("1. Nhap");
                Console.WriteLine("2. In Ds");
                Console.WriteLine("3. Tim khoang");
                Console.WriteLine("4. Xoa");
                Console.WriteLine("5. Ke Thua");
                Console.WriteLine("-----------------------------");
                Console.WriteLine("Chon: ");
                _input = Console.ReadLine();
                switch (_input)
                {
                    case "1":
                        sv.addGV();
                        break;
                    case "2":
                        sv.inGV();
                        break;
                    case "3":
                        sv.inKhoangGioDay();
                        break;
                    case "4":
                        sv.deleGV();
                        break;
                    case "5":
                        GiaoVienPoly gv = new GiaoVienPoly();
                       
                        gv.inRaManHinh();
                        break;
                    case "0":
                        break;
                    default:
                        break;
                }
            } while (true);
        }
    }
}
