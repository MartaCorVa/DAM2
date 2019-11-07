package cat.paucasesnovescifp.spaad.jdbc.dades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;

/**
 *
 * @author marta
 */
public class Llengua {
    
    private String nom;

    public Llengua(String nom) throws JDBCException {
        if (nom == null && ("").equals(nom.trim())) {
            throw new JDBCException("Error: llengua null o buit.");
        }
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Llengua{" + "nom=" + nom + '}';
    }
    
}
