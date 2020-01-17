package cat.paucasesnovescifp.spaad.entitats;

import cat.paucasesnovescifp.spaad.auxiliars.ORDBException;

public class Assignatura {

    private String codi;
    private String nom;
    private Cicle cicle_codi;

    public Assignatura(String codi, String nom, Cicle cicle_codi) throws ORDBException {
        if (codi == null && ("").equals(codi.trim())) {
            throw new ORDBException("Error: codi null o buit.");
        }
        if(nom == null && ("").equals(nom.trim())) {
            throw new ORDBException("Error: nom null o buit.");
        }
        this.codi = codi;
        this.nom = nom;
        this.cicle_codi = cicle_codi;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public Cicle getCicle_codi() {
        return cicle_codi;
    }

    @Override
    public String toString() {
        return "Assignatura{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", cicle_codi='" + cicle_codi + '\'' +
                '}';
    }
}
