package cat.paucasesnovescifp.spaad.jpa;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;
import cat.paucasesnovescifp.spaad.jpa.entitats.Editor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JPA {
    private String persistenceUnit;

    public JPA(String persistenceUnit) throws SPAADException {
        if (("").equals(persistenceUnit.trim()) || persistenceUnit == null){
            throw new SPAADException("ERROR: unitat de persistencia incorrecta.");
        }
        this.persistenceUnit = persistenceUnit;
    }

    public Editor tornaEditor(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();

        Editor editor = em.find(Editor.class, id);

        em.close();
        emf.close();

        return editor;
    }

    public List<Editor> tornaEditors(int inici, int quantitat) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Editor.findAll")
                .setFirstResult(inici)
                .setMaxResults(quantitat);
        List<Editor> editors = query.getResultList();
        return editors;
    }

    public Editor tornaEditor(String nom) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();

        TypedQuery<Editor> query = em.createQuery("select e from Editor e where e.nomEdit = :nom", Editor.class);
        query.setParameter("nom", nom);
        Editor editor = query.getSingleResult();

        return editor;
    }

}
