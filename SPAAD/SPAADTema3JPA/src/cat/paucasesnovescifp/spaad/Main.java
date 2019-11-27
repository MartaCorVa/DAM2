package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.auxiliars.JPAException;
import cat.paucasesnovescifp.spaad.controller.Persistencia;
import cat.paucasesnovescifp.spaad.model.*;
import net.bytebuddy.asm.Advice;
import org.hibernate.Hibernate;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Illa mallorca=em.find(Illa.class,"071");
        System.out.println("mallorca = " + mallorca);
        Especialitat informatica=em.find(Especialitat.class,new EspecialitatPK("0590","107"));
        System.out.println("informatica = " + informatica);
        */
        String unitatPersistencia = "interins-pu";
        Persistencia persistencia = null;

        try {
            persistencia = new Persistencia(unitatPersistencia);

            // Exercici 4.1
            Aspirant aspirant = persistencia.getAspirant("12007493F");
            System.out.println(aspirant);

            // Exercici 4.2
            persistencia.modificaLlinatgesAspirant("12007493F", "Garcia");

            // Exercici 4.3
            aspirant.setCodiPostal("09600");
            persistencia.actualitzaAspirant(aspirant);
            System.out.println(aspirant);

            // Exercici 4.4
            System.out.println(persistencia.getLocalitat("070010001"));

            // Exercici 4.5
            //persistencia.creaAspirant("454345P", "Joselito", "Garcia");
            System.out.println(persistencia.getAspirant("454345P"));

            // Exercici 4.6
            //persistencia.creaPreferencia("454345P", 29,"07006861","0590","121" );

            // Exercici 4.7
            Illa illa = new Illa();
            illa.setIdIlla("075");
            illa.setNomIlla("Joselitopolis");
            //persistencia.insereix(illa);
            System.out.println(illa);

            // Exercici 4.8
            illa.setNomIlla("Joselito Isle");
            persistencia.actualitza(illa);
            System.out.println(illa);

            // Exercici 4.9
            //persistencia.esborra(illa);

            // Exercici 5.1
            List<Illa> illes = persistencia.tornaIlles();
            for (Illa i : illes) {
                System.out.println(i);
            }

            // Exercici 5.2
            List<Illa> illes2 = persistencia.tornaIllesNQ();
            for (Illa i : illes2) {
                System.out.println(i);
            }

            // Exercici 5.3
            List<Localitat> localitats = persistencia.tornaLocalitatsIlla(persistencia.getIlla("071"));
            for (Localitat l : localitats) {
                System.out.println(l);
            }

            // Exercici 5.4
//            Object localidades = persistencia.tornaLocalitatsIllaNC(persistencia.getIlla("071"));
//            System.out.print(localidades.toString());

            // Exercici 5.5


        } catch (JPAException e) {
            e.printStackTrace();
        }
    }
}
