package cat.paucasesnovescifp.spaad.jdbc.baseDades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;
import cat.paucasesnovescifp.spaad.jdbc.dades.Autor;
import cat.paucasesnovescifp.spaad.jdbc.dades.Llengua;
import cat.paucasesnovescifp.spaad.jdbc.dades.Llibre;
import cat.paucasesnovescifp.spaad.jdbc.dades.Nacionalitat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ArrayList<Autor> autors = new ArrayList<Autor>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("select * from AUTORS where fk_nacionalitat = ?");) {
            ps.setString(1, nacionalitat.getNom());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autors.add(new Autor(rs.getInt("id_aut"), rs.getString("nom_aut"), rs.getString("fk_nacionalitat")));
            }
        }
        return autors;
    }

    // Exercici 10
    public void insereixNacionalitatAutors(Nacionalitat nacionalitat, ArrayList<Autor> autors) throws SQLException, JDBCException {
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement ps = con.prepareStatement("insert into NACIONALITATS (NACIONALITAT) values (?)");
                PreparedStatement ps2 = con.prepareStatement("insert into AUTORS (id_aut, nom_aut, fk_nacionalitat) "
                        + "values ((select max(id_aut)+1 from AUTORS as total),?,?)");) {
            ps.setString(1, nacionalitat.getNom());
            ps.execute();

            for (Autor autor : autors) {
                ps2.setString(1, autor.getNom_aut());
                ps2.setString(2, nacionalitat.getNom());
                ps2.execute();
            }
        }
    }

    // Exercici 12
    public void esborraNacionalitat(Nacionalitat nacionalitat) throws SQLException, JDBCException {
        try (Connection con = DriverManager.getConnection(url, propietats);
                PreparedStatement st = con.prepareStatement("Delete from AUTORS where FK_NACIONALITAT = ?");
                PreparedStatement st2 = con.prepareStatement("Delete from NACIONALITATS where NACIONALITAT = ?");) {
            st.setString(1, nacionalitat.getNom());
            st2.setString(1, nacionalitat.getNom());
            st.execute();
            st2.execute();
        }
    }

    // Exercici 13
    public void insereixNacionalitatAutorsTransaccio(Nacionalitat nacionalitat, ArrayList<Autor> autors) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, propietats)) {
            try (PreparedStatement ps = con.prepareStatement("insert into NACIONALITATS (NACIONALITAT) values (?)");
                    PreparedStatement ps2 = con.prepareStatement("insert into AUTORS (id_aut, nom_aut, fk_nacionalitat) "
                            + "values ((select max(id_aut)+1 from AUTORS as total),?,?)");) {
                con.setAutoCommit(false);
                ps.setString(1, nacionalitat.getNom());
                ps.execute();

                for (Autor autor : autors) {
                    ps2.setString(1, autor.getNom_aut());
                    ps2.setString(2, nacionalitat.getNom());
                    ps2.execute();
                }
                con.commit();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDades.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Roll back");
                try {
                    if (con != null) {
                        con.rollback();
                    }
                } catch (SQLException se2) {
                    se2.printStackTrace();
                }
            }
        }
    }

    // Exercici 15
    public void corregirLlengua(Llengua llenguaError, Llengua llenguaCorrecta) throws SQLException, JDBCException {
        try (Connection con = DriverManager.getConnection(url, propietats)) {
            try (PreparedStatement ps = con.prepareStatement("insert ignore into LLENGUES (LLENGUA) values (?)");
                    PreparedStatement ps2 = con.prepareStatement("update LLIBRES set FK_LLENGUA = ? where FK_LLENGUA = ?");
                    PreparedStatement ps3 = con.prepareStatement("delete from LLENGUES where LLENGUA = ?");) {
                con.setAutoCommit(false);
                ps.setString(1, llenguaCorrecta.getNom());
                ps.execute();
                
                ps2.setString(1, llenguaCorrecta.getNom());
                ps2.setString(2, llenguaError.getNom());
                ps2.executeUpdate();
                
                ps3.setString(1, llenguaError.getNom());
                ps3.execute();
                
                con.commit();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDades.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Roll back");
                try {
                    if (con != null) {
                        con.rollback();
                    }
                } catch (SQLException se2) {
                    se2.printStackTrace();
                }
            }
        }
    }

}
