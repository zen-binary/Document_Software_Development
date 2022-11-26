using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dethi2
{
    internal class Bike
    {
        private int id;
        private string ten;
        private string hsx;

        public Bike()
        {

        }

        public Bike(int id, string ten, string hsx)
        {
            this.id = id;
            this.ten = ten;
            this.hsx = hsx;
        }

        public int Id { get => id; set => id = value; }
        public string Ten { get => ten; set => ten = value; }
        public string Hsx { get => hsx; set => hsx = value; }


        public virtual void inRaManHinh()
        {
            Console.WriteLine($"ID: {Id} | Ten: {Ten} | Hsx: {Hsx}");
        }
    }
}
