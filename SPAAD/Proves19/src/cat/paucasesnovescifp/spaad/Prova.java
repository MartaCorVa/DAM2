package cat.paucasesnovescifp.spaad;

import java.sql.*;

/**
 *
 * @author marta
 */
public class Prova{

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.1.134:3306/biblioteca?user=lector&password=seCret_19";
        try (Connection con = DriverManager.getConnection(url);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from LLENGUES");) {
            while(rs.next()) {
                String llengua = rs.getString("llengua");
                System.out.println("llengua: " + llengua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}
