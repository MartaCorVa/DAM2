package cat.paucasesnovescifp.spaad.baseDades;

import cat.paucasesnovescifp.spaad.auxiliars.ORDBException;
import cat.paucasesnovescifp.spaad.entitats.*;
import org.postgresql.PGConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BaseDades {

    private String url;
    private Properties propietats;

    public BaseDades(String url, Properties propietats) throws ORDBException {
        this.setUrl(url);
        this.setPropietats(propietats);
    }

    public String getUrl() {
        return url;
    }

    public Properties getPropietats() {
        return propietats;
    }

    public void setUrl(String url) throws ORDBException {
        if (("").equals(url.trim()) && url == null) {
            throw new ORDBException("Url incorrecte.");
        }
        this.url = url;
    }

    public void setPropietats(Properties propietats) throws ORDBException {
        if (propietats.isEmpty() && propietats == null) {
            throw new ORDBException("Propietats incorrectes.");
        }
        this.propietats = propietats;
    }

    // Recuperar un cicle per l'identificador
    public Cicle tornaCicle(String codi) throws ORDBException, SQLException {
        Cicle cicle = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Cicles\" where codi =?")){
                ps.setString(1,codi);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cicle = new Cicle(rs.getString("codi"), rs.getString("nom"));
                }
            }
        return cicle;
    }

    // Recuperar una assignatura per l'identificador.
    public Assignatura tornaAssignatura(String codi) throws ORDBException, SQLException{
        Assignatura assignatura = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Assignatures\" where codi =?")){
                ps.setString(1,codi);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    assignatura = new Assignatura(rs.getString("codi"), rs.getString("nom") , tornaCicle(rs.getString("cicle_codi")));
                }
            }
        return assignatura;
    }

    // Recuperar un alumne per l'identificador (excepte contacte).
    public Alumne tornaAlumne(String nif) throws ORDBException, SQLException{
        Alumne alumne = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Alumnes\" where nif =?")){
                ps.setString(1,nif);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    alumne = new Alumne(rs.getString("nif"), rs.getString("nom"), rs.getString("llinatges"));
                }
            }
        return alumne;
    }

    // Recuperar una matrícula per l'identificador.
    public Matricula tornaMatricula(String nif) throws ORDBException, SQLException{
        Matricula matricula = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Matricula\" where alumnes_nif =?")){
                ps.setString(1,nif);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Array array = rs.getArray("notes");
                    Integer[] notes = (Integer[]) array.getArray();
                    matricula = new Matricula(tornaAlumne(nif), tornaAssignatura(rs.getString("assignatura_codi")), notes);
                    array.free();
                }
            }
        return matricula;
    }

    // Recuperar tots els alumnes de la base de dades.
    public ArrayList<Alumne> tornaTotsAlumnes() throws ORDBException, SQLException{
        ArrayList<Alumne> alumnes = new ArrayList<Alumne>();
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Alumnes\"")){
                PGConnection conpg = (PGConnection) con;
                conpg.addDataType("contacte", cat.paucasesnovescifp.spaad.entitats.T_dades_contacte.class);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    T_dades_contacte contacte = new T_dades_contacte();
                    contacte.setValue(rs.getObject("contacte").toString());
                    alumnes.add(new Alumne(rs.getString("nif"), rs.getString("nom"), rs.getString("llinatges"), contacte));
                }
            }
        return alumnes;
    }

    // Recuperar totes les matricules d'un alumne.
    public ArrayList<Matricula> tornaMatriculaAlumne(Alumne alumne) throws SQLException, ORDBException {
        ArrayList<Matricula> matricules = new ArrayList<Matricula>();
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Matricula\" where alumnes_nif = ?")){
            ps.setString(1, alumne.getNif());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Array array = rs.getArray("notes");
                Integer[] notes = (Integer[]) array.getArray();
                matricules.add(new Matricula(tornaAlumne(alumne.getNif()), tornaAssignatura(rs.getString("assignatura_codi")), notes));
                array.free();
            }
        }
        return matricules;
    }

    // 7 Recuperar totes les matricules d'una assignatura.
    public ArrayList<Matricula> tornaMatriculaAssignatura(Assignatura assignatura) throws SQLException, ORDBException {
        ArrayList<Matricula> matricules = new ArrayList<Matricula>();
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Matricula\" where assignatura_codi = ?")){
            ps.setString(1, assignatura.getCodi());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Array array = rs.getArray("notes");
                Integer[] notes = (Integer[]) array.getArray();
                matricules.add(new Matricula(tornaAlumne(rs.getString("alumnes_nif")), tornaAssignatura(assignatura.getCodi()), notes));
                array.free();
            }
        }
        return matricules;
    }

    // 8 Modificar una de les notes d'una assignatura d'un alumne.
    public void modificarNota(Assignatura assignatura, Alumne alumne, int novaNota, int posicioNota) throws SQLException, ORDBException {
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("update \"Institut\".\"Matricula\" set " +
                     "notes[?] = ? where assignatura_codi = ? and alumnes_nif = ?")){
            ps.setInt(1, posicioNota);
            ps.setInt(2, novaNota);
            ps.setString(3, assignatura.getCodi());
            ps.setString(4, alumne.getNif());
            ps.executeUpdate();
        }
    }

    // 9 Recuperar un alumne per l'identificador (inclòs contacte).
    public Alumne tornaAlumneContacte(String nif) throws ORDBException, SQLException{
        Alumne alumne = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Institut\".\"Alumnes\" where nif =?")){
            PGConnection conpg = (PGConnection) con;
            conpg.addDataType("contacte", cat.paucasesnovescifp.spaad.entitats.T_dades_contacte.class);
            ps.setString(1,nif);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                T_dades_contacte contacte = new T_dades_contacte();
                contacte.setValue(rs.getObject("contacte").toString());
                alumne = new Alumne(rs.getString("nif"), rs.getString("nom"), rs.getString("llinatges"), contacte);
            }
        }
        return alumne;
    }

    // 10 Afegir un alumne nou a la base de dades.
    public void afegirAlumne(Alumne alumne) throws SQLException, ORDBException {
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("insert into \"Institut\".\"Alumnes\" " +
                     "(nif, nom, llinatges, contacte) values (?,?,?,ROW(?,?,?))")){
            ps.setString(1, alumne.getNif());
            ps.setString(2, alumne.getNom());
            ps.setString(3, alumne.getLlinatges());
            ps.setString(4, alumne.getContacte().getTelefon());
            ps.setString(5, alumne.getContacte().getCorreu_electronic());
            ps.setString(6, alumne.getContacte().getUsuari_twitter());
            ps.execute();
        }
    }

    // 11 Matricular un alumne a una assignatura.
    public void matricularAlumne(Alumne alumne, Assignatura assignatura) throws SQLException, ORDBException {
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("insert into \"Institut\".\"Matricula\" " +
                     "(alumnes_nif, assignatura_codi) values (?,?)")){
            ps.setString(1, alumne.getNif());
            ps.setString(2, assignatura.getCodi());
            ps.execute();
        }
    }

    // 12 Afegir les notes d'aquest alumne nou per a una assignatura.
    public void afegirNotes(Alumne alumne, Assignatura assignatura, Integer[] n) throws SQLException, ORDBException {
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("update \"Institut\".\"Matricula\" " +
                     "set notes = ? where alumnes_nif = ? and assignatura_codi = ?")){
            ps.setArray(1, con.createArrayOf("Integer", n));
            ps.setString(2, alumne.getNif());
            ps.setString(3, assignatura.getCodi());
            ps.executeUpdate();
        }
    }

}
