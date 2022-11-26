using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Asm1
{
    internal class HocVien
    {
        private string hoTen;
        private string email;
        

        public HocVien()
        {

        }
        public HocVien(string hoTen, string email)
        {
            this.HoTen = hoTen;
            this.Email = email;
            
        }


        public string HoTen { get => hoTen; set => hoTen = value; }
        public string Email { get => email; set => email = value; }


        public virtual void InRaManHinh()
        {

        }


        

        
    }
}
