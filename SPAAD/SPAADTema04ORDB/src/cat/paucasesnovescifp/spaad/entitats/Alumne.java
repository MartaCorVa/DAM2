package cat.paucasesnovescifp.spaad.entitats;

import cat.paucasesnovescifp.spaad.auxiliars.ORDBException;
import org.postgresql.util.PGobject;

public class Alumne extends PGobject {

    private String nif;
    private String nom;
    private String llinatges;
    private T_dades_contacte contacte;

    public Alumne(String nif, String nom, String llinatges) throws ORDBException {
        if (nif == null && ("").equals(nif.trim())) {
            throw new ORDBException("Error: nif null o buit.");
        }
        if(nom == null && ("").equals(nom.trim())) {
            throw new ORDBException("Error: nom null o buit.");
        }
        this.nif = nif;
        this.nom = nom;
        this.llinatges = llinatges;
        this.contacte = null;
    }

    public Alumne(String nif, String nom, String llinatges, T_dades_contacte contacte) throws ORDBException {
        if (nif == null && ("").equals(nif.trim())) {
            throw new ORDBException("Error: nif null o buit.");
        }
        if(nom == null && ("").equals(nom.trim())) {
            throw new ORDBException("Error: nom null o buit.");
        }
        this.nif = nif;
        this.nom = nom;
        this.llinatges = llinatges;
        this.contacte = contacte;
    }

    public String getNif() {
        return nif;
    }

    public String getNom() {
        return nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public T_dades_contacte getContacte() {
        return contacte;
    }

    @Override
    public String toString() {
        if (contacte == null) {
            return "Alumne{" +
                    "nif='" + nif + '\'' +
                    ", nom='" + nom + '\'' +
                    ", llinatges='" + llinatges + '\'' +
                    '}';
        }
        return "Alumne{" +
                "nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", contacte=" + contacte +
                '}';
    }
}
