package cat.paucasesnovescifp.spaad.dades;

public class Assignatura2 {

    private String codi;
    private String nom;
    private Curs curs;

    public Assignatura2(String codi, String nom, Curs curs) {
        this.codi = codi;
        this.nom = nom;
        this.curs = curs;
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

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Assignatura2{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", curs=" + curs +
                '}';
    }
}
