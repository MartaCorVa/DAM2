package cat.paucasesnovescifp.spaad.jdbc.baseDades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;
import cat.paucasesnovescifp.spaad.jdbc.dades.Autor;
import cat.paucasesnovescifp.spaad.jdbc.dades.Nacionalitat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author marta
 */
public class BaseDades {

    private String url;
    private Properties propietats;

    public BaseDades(String url, Properties propietats) throws JDBCException {
        this.setUrl(url);
        this.setPropietats(propietats);
    }

    public String getUrl() {
        return url;
    }

    public Properties getPropietats() {
        return propietats;
    }

    public void setUrl(String url) throws JDBCException {
        if (("").equals(url.trim()) && url == null) {
            throw new JDBCException("Url incorrecte.");
        }
        this.url = url;
    }

    public void setPropietats(Properties propietats) throws JDBCException {
        if (propietats.isEmpty() && propietats == null) {
            throw new JDBCException("Propietats incorrectes.");
        }
        this.propietats = propietats;
    }

    public ArrayList<String> tornaLlengues() throws SQLException {
        ArrayList<String> llengues = new ArrayList<String>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from LLENGUES");) {
            while (rs.next()) {
                llengues.add(rs.getString("llengua"));
            }
        }
        return llengues;
    }
    
    public ArrayList<String> tornaTitolsSegonsLlengua(String llengua) throws SQLException {
        ArrayList<String> titols = new ArrayList<String>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select TITOL from LLIBRES where" + 
                        " fk_llengua ='" + llengua + "'");) {
            while (rs.next()) {
                titols.add(rs.getString("titol"));
            }
        }
        return titols;
    }

    public ArrayList<String> tornaTitolsSegonsLlenguaPS(String llengua) throws SQLException {
        ArrayList<String> titols = new ArrayList<String>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select TITOL from LLIBRES where" + 
                        " fk_llengua =?");) {
            ps.setString(1, llengua);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                titols.add(rs.getString("titol"));
            }
        }
        return titols;
    }
    
    // Exercici 9.1
    public ArrayList<Nacionalitat> getNacionalitats() throws SQLException, JDBCException {
        ArrayList<Nacionalitat> nacionalitats = new ArrayList<Nacionalitat>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select * form nacionalitat");) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nacionalitats.add(new Nacionalitat(rs.getString("nacionalitat")));
            }
        }
        return nacionalitats;
    }
    
    // Exercici 9.2
    public Autor getAutor(int id) throws SQLException {
        Autor autor = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select * form autor where " +
                        "id_aut = ?");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autor = new Autor()
            }
        }
        return autor;
    }
    
}
