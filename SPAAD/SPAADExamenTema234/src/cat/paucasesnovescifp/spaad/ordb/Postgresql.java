package cat.paucasesnovescifp.spaad.ordb;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;
import org.postgresql.PGConnection;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;

public class Postgresql {
    private String url;
    private Properties propietats;

    public Postgresql(String url, Properties propietats) throws SPAADException {
        if (("").equals(url.trim()) && url == null) {
            throw new SPAADException("Url incorrecte.");
        }
        if (propietats.isEmpty() && propietats == null) {
            throw new SPAADException("Propietats incorrectes.");
        }
        this.url = url;
        this.propietats = propietats;
    }

    public String getUrl() {
        return url;
    }

    public Properties getPropietats() {
        return propietats;
    }

    public Assistent tornaAssistent(String nif) throws SQLException, SPAADException {
        Assistent assistent = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from \"Examen\".\"Assistents\" where nif_assistent =?")){
            PGConnection conpg = (PGConnection) con;
            conpg.addDataType("titols_projectes", cat.paucasesnovescifp.spaad.ordb.T_titols_projectes.class);
            ps.setString(1,nif);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                T_titols_projectes titols = new T_titols_projectes();
                titols.setValue(rs.getObject("titols").toString());
                assistent = new Assistent(rs.getString("nif_assistent"), rs.getString("nom_assistent"), titols);
            }
        }
        return assistent;
    }
}
