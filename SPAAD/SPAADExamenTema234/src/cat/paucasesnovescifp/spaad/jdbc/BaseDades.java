package cat.paucasesnovescifp.spaad.jdbc;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;
import cat.paucasesnovescifp.spaad.jdbc.pojos.Illa;
import cat.paucasesnovescifp.spaad.jdbc.pojos.Localitat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BaseDades {
    private String url;
    private Properties propietats;

    public BaseDades(String url, Properties propietats) {
        this.url = url;
        this.propietats = propietats;
    }

    public String getUrl() {
        return url;
    }

    public Properties getPropietats() {
        return propietats;
    }

    public ArrayList<Localitat> tornaLocalitats(String id) throws SQLException, SPAADException {
        ArrayList<Localitat> localitats = new ArrayList<Localitat>();
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from Localitats where idIlla =?");) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                localitats.add(new Localitat(rs.getString("idLocalitat"), rs.getString("nomLocalitat")));
            }
        }
        return localitats;
    }

    public Illa tornaIlla(String id) throws SQLException, SPAADException {
        Illa illa = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement ps = con.prepareStatement("select * from Illes where idIlla =?");) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                illa = new Illa(rs.getString("idIlla"), rs.getString("nomIlla"), tornaLocalitats(id));
            }
        }
        return illa;
    }

}
