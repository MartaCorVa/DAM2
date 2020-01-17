package cat.paucasesnovescifp.spaad.dades;

public class Alumne {

    private String dni;
    private String nom;
    private String llinatges;
    private String curs;

    public Alumne(String dni, String nom, String llinatges, String curs) {
        this.dni = dni;
        this.nom = nom;
        this.llinatges = llinatges;
        this.curs = curs;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", curs='" + curs + '\'' +
                '}';
    }
}
