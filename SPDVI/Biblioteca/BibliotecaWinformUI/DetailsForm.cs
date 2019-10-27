using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BibliotecaWinformUI
{
    public partial class DetailsForm : Form
    {
        Book _selectedBook;
        public DetailsForm(Book selected)
        {
            InitializeComponent();
            _selectedBook = selected;
        }

        private void DetailsForm_Load(object sender, EventArgs e)
        {
            Book b = _selectedBook;
            labelTitol.Text = b.TITOL;
            labelID.Text = "ID " + b.ID_LLIB;
            labelDescrip.Text = "Description " + b.Descrip_Llib;
            labelAutor.Text = "Author " + b.NOM_AUT;
        }
                
        private void bOk_Click(object sender, EventArgs e)
        {
            this.Close();
        }               
    }
}
