package cat.paucasesnovescifp.spaad.entitats;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Autor joselito = em.find(Autor.class, 1);
        System.out.println(joselito);
    }
}
