using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThucHanh
{
    sealed class GamingComputerCase : NormalComputercase
    {
        public string graphicCard;
        public string LiquidCooling;


        public GamingComputerCase() : base()
        {

        }

        public void BoostPetformance()
        {
            CoreNumberRunning = 8;

        }
        public void BoostPetformance(int numCore)
        {
            if (numCore == 2)
            {
                Console.WriteLine("Core hien tai la 2. Moi ban chon so core cao hon");
            }
            else
            {
                CoreNumberRunning = numCore;
            }
             
            
        }




    }
}
