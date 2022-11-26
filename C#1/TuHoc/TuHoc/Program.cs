using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TuHoc
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Console.Title = "Hello tự học";
            //Console.ForegroundColor = ConsoleColor.Yellow;
            //Console.BackgroundColor = ConsoleColor.Blue;
            //Console.WriteLine("***********************");
            //Console.WriteLine("*---------------------*");
            //Console.WriteLine("***********************");
            //Console.WriteLine("*---------------------*");
            //Console.WriteLine("***********************");
            //Console.BackgroundColor = ConsoleColor.Black;
            //Console.ForegroundColor = ConsoleColor.Red;



            string name = "";
            int age = 0;
            float mark = 0;
            GetUserInfo(out name, out age, out mark);
            Show(name, age, mark);






        }

        private static void Show(string name, int age, float mark)
        {
            Console.WriteLine("Name " + name);
            Console.WriteLine("age " + age);
            Console.WriteLine("mark " + mark);
        }

        private static void GetUserInfo(out string name, out int age, out float mark)
        {
            Console.WriteLine("Nhap ten: ");
            name = Console.ReadLine();
            age = Convert.ToInt32(Console.ReadLine());
            mark = Convert.ToInt32(Console.ReadLine());

        }
    }
}
