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
    public partial class BookForm : Form
    {
        private static string connectionString = "Server=localhost;Database=biblioteca;Uid=lector;Pwd=seCret_16;";
        bool existsAuthorsForm = false;
        AuthorForm authorsForm = null;

        public BookForm()
        {
            InitializeComponent();
        }

        private void FindButton_Click(object sender, EventArgs e)
        {
            List<Book> books = new List<Book>();
            MySqlConnection connection = new MySqlConnection(connectionString);
            string sql = $"select l.titol, l.id_llib, l.descrip_llib, a.id_aut, a.nom_aut from " + 
                $"llibres l, autors a, lli_aut la where titol <> \"\" and titol like '%{SearchTextBox.Text}%' " +
            $"and l.id_llib = la.fk_idllib and a.id_aut = la.fk_idaut";
            books = connection.Query<Book>(sql).ToList();

            booksListBox.DataSource = books;
            booksListBox.DisplayMember = "FullInfo";

            connection.Close();
        }

        private void bGoAuthors_Click(object sender, EventArgs e)
        {
            this.Hide(); 
            if (!existsAuthorsForm)
            {
                authorsForm = new AuthorForm();
                authorsForm.Show();
                authorsForm.Location = new Point(this.Location.X + this.Size.Width + 10,
                    this.Location.Y);
                existsAuthorsForm = true;
            }

            authorsForm?.Show();
        }

        private void booksListBox_DoubleClick(object sender, EventArgs e)
        {
            // selected book
            Book selectedInfo = booksListBox.SelectedItem as Book;
            // create DetailsForm
            DetailsForm detailsForm = new DetailsForm(selectedInfo);
            DialogResult result = detailsForm.ShowDialog(this);

            if (result == DialogResult.OK)
            {
                //this.txtResult.Text = testDialog.TextBox1.Text;
            } else if (result == DialogResult.Cancel) 
            {
                //this.txtResult.Text = testDialog.Text
            }
            detailsForm.Dispose();
        }
    }
}
