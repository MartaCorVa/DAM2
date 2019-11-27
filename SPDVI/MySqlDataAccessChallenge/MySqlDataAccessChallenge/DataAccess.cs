using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using Dapper;


namespace MySqlDataAccessChallenge
{
    public class DataAccess
    {
        const string connectionString = "Server=127.0.0.1;Port=3306;Database=sakila;Uid=staff;Pwd=$up3r$3cr3t";

        public List<Category> GetCategory()
        {
            List<Category> categories = new List<Category>();
            MySqlConnection con = new MySqlConnection(connectionString);
            string sql = "select name as Name from category";
            categories = con.Query<Category>(sql).ToList();
            return categories;            
        }

        public List<Film> GetFilm(string category)
        {
            List<Film> films = new List<Film>();
            MySqlConnection con = new MySqlConnection(connectionString);
            string sql = "select distinct f.title as Title from film f, film_category fc, category c where " +
                "f.film_id = fc.film_id and " +
                "fc.category_id = c.category_id and " +
                "c.name = '" + category + "' and " +
                "f.rating != 'NC-17' and " +
                "f.rating != 'R'";
            films = con.Query<Film>(sql).ToList();
            return films;
        }

        public List<Film> GetFilmRate(string category)
        {
            List<Film> films = new List<Film>();
            MySqlConnection con = new MySqlConnection(connectionString);
            string sql = "select distinct f.title as Title from film f, film_category fc, category c where " +
                "f.film_id = fc.film_id and " +
                "fc.category_id = c.category_id and " +
                "c.name = '" + category + "'";
            films = con.Query<Film>(sql).ToList();
            return films;
        }

    }
}
