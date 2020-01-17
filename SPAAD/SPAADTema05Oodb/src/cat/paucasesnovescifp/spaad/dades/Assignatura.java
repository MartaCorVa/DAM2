package cat.paucasesnovescifp.spaad.dades;

public class Assignatura {

    private String codi;
    private String nom;
    private String curs;

    public Assignatura(String codi, String nom, String curs) {
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

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Assignatura{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", curs='" + curs + '\'' +
                '}';
    }
}
