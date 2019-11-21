package cat.paucasesnovescifp.spaad.controller;

import cat.paucasesnovescifp.spaad.auxiliars.JPAException;
import cat.paucasesnovescifp.spaad.model.Aspirant;
import cat.paucasesnovescifp.spaad.model.Localitat;
import cat.paucasesnovescifp.spaad.model.Preferencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistencia {

    private String unitatPersistencia;

    public Persistencia(String unitatPersistencia) throws JPAException {
        if (("").equals(unitatPersistencia.trim()) || unitatPersistencia == null){
            throw new JPAException("ERROR: unitat de persistencia incorrecta.");
        }
        this.unitatPersistencia = unitatPersistencia;
    }

    public String getUnitatPersistencia() {
        return unitatPersistencia;
    }

    // Exercici 4.1
    public Aspirant getAspirant(String nif) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Aspirant aspirant = em.find(Aspirant.class, nif);

        em.close();
        emf.close();

        return aspirant;
    }

    // Exercici 4.2
    public void modificaLlinatgesAspirant(String nif, String llinatges) throws JPAException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Aspirant aspirant = em.find(Aspirant.class, nif);

        aspirant.setLlinatges(llinatges);
        em.getTransaction().commit();

        aspirant = em.merge(aspirant);

        em.close();
        emf.close();
    }

    // Exercici 4.3
    public void actualitzaAspirant(Aspirant aspirant) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(aspirant);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // Exercici 4.4
    public Localitat getLocalitat(String idLocalitat) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Localitat localitat = em.find(Localitat.class, idLocalitat);

        em.close();
        emf.close();

        return localitat;
    }

    // Exercici 4.5
    public void creaAspirant(String nif, String nom, String llinatges) throws JPAException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Aspirant aspirant = new Aspirant();
        aspirant.setNif(nif);
        aspirant.setNom(nom);
        aspirant.setLlinatges(llinatges);
        em.persist(aspirant);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // Exercici 4.6
    public void creaPreferencia(String nif, String ordre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Preferencia preferencia = new Preferencia();
        preferencia.setNif(nif);
        preferencia.setOrdre(Integer.parseInt(ordre));
        em.persist(preferencia);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // Exercici 4.7
    public void insereix(Object objecte){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(objecte);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // Exercici 4.8
    public void actualitza(Object objecte){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(objecte);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // Exercici 4.9
    public void esborra(Object objecte) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.remove(objecte);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
