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
        public DetailsForm(Object info)
        {
            InitializeComponent();

            if (info.GetType() == typeof(Book))
            {
                listBoxInfo.DataSource = info;
                listBoxInfo.DisplayMember = "ID_LLIB";
            }
        }

        private void DetailsForm_Load(object sender, EventArgs e)
        {

        }
                
        private void bOk_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void bCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
               
    }
}
