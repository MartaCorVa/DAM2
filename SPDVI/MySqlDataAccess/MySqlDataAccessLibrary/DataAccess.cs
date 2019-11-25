using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using Dapper;

namespace MySqlDataAccessLibrary
{
    public class DataAccess
    {

        const string connectionString = "Server=127.0.0.1;Port=3306;Database=biblioteca;Uid=lector;Pwd=seCret_16";

        public Book GetRandomBook()
        {
            MySqlConnection con = new MySqlConnection(connectionString);
            string sql = "select id_llib as Id, titol as Title, descrip_llib as Description, fk_departament as Department, " +
                "fk_llengua as Language from llibres order by rand() limit 1";
            Book book = con.Query<Book>(sql).FirstOrDefault();
            return book;
        }

        public Author GetRandomAuthor()
        {
            MySqlConnection con = new MySqlConnection(connectionString);
            string sql = "select nom_aut as Nom from autors order by rand() limit 1";
            Author author = con.Query<Author>(sql).FirstOrDefault();
            return author;
        }
    }
}
