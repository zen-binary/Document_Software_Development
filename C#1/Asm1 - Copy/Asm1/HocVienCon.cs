using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Asm1
{
    internal class HocVienCon:HocVien
    {
        private float diem;

        public HocVienCon()
        {
        }

        public HocVienCon(string hoTen, string email, float diem) : base(hoTen, email)
        {
            this.diem = diem;
        }

        public float Diem { get => diem; set => diem = value; }

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

        public override void InRaManHinh()
        {
            Console.WriteLine($"{HoTen} | {Email} | {diem} | {checkHL(Diem)} ");
        }

        
    }
}
