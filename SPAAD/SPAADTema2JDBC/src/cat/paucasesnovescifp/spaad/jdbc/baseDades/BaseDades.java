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
                ResultSet rs = st.executeQuery("select TITOL from LLIBRES where"
                        + " fk_llengua ='" + llengua + "'");) {
            while (rs.next()) {
                titols.add(rs.getString("titol"));
            }
        }
        return titols;
    }

    public ArrayList<String> tornaTitolsSegonsLlenguaPS(String llengua) throws SQLException {
        ArrayList<String> titols = new ArrayList<String>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select TITOL from LLIBRES where"
                        + " fk_llengua =?");) {
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
                PreparedStatement ps = con.prepareStatement("select * from NACIONALITATS");) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nacionalitats.add(new Nacionalitat(rs.getString("nacionalitat")));
            }
        }
        return nacionalitats;
    }

    // Exercici 9.2
    public Autor getAutor(int id) throws SQLException, JDBCException {
        Autor autor = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select * from AUTORS where "
                        + "id_aut = ?");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autor = new Autor(rs.getInt("id_aut"), rs.getString("nom_aut"), rs.getString("fk_nacionalitat"));
            }
        }
        return autor;
    }

    // Exercici 9.3
    public ArrayList<Autor> getAutors(Nacionalitat nacionalitat) throws SQLException, JDBCException {
        ArrayList<Autor> autors = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select * from AUTORS where "
                        + "fk_nacionalitat = ?");) {
            ps.setString(1, nacionalitat.getNom());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autors.add(new Autor(rs.getInt("id_aut"), rs.getString("nom_aut"), rs.getString("fk_nacionalitat")));
            }
        }
        return autors;
    }

    // Exercici 11
    public void insereixNacionalitatAutors(Nacionalitat nacionalitat, ArrayList<Autor> autors) throws SQLException, JDBCException {
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("insert into NACIONALITAT (NACIONALITATS) values (?)");
                PreparedStatement ps2 = con.prepareStatement("insert into AUTORS (fk_nacionalitat) values (?) "
                        + "where NOM_AUT = ?");) {
            ps.setString(1, nacionalitat.getNom());
            ps.executeQuery();

            for (int i = 0; i < autors.size(); i++) {
                Autor autor = autors.get(i);
                ps2.setString(1, nacionalitat.getNom());
                ps2.setString(2, autor.getNom_aut());
                ps2.executeQuery();
            }
        }
    }
    
    // Exercici 13
    public void esborraNacionalitat(Nacionalitat nacionalitat) throws SQLException, JDBCException {
        ArrayList<Autor> autors = new ArrayList<Autor>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("insert into NACIONALITAT (NACIONALITATS) values (?)");
                PreparedStatement ps2 = con.prepareStatement("select * from AUTORS where FK_NACIONALITATS = ?");
                PreparedStatement ps3 = con.prepareStatement("insert into NACIONALITAT (NACIONALITATS) values (?)");) {
            ps.setString(1, nacionalitat.getNom());
            ps.executeQuery();
            ps2.setString(1, nacionalitat.getNom());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autors.add(new Autor(rs.getInt("id_aut"), rs.getString("nom_aut"), rs.getString("fk_nacionalitat")));
            }

            for (int i = 0; i < autors.size(); i++) {
                Autor autor = autors.get(i);
                ps2.setString(1, nacionalitat.getNom());
                ps2.setString(2, autor.getNom_aut());
                ps2.executeQuery();
            }
        }
    }

}
