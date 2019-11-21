package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.biblioteca.Llibre;
import cat.paucasesnovescifp.spaad.biblioteca.Nacionalitat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
        EntityManager em = emf.createEntityManager();
        Llibre amic=em.find(Llibre.class,1);
        System.out.println("amic = " + amic);
        System.out.println(amic.getTemes());
        em.close();
        emf.close();
         */



        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Llibre amic=em.find(Llibre.class,1);
        System.out.println("amic = " + amic);
        System.out.println(amic.getTemes());

        amic.setMotiubaixa("Robat");
        em.getTransaction().commit();

        em = emf.createEntityManager();
        amic = em.merge(amic);
        System.out.println(amic.getTemes());

        emf.close();
         */





        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
        EntityManager em = emf.createEntityManager();

        Llibre amic=em.find(Llibre.class,1);
        System.out.println("amic = " + amic);
        System.out.println(amic.getTemes());

        em.close();
        amic.setMotiubaixa("Robat");

        em.close();
        em.getTransaction().begin();

        // Devolver un objeto relacionado con la bbdd
        em = emf.createEntityManager();
        amic = em.merge(amic);
        System.out.println(amic.getTemes());

        emf.close();
         */


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
        EntityManager em = emf.createEntityManager();

        Llibre amic=em.find(Llibre.class,1);
        System.out.println("amic = " + amic);
        System.out.println(amic.getTemes());

        em.getTransaction().begin();
        Nacionalitat nova = new Nacionalitat();
        nova.setNacionalitat("Inquera");
        Nacionalitat n = em.merge(nova);
        em.remove(n);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
