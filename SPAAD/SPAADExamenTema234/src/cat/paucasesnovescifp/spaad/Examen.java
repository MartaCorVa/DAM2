package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;
import cat.paucasesnovescifp.spaad.jdbc.BaseDades;
import cat.paucasesnovescifp.spaad.jdbc.pojos.Localitat;
import cat.paucasesnovescifp.spaad.jpa.JPA;
import cat.paucasesnovescifp.spaad.jpa.entitats.Editor;
import cat.paucasesnovescifp.spaad.ordb.Postgresql;

import java.sql.SQLException;
import java.util.Properties;

public class Examen {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.56.95:3306/interins";
        Properties propietats = new Properties();
        propietats.put("user", "usuari");
        propietats.put("password", "seCret_19");
        String unitatPersistencia = "biblioteca-pu";

        try {
            BaseDades bbdd = new BaseDades(url, propietats);

            // Exercici 01
            for (Localitat l : bbdd.tornaLocalitats("074")) {
                System.out.println(l);
            }

            // Exercici 02
            System.out.println(bbdd.tornaIlla("074"));

            // Exerici 03
            JPA jpa = new JPA(unitatPersistencia);

            System.out.println(jpa.tornaEditor(1));

            // Exercici 04
            for (Editor e : jpa.tornaEditors(0,10)) {
                System.out.println(e);
            }

            // Exercici 05
            System.out.println(jpa.tornaEditor("LA BUSCA EDICIONS"));

            // Exercici 09
            Postgresql psql = new Postgresql("jdbc:postgresql://192.168.56.95:5432/basedades", propietats);
            System.out.println(psql.tornaAssistent("45434543X"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SPAADException e) {
            e.printStackTrace();
        }
    }
}
