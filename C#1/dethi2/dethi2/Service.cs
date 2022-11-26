using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dethi2
{
    internal class Service
    {
        List<Bike> _lstbike = new List<Bike>();
        Bike _bike;
        private string _input;

        public Service()
        {


        }


        public void addBike()
        {
            string n;
            do
            {
                Console.WriteLine("Nhap so luong: ");
                _input = Console.ReadLine();
                for (int i = 0; i < Convert.ToInt32(_input); i++)
                {
                    _bike = new Bike();
                    Console.WriteLine("Nhap Id: ");
                    _bike.Id = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Nhap Ten: ");
                    _bike.Ten = Console.ReadLine();
                    Console.WriteLine("Nhap HXS: ");
                    _bike.Hsx = Console.ReadLine();
                    _lstbike.Add(_bike);



                }
                Console.WriteLine("Ban co muon nhap tiep hay k(y/n)");
                n = Console.ReadLine();
            } while (n == "y");

        }
        public void inBike()
        {

            if (_lstbike.Count <= 0)
            {
                Console.WriteLine("Vi chua co bike nao vui long nhap");
                addBike();
            }
            else
            {
                Console.WriteLine("In bike");
                for (int i = 0; i < _lstbike.Count; i++)
                {

                    _lstbike[i].inRaManHinh();

                }

            }


        }
        public void inBikeHonDa()
        {
            for (int i = 0; i < _lstbike.Count; i++)
            {
                if (_lstbike[i].Hsx == "HonDa")
                {
                    _lstbike[i].inRaManHinh();
                }
            }

        }
        public void SapXepId()
        {
            Console.WriteLine("Sap xep id ");
            _lstbike = _lstbike.OrderByDescending(x => x.Id).ToList();

            for (int i = 0; i < _lstbike.Count; i++)
            {
                _lstbike[i].inRaManHinh();

            }
        }


        public void RemoveBike()
        {
            Console.WriteLine("Nhap id can xoa");
            int n = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < _lstbike.Count; i++)
            {
                if (_lstbike[i].Id==n)
                {
                    _lstbike.RemoveAt(i);
                }
               

            }
        }



    }
}
