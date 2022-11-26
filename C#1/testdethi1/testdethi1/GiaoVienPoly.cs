using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testdethi1
{
    internal class GiaoVienPoly:GiaoVien
    {
        private string nganhDay;

        public GiaoVienPoly()
        {
            this.Id = 1;
            this.Ten = "ba";
            this.SoGioDay = 3;
            this.nganhDay = "udm";
        }

        public GiaoVienPoly(int id, string ten, double soGioDay, string nganhDay) : base(id,ten, soGioDay)
        {
            this.nganhDay = nganhDay;
        }

        public string NganhDay { get => nganhDay; set => nganhDay = value; }

        public override void inRaManHinh()
        {
            Console.WriteLine($"ID: {Id} | Ten: {Ten} | SoGioDay: {SoGioDay} | Nganh: {NganhDay}");
        }
    }
}
