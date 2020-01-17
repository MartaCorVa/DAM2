package cat.paucasesnovescifp.spaad.dades;

import java.util.Objects;

public class Curs {

    private String codi;
    private String nom;

    public Curs(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curs curs = (Curs) o;
        return Objects.equals(codi, curs.codi) &&
                Objects.equals(nom, curs.nom);
    }

    @Override
    public String toString() {
        return "Curs{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
