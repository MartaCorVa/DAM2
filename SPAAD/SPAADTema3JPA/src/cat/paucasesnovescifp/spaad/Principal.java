package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.model.Cos;
import cat.paucasesnovescifp.spaad.model.Especialitat;
import cat.paucasesnovescifp.spaad.model.Illa;

import javax.persistence.*;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("interins-pu");
        EntityManager em = emf.createEntityManager();

//        Query illes = em.createQuery("Select i from Illa i");
//        List resultList = illes.getResultList();
//        for(Object o : resultList){
//            System.out.println("o = " + o);
//            Illa i = (Illa)o;
//            System.out.println(i.getNomIlla());
//        }
//
//
//        TypedQuery<Illa> illes2 = em.createQuery("Select i from Illa i",Illa.class);
//        List<Illa> resultList1 = illes2.getResultList();
//        for(Illa i : resultList1){
//            System.out.println("i = " + i);
//        }
//
//        TypedQuery<String> illes3 = em.createQuery("Select i.nomIlla from Illa i", String.class);
//        List<String> resultList2 = illes3.getResultList();
//        for(String i : resultList2){
//            System.out.println("i = " + i);
//        }
//
//        Query objectes = em.createQuery("select c, e from Cos c JOIN c.especialitats e");
//        List<Object[]> resultat3 = objectes.getResultList();
//        for (Object[] fila : resultat3){
//            Cos c= (Cos) fila[0];
//            Especialitat e = (Especialitat) fila[1];
//            System.out.println("c: " + c);
//            System.out.println("e: " + e);
//        }

        TypedQuery<Especialitat> query = em.createQuery("select e from Especialitat  e " +
                "where e.descripcio = :nom", Especialitat.class);
        query.setParameter("nom","INFORMATICA");
        List<Especialitat> resultList3 = query.getResultList();
        for (Especialitat e : resultList3) {
            System.out.println("e: " + e);
        }

        em.close();
        emf.close();
    }

}
