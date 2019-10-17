package cat.paucasesnovescifp.spaad.auxiliars;

/**
 *
 * @author marta
 */
public class Alumne {

    private String nom;
    private String llinatge;

    public Alumne(String nom, String llinatge) throws AlumneException {
        this.setNom(nom);
        this.setLlinatge(llinatge);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws AlumneException {
        if (nom != null && !("").equals(nom.trim())) {
            this.nom = nom;
        } else {
            throw new AlumneException("El nom no és vàlid.");
        }
    }

    public String getLlinatge() {
        return llinatge;
    }

    public void setLlinatge(String llinatge) throws AlumneException {
        if (llinatge != null && !("").equals(llinatge.trim())) {
            this.llinatge = llinatge;
        } else {
            throw new AlumneException("El llinatge no és vàlid.");
        }
    }

    @Override
    public String toString() {
        return "Alumne{" + "nom=" + nom + ", llinatge=" + llinatge + '}';
    }
}
