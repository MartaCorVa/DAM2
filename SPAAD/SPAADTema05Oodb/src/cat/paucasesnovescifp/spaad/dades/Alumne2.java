package cat.paucasesnovescifp.spaad.dades;

public class Alumne2 {

    private String dni;
    private String nom;
    private String llinatges;
    private Curs curs;

    public Alumne2(String dni, String nom, String llinatges, Curs curs) {
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

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Alumne2{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", curs=" + curs +
                '}';
    }
}
