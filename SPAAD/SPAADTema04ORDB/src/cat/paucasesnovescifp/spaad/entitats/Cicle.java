package cat.paucasesnovescifp.spaad.entitats;

import cat.paucasesnovescifp.spaad.auxiliars.ORDBException;

public class Cicle {

    private String codi;
    private String nom;

    public Cicle(String codi, String nom) throws ORDBException {
        if (codi == null && ("").equals(codi.trim())) {
            throw new ORDBException("Error: codi null o buit.");
        }
        if(nom == null && ("").equals(nom.trim())) {
            throw new ORDBException("Error: nom null o buit.");
        }
        this.codi = codi;
        this.nom = nom;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Cicle{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
