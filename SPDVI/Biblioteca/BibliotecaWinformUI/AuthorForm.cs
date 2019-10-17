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

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void AuthorForm_Load(object sender, EventArgs e)
        {

        }

        private void bSearch_Click(object sender, EventArgs e)
        {
            List<Author> authors = new List<Author>();
            MySqlConnection connection = new MySqlConnection(connectionString);
            string sql = $"select nom_aut from autors where nom_aut <> \"\" and nom_aut like '%{infoAuthor.Text}%'";
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
                if (form.Name == "BibliotecaMainForm")
                {
                    form.Show();
                }
            }
        }

        private void AuthorsForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }
               
    }
}
