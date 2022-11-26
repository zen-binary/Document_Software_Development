using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dethi2
{
    internal class BikeNew : Bike
    {
        public BikeNew()
        {

        }

        public BikeNew(int id, string ten, string hsx) : base(id, ten, hsx)
        {

        }

        public override void inRaManHinh()
        {
            Console.WriteLine($"ID: {Id} | Ten: {Ten} | Hsx: {Hsx}");
        }
    }
}
