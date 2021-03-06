package cat.paucasesnovescifp.spaad.gestor;

import cat.paucasesnovescifp.spaad.dades.*;
import cat.paucasesnovescifp.spaad.utilitats.OODBException;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String nomFitxer = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPAAD\\SPAADTema05Oodb\\src\\cat\\paucasesnovescifp\\spaad\\fitxers\\bbdd.db";

        // Crea al paquet gestor una classe amb main que generi la base de dades.
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nomFitxer);

        // Insereix a la base de dades anterior tres alumnes i tres assignatures.
         /*db.store(new Alumne("45434543X", "Joselito", "Garcia", "dam"));
        db.store(new Alumne("45464546X", "Manolo", "Conga", "dam"));
        db.store(new Alumne("42434243X", "Miguelillo", "Gorrion", "daw"));

        db.store(new Assignatura("spaad", "Acces a dades", "dam"));
        db.store(new Assignatura("sppsp", "Processos", "dam"));
        db.store(new Assignatura("swdwc", "Client", "daw"));*/

        // Recupera l'objecte que representa un alumne a partir del seu nom i llinatges.
        /* ObjectSet<Alumne> result = db.queryByExample(new Alumne(null, "Joselito", "Garcia", null));
        Alumne found = result.next();
        System.out.println(found); */

        // Recupera tots els alumnes d'un curs.
        /* List<Alumne> alumnes = db.queryByExample(new Alumne(null, null,null, "dam"));
        for (Alumne a : alumnes) {
            System.out.println(a);
        } */

        // Mostra totes les assignatures d'un curs.
        /* List<Assignatura> assignatures = db.queryByExample(new Assignatura(null, null, "dam"));
        for (Assignatura a : assignatures) {
            System.out.println(a);
        } */

        // Mostra totes les assignatures.
        /* List<Assignatura> assignatures = db.queryByExample(Assignatura.class);
        for (Assignatura a : assignatures) {
            System.out.println(a);
        } */

        // Recupera l'objecte que representa un alumne a partir del seu nom i llinatges.
        /* ObjectSet<Alumne> alumne  = db.query(new Predicate<Alumne>() {
            String nom = "Joselito";
            String llinatges = "Garcia";
            @Override
            public boolean match(Alumne alumne1) {
                return nom.equals(alumne1.getNom()) && llinatges.equals(alumne1.getLlinatges());
            }
        });

        System.out.println(alumne); */

        // Recupera tots els alumnes d'un curs.
        /* List<Alumne> alumnes = db.query(new Predicate<Alumne>() {
            String curs = "dam";
            @Override
            public boolean match(Alumne alumne) {
                return curs.equals(alumne.getCurs());
            }
        });

        for (Alumne a : alumnes) {
            System.out.println(a);
        } */

        // Mostra totes les assignatures d'un curs.
        /*List<Assignatura> assignatures = db.query(new Predicate<Assignatura>() {
            String curs = "dam";
            @Override
            public boolean match(Assignatura assignatura) {
                return curs.equals(assignatura.getCurs());
            }
        });

        for (Assignatura a : assignatures) {
            System.out.println(a);
        }*/

        // Mostra totes les assignatures.
        /*List<Assignatura> assignatures = db.query(new Predicate<Assignatura>() {
            @Override
            public boolean match(Assignatura assignatura) {
                return true;
            }
        });

        for (Assignatura a : assignatures) {
            System.out.println(a);
        }*/

        // Insereix a la base de dades un Curs i tres Alumnes2 i tres Assignatures2 que pertanyin a aquest curs.
        /*Curs curs = new Curs("dam", "Multiplataforma");
        db.store(curs);
        db.store(new Alumne2("78767876X", "Maria", "Troncho", curs));
        db.store(new Alumne2("75767576X","Polo", "Martinez", curs));
        db.store(new Alumne2("78797879X", "Minguito", "Gomez", curs));
        db.store(new Assignatura2("spsge", "Gestió empresarial", curs));
        db.store(new Assignatura2("eie", "Empreses", curs));
        db.store(new Assignatura2("sppmm", "Android", curs));*/

        // A partir d'un Alumne2 recupera el curs i modifica el seu nom. Guarda l'alumne. Que passa amb el curs?
        /*Curs curs = new Curs("dam", "Multiplataforma");
        ObjectSet<Alumne2> maria = db.queryByExample(new Alumne2(null, "Maria", null, null));
        Alumne2 foundMaria = maria.next();
        foundMaria.getCurs().setNom("Desenvolupament d'aplicacions multiplataforma");
        db.store(foundMaria);
        ObjectSet<Alumne2> result = db.queryByExample(new Alumne2(null, "Maria", null, null));
        Alumne2 found = result.next();
        System.out.println(found);*/
        // El curs no es guarda

        // Arregla-ho guardant el curs de forma independent.
        /*ObjectSet<Curs> cursResult = db.queryByExample(new Curs("dam", null));
        Curs curs = cursResult.next();
        curs.setNom("Desenvolupament d'aplicacions multiplataforma");
        db.store(curs);
        ObjectSet<Alumne2> result = db.queryByExample(new Alumne2(null, "Maria", null, null));
        Alumne2 found = result.next();
        System.out.println(found);*/

        // Esborra un Alumne. S'ha esborrat el curs?
        /*ObujectSet<Alumne2> result = db.queryByExample(new Alumne2(null, "Maria", null, null));
        Alumne2 found = result.next();
        db.delete(found);
        ObjectSet<Curs> cursResult = db.queryByExample(new Curs("dam", null));
        Curs curs = cursResult.next();
        System.out.println(curs);*/
        // No s'ha esborrat el curs

        // Modifica la configuració de la base de dades perquè elimini amb cascada. Esborra un Alumne i comprova que
        // els alumnes restants s'han quedat sense curs.
        /*EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Alumne2.class).cascadeOnDelete(true);
        ObjectContainer dbc = Db4oEmbedded.openFile(config, nomFitxer);
        ObjectSet<Alumne2> result = dbc.queryByExample(new Alumne2(null, "Polo", null, null));
        Alumne2 found = result.next();
        dbc.delete(found);
        ObjectSet<Alumne2> resultMin = dbc.queryByExample(new Alumne2(null, "Minguito", null, null));
        Alumne2 foundMin = result.next();
        System.out.println(foundMin);*/

        // Crea un curs, tres assignatures i dos alumnes que no estiguin matriculats exactament de les mateixes assignatures.
        // Guarda el curs i els alumnes a la base de dades.
        /*try {
            Curs curs = new Curs("mec", "Mecanica");
            db.store(curs);
            Assignatura2 cotxe = new Assignatura2("cx", "Cotxe", curs);
            db.store(cotxe);
            Assignatura2 moto = new Assignatura2("mt", "Moto", curs);
            db.store(moto);
            Assignatura2 vehicle = new Assignatura2("vh", "Vehicle", curs);
            db.store(vehicle);
            Alumne3 miguel = new Alumne3("89878987X", "Miguel","Rubio", curs);
            miguel.afegirAssignatura(cotxe);
            miguel.afegirAssignatura(moto);
            db.store(miguel);
            Alumne3 sara = new Alumne3("12321232X", "Sara", "Adeu", curs);
            sara.afegirAssignatura(cotxe);
            sara.afegirAssignatura(vehicle);
            db.store(sara);
        } catch (OODBException e) {
            e.printStackTrace();
        }*/

        // Crea una consulta per exemple que recuperi els alumnes matriculats d'una certa assignatura.
        /*ArrayList<Assignatura2> assignatures = new ArrayList<>();
        assignatures.add(new Assignatura2("cx", "Cotxe", new Curs("mec", "Mecanica")));
        List<Alumne3> results = db.queryByExample(new Alumne3(null, null, null, null, assignatures));
        for (Alumne3 a : results) {
            System.out.println(a);
        }*/

        // Crea una consulta nativa que recuperi els alumnes matriculats d'una certa assignatura.
        /*ArrayList<Assignatura2> assignatures = new ArrayList<>();
        assignatures.add(new Assignatura2("cx", "Cotxe", new Curs("mec", "Mecanica")));
        ObjectSet<Alumne3> results = db.query(new Predicate<Alumne3>() {
            public boolean match(Alumne3 alumne3) {
               return alumne3.getAssignatures().contains(assignatures);
            }
        });
        ArrayList<Alumne3> alumnes = new ArrayList<>(results);
        for (Alumne3 a : alumnes) {
            System.out.println(a);
        }*/

        // Crea una consulta que torni tots els objectes de classe Alumnes2.
        /*ObjectSet<Alumne2> alumnes = db.query(new Predicate<Alumne2>() {
            @Override
            public boolean match(Alumne2 alumne) {
                return true;
            }
        });
        ArrayList<Alumne2> result = new ArrayList<>(alumnes);
        for (Alumne2 a : result) {
            System.out.println(a);
        }*/

        // Comprova que també et torna objectes de la classe Alumnes3.
        ObjectSet<Alumne3> alumnes = db.query(new Predicate<Alumne3>() {
            @Override
            public boolean match(Alumne3 alumne3) {
                return true;
            }
        });
        ArrayList<Alumne3> result = new ArrayList<>(alumnes);
        for (Alumne3 a : result) {
            System.out.println(a);
        }

        /*dbc.close();*/
        db.close();
    }
}
