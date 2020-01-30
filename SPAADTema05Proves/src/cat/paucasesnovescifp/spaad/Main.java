package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.dades.Pilot;
import cat.paucasesnovescifp.spaad.utilitats.ComparaPunts;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros\\proves.db";
        // Abrir bbdd
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        // Creamos un piloto
//       Pilot joselito = new Pilot("Manolo", 2);
//        db.store(joselito);

        // Recuperar un piloto
//        List<Pilot> pilots = db.queryByExample(new Pilot(null,0));

        // Recuperar todos los pilotos
//        List <Pilot> pilots = db.queryByExample(Pilot.class);

//        for (Pilot p : pilots) {
//            // Modificar un piloto
//            p.setPunts(p.getPunts() + 3);
//            db.store(p);
//            System.out.println(p);
//        }

        // Comparar puntos
//        List<Pilot> pilots = db.query(new ComparaPunts(16));
//
//        for (Pilot p : pilots) {
//            System.out.println(p);
//        }

        // Comparar puntos método 2
        int punts = 16;
        List<Pilot> pilots = db.query(new Predicate<Pilot>() {
            @Override
            public boolean match(Pilot pilot) {
                return pilot.getPunts() >= punts;
            }
        });

        for (Pilot actual : pilots) {
            System.out.println(actual);
        }

        db.close();
    }
}
