package cat.paucasesnovescifp.spaad.dades;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Pilot {

    private String nom;
    private int punts;

    public Pilot(String nom, int punts) {
        this.nom = nom;
        this.punts = punts;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "nom='" + nom + '\'' +
                ", punts=" + punts +
                '}';
    }
}
