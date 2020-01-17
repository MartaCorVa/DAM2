package cat.paucasesnovescifp.spaad.controller;

import cat.paucasesnovescifp.spaad.auxiliars.JPAException;
import cat.paucasesnovescifp.spaad.model.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
      public Preferencia creaPreferencia(String nif, int ordre, String centre, String idCos, String idEspecialitat){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Preferencia preferencia = new Preferencia();
        preferencia.setNif(nif);
        preferencia.setOrdre(ordre);
        preferencia.setAspirant(em.find(Aspirant.class, nif));
        preferencia.setCentre(em.find(Centre.class, centre));
        EspecialitatPK especialitatPK = new EspecialitatPK();
        especialitatPK.setIdCos(idCos);
        especialitatPK.setIdEspecialitat(idEspecialitat);
        preferencia.setEspecialitat(em.find(Especialitat.class, especialitatPK));

        em.persist(preferencia);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return preferencia;
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

        em.remove(em.merge(objecte));

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // Exercici 5.1
    public List<Illa> tornaIlles(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        TypedQuery<Illa> query = em.createQuery("select i from Illa i", Illa.class);
        List<Illa> illes = query.getResultList();
        return illes;
    }

    // Exercici 5.2
    public List<Illa> tornaIllesNQ(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Illa.findAll");
        List<Illa> illes = query.getResultList();
        return illes;
    }

    // Aconseguir una illa
    public Illa getIlla(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Illa illa = em.find(Illa.class, id);


        em.close();
        emf.close();

        return illa;
    }

    // Exercici 5.3
    public List<Localitat> tornaLocalitatsIlla(Illa illa){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        TypedQuery<Localitat> query = em.createQuery("select l from Localitat l where l.illa.idIlla =:illa", Localitat.class);
        query.setParameter("illa", illa.getIdIlla());
        List<Localitat> localitats = query.getResultList();
        return localitats;
    }

    // Exercici 5.4
    public Object tornaLocalitatsIllaNC(Illa illa){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        illa = em.merge(illa);
        Collection<Localitat> localitats = illa.getLocalitats();

        return localitats;
        }

    // Exercici 5.5
    public List<Localitat> tornaLocalitatsNQ(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Localitat.findByIlla");
        query.setParameter("illa", "074" );
        List<Localitat> localitats = query.getResultList();

        return localitats;
    }

    // Exercici 5.6
    public List<Aspirant> tornaAspirants(int inici, int quantitat) {
        List<Aspirant> aspirants = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

            TypedQuery<Aspirant> query = em.createNamedQuery("Aspirant.findAll", Aspirant.class)
                    .setFirstResult(inici)
                    .setMaxResults(quantitat);
            aspirants = query.getResultList();

            em.close();
            emf.close();

        return aspirants;
    }

    // Exercici 5.7
    public List<String> getNifs(int inici, int quantitat) {
        List<String> nifs = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        TypedQuery<String> query = em.createNamedQuery("Aspirant.findNif", String.class)
                .setFirstResult(inici)
                .setMaxResults(quantitat);
        nifs = query.getResultList();

        em.close();
        emf.close();

        return nifs;
    }

    // Exercici 5.8
    public List getNomComplet(int inici, int quantitat) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Aspirant.getNomComplet")
                .setFirstResult(inici)
                .setMaxResults(quantitat);
        List noms = query.getResultList();
        return noms;
    }

    //Exercici 5.9
    public List<Preferencia> getPreferencies(int inici, int quantitat) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Preferencia.getPreferencies")
                .setFirstResult(inici)
                .setMaxResults(quantitat);
        List<Preferencia> preferencies = query.getResultList();
        return preferencies;
    }

}
