package cat.paucasesnovescifp.spaad.jdbc;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;
import cat.paucasesnovescifp.spaad.jdbc.baseDades.BaseDades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class ProvesJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.1.134:3306/biblioteca";
        Properties propietats = new Properties();
        propietats.put("user", "lector");
        propietats.put("password", "seCret_19");

        try {
            BaseDades bbdd = new BaseDades(url, propietats);
            ArrayList<String> llengues = bbdd.tornaLlengues();
            for (String llengua : llengues) {
                System.out.println(llengua);
            }
        } catch (JDBCException ex) {
            Logger.getLogger(ProvesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
