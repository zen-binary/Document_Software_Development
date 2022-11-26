using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Asm1
{
    internal class HocVien
    {
        private string msHv;
        private string hoTen;
        private string email;
        private float diem;


        public HocVien()
        {

        }
        public HocVien(string msHv, string hoTen, string email, float diem)
        {
            this.MsHv = msHv;
            this.HoTen = hoTen;
            this.Email = email;
            this.Diem = diem;
            
        }


        public string HoTen { get => hoTen; set => hoTen = value; }
        public string Email { get => email; set => email = value; }
        public float Diem { get => diem; set => diem = value; }
        public string MsHv { get => msHv; set => msHv = value; }

        public string checkHL(float diem)
        {
            string HL = "";
            if (diem < 3)
            {
                HL = "Kem";
            }
            else if (diem >= 3 && diem < 5)
            {
                HL = "Yeu";
            }
            else if (diem >= 5 && diem < 6.5)
            {
                HL = "Trung Binh";
            }
            else if (diem >= 6.5 && diem < 7.5)
            {
                HL = "Kha";
            }
            else if (diem >= 7.5 && diem < 9)
            {
                HL = "Gioi";
            }
            else if (diem >= 9)
            {
                HL = "Xuat Xac";
            }

            return HL;
        }
        public void InRaManHinh()
        {
            Console.WriteLine($"{MsHv} | {HoTen} | {Email} | {diem} | {checkHL(Diem)} ");
        }





    }
}
