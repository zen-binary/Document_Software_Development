using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testchep
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StudentService ss = new StudentService();
            do
            {
                Console.WriteLine("Quan ly sinh vien");
                Console.WriteLine("1. Them");
                Console.WriteLine("2. Sua");
                Console.WriteLine("3. Xoa");
                Console.WriteLine("4. In ds");
                Console.WriteLine("5. Tim kiem");
                Console.WriteLine("6. Loc theo nha mang");
                Console.WriteLine("moi ban chon chuc nang: ");
                string input = Console.ReadLine();
                switch (input)
                {
                    case "1":
                        ss.addStudent();
                        break;
                    case "2":
                        ss.editStudent();
                        break;
                    case "3":
                        ss.removeStudent();

                        break;
                    case "4":
                        ss.getStudent();
                        break;
                    case "5":
                        ss.findStudent();
                        break;
                    case "6":
                        ss.filterStudent();
                        break;
                    default:
                        break;
                }
            } while (true);
        }
    }
}
