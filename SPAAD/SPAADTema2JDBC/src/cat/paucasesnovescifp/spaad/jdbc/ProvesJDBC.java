package cat.paucasesnovescifp.spaad.jdbc;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;
import cat.paucasesnovescifp.spaad.jdbc.baseDades.BaseDades;
import cat.paucasesnovescifp.spaad.jdbc.dades.Autor;
import cat.paucasesnovescifp.spaad.jdbc.dades.Llengua;
import cat.paucasesnovescifp.spaad.jdbc.dades.Nacionalitat;
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
        propietats.put("user", "usuari");
        propietats.put("password", "seCret_19");

        try {
            BaseDades bbdd = new BaseDades(url, propietats);

            // Exercici 4
            System.out.println("Llengües: ");
            ArrayList<String> llengues = bbdd.tornaLlengues();
            for (String llengua : llengues) {
                System.out.println(llengua);
            }
            System.out.println();
            // Explosión
            // ArrayList<String> titols = bbdd.tornaTitolsSegonsLlengua("Anglesa' or 1=1; -- ");

            // Exercici 6
            System.out.println("Títol segons llengua: ");
            ArrayList<String> titols = bbdd.tornaTitolsSegonsLlengua("Anglesa");
            for (String titol : titols) {
                System.out.println(titol);
            }
            System.out.println();

            // Exercici 7
            System.out.println("Títol segons llengua PS: ");
            ArrayList<String> titolsPS = bbdd.tornaTitolsSegonsLlenguaPS("Anglesa");
            for (String titol : titolsPS) {
                System.out.println(titol);
            }
            System.out.println();

            // Exercici 9.1
            System.out.println("Nacionalitats:");
            ArrayList<Nacionalitat> nacionalitats = bbdd.getNacionalitats();
            for (Nacionalitat nacionalitat : nacionalitats) {
                System.out.println(nacionalitat.getNom());
            }
            System.out.println();

            // Exercici 9.2
            System.out.println("Torna autor segons id:");
            System.out.println(bbdd.getAutor(1));
            System.out.println();

            //Exercici 9.3
            System.out.println("Autors segons nacionalitat:");
            ArrayList<Autor> autors = bbdd.getAutors(new Nacionalitat("Anglesa"));
            for (Autor autor : autors) {
                System.out.println(autor);
            }
            System.out.println();

            // Exercici 10
            System.out.println("Esborra nacionalitat i insereix nacionalitat:");
            ArrayList<Autor> autors2 = new ArrayList<Autor>();
            autors2.add(new Autor(9000, "Joselito Garcia", "hola"));
            autors2.add(new Autor(9001, "Manolo Conga", "hola"));
            bbdd.esborraNacionalitat(new Nacionalitat("spaad"));
            bbdd.insereixNacionalitatAutors(new Nacionalitat("spaad"), autors2);
            System.out.println(bbdd.getAutor(6550));
            System.out.println(bbdd.getAutor(6551));
            bbdd.esborraNacionalitat(new Nacionalitat("spaad"));
            
            // Exercici 14
            //System.out.println("Errada a insereixNacionalitatAutorsTransaccio():");
            //bbdd.insereixNacionalitatAutorsTransaccio(new Nacionalitat("ESLOVACA"), autors);
            
            // Exercici 15
            bbdd.corregirLlengua(new Llengua("hula"), new Llengua("Catala"));

        } catch (JDBCException ex) {
            Logger.getLogger(ProvesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProvesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
