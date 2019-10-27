using Dapper;
using MySql.Data.MySqlClient;
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
    public partial class AuthorForm : Form
    {
        private static string connectionString = "Server=localhost;Database=biblioteca;Uid=lector;Pwd=seCret_16;";
        public AuthorForm()
        {
            InitializeComponent();
        }

        private void bSearch_Click(object sender, EventArgs e)
        {
            List<Author> authors = new List<Author>();
            MySqlConnection connection = new MySqlConnection(connectionString);
            string sql = $"select * from autors where nom_aut <> \"\" and nom_aut like '%{infoAuthor.Text}%'";
            authors = connection.Query<Author>(sql).ToList();

            listBoxAuthor.DataSource = authors;
            listBoxAuthor.DisplayMember = "NOM_AUT";

            connection.Close();
        }

        private void bGoBooks_Click(object sender, EventArgs e)
        {
            this.Hide();
            var forms = Application.OpenForms;
            foreach (Form form in forms)
            {
                if (form.Name == "BookForm")
                {
                    form.Show();
                }
            }
        }

        private void AuthorsForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void listBoxAuthor_DoubleClick(object sender, EventArgs e)
        {
            // selected author
            Author selectedInfo = listBoxAuthor.SelectedItem as Author;
            // create DetailsAuthorForm
            DetailsAuthorForm detailsAuthorForm = new DetailsAuthorForm(selectedInfo);
            DialogResult result = detailsAuthorForm.ShowDialog(this);

            if (result == DialogResult.OK)
            {
                //this.txtResult.Text = testDialog.TextBox1.Text;
            }
            else if (result == DialogResult.Cancel)
            {
                //this.txtResult.Text = testDialog.Text
            }
            detailsAuthorForm.Dispose();
        }
    }
}
