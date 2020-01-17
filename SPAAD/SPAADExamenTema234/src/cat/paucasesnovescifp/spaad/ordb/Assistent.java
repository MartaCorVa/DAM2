package cat.paucasesnovescifp.spaad.ordb;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;
import org.postgresql.util.PGobject;

public class Assistent extends PGobject {

    private String nif_assistent;
    private String nom_assistent;
    private T_titols_projectes titols;

    public Assistent(String nif_assistent, String nom_assistent, T_titols_projectes titols) throws SPAADException {
        if (nif_assistent == null && ("").equals(nif_assistent.trim())) {
            throw new SPAADException("Error: nif null o buit.");
        }
        if(nom_assistent == null && ("").equals(nom_assistent.trim())) {
            throw new SPAADException("Error: nom null o buit.");
        }
        this.nif_assistent = nif_assistent;
        this.nom_assistent = nom_assistent;
        this.titols = titols;
    }

    public String getNif_assistent() {
        return nif_assistent;
    }

    public String getNom_assistent() {
        return nom_assistent;
    }

    public T_titols_projectes getTitols() {
        return titols;
    }

    @Override
    public String toString() {
        return "Assistent{" +
                "nif_assistent='" + nif_assistent + '\'' +
                ", nom_assistent='" + nom_assistent + '\'' +
                ", titols=" + titols +
                '}';
    }
}
