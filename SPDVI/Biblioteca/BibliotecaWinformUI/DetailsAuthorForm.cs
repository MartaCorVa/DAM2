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
    public partial class DetailsAuthorForm : Form
    {
        Author _selectedAuthor;
        public DetailsAuthorForm(Author selectedAuthor)
        {
            InitializeComponent();
            _selectedAuthor = selectedAuthor;
        }

        private void DetailsAuthorForm_Load(object sender, EventArgs e)
        {
            Author a = _selectedAuthor;
            labelNom.Text = a.NOM_AUT;
            labelID.Text = "ID " + a.ID_AUT;
            labelNacionalitat.Text = "Nacionality " + a.FK_NACIONALITAT;
            labelDataNaix.Text = "Birth " + a.DNAIX_AUT;
        }

        private void bOk_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
