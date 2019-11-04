package cat.paucasesnovescifp.spaad.jdbc.dades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;

/**
 *
 * @author marta
 */
public class Nacionalitat {

    private String nom;

    public Nacionalitat(String nom) throws JDBCException {
        if (nom == null && ("").equals(nom.trim())) {
            throw new JDBCException("Error: nacionalitat null o buida.");
        }
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Nacionalitat{" + "nom=" + nom + '}';
    }

}
