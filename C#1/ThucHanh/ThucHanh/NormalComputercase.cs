using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThucHanh
{

    class NormalComputercase
    {
        //
        public string chipSet;
        public string mainBoard;
        public string fan;


        public bool isRunning;
        public bool isCrashing;

        public int CoreNumberRunning;

        public NormalComputercase()
        {
            isRunning = false;
            isCrashing = false;

            CoreNumberRunning = 2;
        }

        

        public void RunMachine()
        {
            isRunning = true;

        }


        public void RestartMachine()
        {
            isCrashing = true;
        }
    }
}
