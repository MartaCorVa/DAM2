package cat.paucasesnovescifp.spaad.jdbc.baseDades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;
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

    public ArrayList<String> tornaLlengues() {
        ArrayList<String> llengues = new ArrayList<String>();
        try (Connection con = DriverManager.getConnection(url, propietats);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from LLENGUES");) {
            while (rs.next()) {
                llengues.add(rs.getString("llengua"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llengues;
    }

}
