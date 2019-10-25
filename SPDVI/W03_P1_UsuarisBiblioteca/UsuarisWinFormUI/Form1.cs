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

namespace UsuarisWinFormUI
{
    public partial class Form1 : Form
    {
        private string connectionString = "Server=localhost;Database=biblioteca;Uid=usuari;Pwd=seCret_16";
        public Form1()
        {
            InitializeComponent();
        }

        private void bRegister_Click(object sender, EventArgs e)
        {
            if(textBoxPasswd.Text == textBoxCPasswd.Text)
            {
            MySqlConnection con = new MySqlConnection(connectionString);
            string sql = "select max(ID_USR) from USUARIS";
                int newID = 0;
                try
                {
                    newID = con.Query<int>(sql).FirstOrDefault();
                }catch (Exception ex)
                {

                    Console.WriteLine(ex.Message);
                }

            string insert = $"insert into USUARIS (ID_USR, DNI_USR, NOM_USR, LLINATGE1, POB_USR, EMAIL_USR, PASSWD)" +
                $" VALUES ({ newID + 1}, '{textBoxNIF.Text}','{textBoxName.Text}','{textBoxSurname.Text}'," +
                $"'{textBoxCity.Text}','{textBoxEmail.Text}','{textBoxPasswd.Text}')";

                try
                {
                var rowsAffected = con.Execute(insert);
                    if(rowsAffected == 1)
                    {
                        MessageBox.Show("User registered correcty", "User Manager", MessageBoxButtons.OK);
                        textBoxNIF.Text = string.Empty;
                        textBoxName.Text = string.Empty;
                        textBoxSurname.Text = string.Empty;
                        textBoxCity.Text = string.Empty;
                        textBoxEmail.Text = string.Empty;
                        textBoxPasswd.Text = string.Empty;
                        textBoxCPasswd.Text = string.Empty;
                    }
                } catch(MySql.Data.MySqlClient.MySqlException ex)
                {
                    Console.WriteLine(ex.Message);
                }
            
            
            con.Close();
            }            
        }

        private void bFindUser_Click(object sender, EventArgs e)
        {
            listBoxAutor.Items.Clear();
            List<User> users = new List<User>();
            MySqlConnection con = new MySqlConnection(connectionString);
            if(textBoxFindUser.Text == "")
            {
                MessageBox.Show("The User can't be empty.", "User Manager", MessageBoxButtons.OK);
            } else
            {
                string sql = $"SELECT DNI_USR, NOM_USR FROM USUARIS" +
                $" WHERE NOM_USR LIKE '%{textBoxFindUser.Text}%'" +
                $" OR LLINATGE1 LIKE '%{textBoxFindUser.Text}%'" + 
                $" OR POB_USR LIKE '%{textBoxFindUser.Text}%'"; 
                users = con.Query<User>(sql).ToList();
            }

            foreach (var user in users)
            {
                listBoxAutor.Items.Add(user.DNI_USR + " " + user.NOM_USR);
            }
            con.Close();
        }
    }
}
