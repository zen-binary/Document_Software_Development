using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testchep
{
    class Student : Person
    {
        private string msv;
        private int nganh;


        public Student()
        {

        }
        public Student(string ten, string sdt, string msv, int nganh )  : base(ten,sdt)
        {
            this.Msv = msv;
            this.Nganh = nganh;
        }

        public string Msv { get => msv; set => msv = value; }
        public int Nganh { get => nganh; set => nganh = value; }

        public override void InRaManHinh()
        {
            Console.WriteLine($"{Ten} | {Sdt} | {msv} | {Convert.ToString(nganh == 1 ? "UDPM" : nganh==2 ? "Web" : "Mobile") } ");
        }
    }
}
