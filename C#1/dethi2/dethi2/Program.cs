using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dethi2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Service sv = new Service();
            string input;
            do
            {
                Console.WriteLine("-------------------------");
                Console.WriteLine("1. Nhap danh sach bike ");
                Console.WriteLine("2. Xuat danh sach bike ");
                Console.WriteLine("3. Xuat danh sach bike hang HonDa");
                Console.WriteLine("4. Sap xep theo id giam dan");
                Console.WriteLine("5. Ke thua");
                Console.WriteLine("0. Thoat");
                Console.WriteLine("--------------------------");
                input = Console.ReadLine();
                switch (input)
                {
                    case "1":
                        sv.addBike();
                        break;
                    case "2":
                        sv.inBike();
                        break;
                    case "3":
                        sv.inBikeHonDa();
                        break;
                    case "4":
                        sv.SapXepId();
                        break;
                    case "5":
                        BikeNew bike2 = new BikeNew(2,"bac", "jas");
                        bike2.inRaManHinh();
                        break;
                    case "6":
                        sv.RemoveBike();
                        break;
                    case "0":
                        break;

                    default:
                        Console.WriteLine("vui long nhap lai");
                        break;
                } 
            } while (input!="0");
        }
    }
}
