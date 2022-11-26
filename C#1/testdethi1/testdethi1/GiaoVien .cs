using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testdethi1
{
    internal class GiaoVien
    {
        private int id;
        private string ten;
        private double soGioDay;



        public GiaoVien()
        {

        }

        public GiaoVien(int id, string ten, double soGioDay)
        {
            this.id = id;
            this.ten = ten;
            this.soGioDay = soGioDay;
        }

        public int Id { get => id; set => id = value; }
        public string Ten { get => ten; set => ten = value; }
        public double SoGioDay { get => soGioDay; set => soGioDay = value; }


        public virtual void inRaManHinh()
        {
            Console.WriteLine($"ID: {Id} | Ten: {Ten} | SoGioDay: {soGioDay}");
        }

    }
}
