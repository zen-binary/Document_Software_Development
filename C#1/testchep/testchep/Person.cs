﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testchep
{
    internal class Person
    {
        private string ten;
        private string sdt;

        public Person()
        {

        }

        public Person(string ten, string sdt)
        {
            this.Ten = ten;
            this.Sdt = sdt;
        }

        public string Ten
        {
            get => ten;
            set => ten = value;
        }
        public string Sdt
        { 
            get => sdt; 
            set => sdt = value; 
        }

        public virtual void InRaManHinh()
        {

        }
    }
}
