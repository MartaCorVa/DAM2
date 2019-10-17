using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BibliotecaWinformUI
{
    public class Book
    {
        public string TITOL { get; set; }
        public int ID_LLIB { get; set; }
        public string FullInfo
        {
            get
            {
                return ID_LLIB + ". " + TITOL;
            }
        }
            }
}
