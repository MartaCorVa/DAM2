package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.auxiliars.ORDBException;
import cat.paucasesnovescifp.spaad.baseDades.BaseDades;
import cat.paucasesnovescifp.spaad.entitats.Alumne;
import cat.paucasesnovescifp.spaad.entitats.Matricula;
import cat.paucasesnovescifp.spaad.entitats.T_dades_contacte;

import java.sql.SQLException;
import java.util.Properties;

public class Executa {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.56.95:5432/basedades";
        Properties propietats = new Properties();
        propietats.put("user", "usuari");
        propietats.put("password", "seCret_19");

        try {
            BaseDades bbdd = new BaseDades(url, propietats);

            // 1 Recuperar un cicle per l'identificador
            //System.out.println(bbdd.tornaCicle("s2p"));

            // 2 Recuperar una assignatura per l'identificador.
            //System.out.println(bbdd.tornaAssignatura("spaad"));

            // 3 Recuperar un alumne per l'identificador (excepte contacte).
            //System.out.println(bbdd.tornaAlumne("45434543X"));

            // 4 Recuperar una matrícula per l'identificador.
            //System.out.println(bbdd.tornaMatricula("45434543X"));

            // 5 Recuperar tots els alumnes de la base de dades.
//            for (Alumne a : bbdd.tornaTotsAlumnes()) {
//                System.out.println(a);
//            }

            // 6 Recuperar totes les matricules d'un alumne.
//            for (Matricula m : bbdd.tornaMatriculaAlumne(bbdd.tornaAlumne("45434543X"))) {
//                System.out.println(m);
//            }

            // 7 Recuperar totes les matricules d'una assignatura.
//            for (Matricula m : bbdd.tornaMatriculaAssignatura(bbdd.tornaAssignatura("spaad"))) {
//                System.out.println(m);
//            }

            // 8 Modificar una de les notes d'una assignatura d'un alumne.
//            bbdd.modificarNota(bbdd.tornaAssignatura("spaad"),bbdd.tornaAlumne("45434543X"), 1, 2);

            // 9 Recuperar un alumne per l'identificador (inclòs contacte).
            //System.out.println(bbdd.tornaAlumneContacte("45434543X"));

            // 10 Afegir un alumne nou a la base de dades.
            //bbdd.afegirAlumne(new Alumne("78767876X", "Maria", "Picos Pardos"));
            //bbdd.afegirAlumne(new Alumne("78767876X", "Maria", "Picos Pardos", new T_dades_contacte("654433432", "picos@pardos.com", "@LaMontañas")));

            // 11 Matricular un alumne a una assignatura.
            //bbdd.matricularAlumne(bbdd.tornaAlumne("78767876X"), bbdd.tornaAssignatura("spaad"));

            // 12 Afegir les notes d'aquest alumne nou per a una assignatura.
            Integer[] notes = {1,3,6};
            bbdd.afegirNotes(bbdd.tornaAlumne("78767876X"), bbdd.tornaAssignatura("spaad"), notes);

        } catch (ORDBException | SQLException e) {
            e.printStackTrace();
        }
    }
}
