package cat.paucasesnovescifp.spaad.dades;

import cat.paucasesnovescifp.spaad.utilitats.OODBException;

import java.util.ArrayList;

public class Alumne3 extends Alumne2{

    private ArrayList<Assignatura2> assignatures;

    public Alumne3(String dni, String nom, String llinatges, Curs curs, ArrayList<Assignatura2> assignatures) {
        super(dni, nom, llinatges, curs);
        this.assignatures = assignatures;
    }

    public ArrayList<Assignatura2> getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(ArrayList<Assignatura2> assignatures) {
        this.assignatures = assignatures;
    }

    // Crea un mètode afegirAssignatura que comprovi que el curs de l'assignatura és el mateix que el de l'alumne.
    // Si no coincideixen llença una excepció.
    private void afegirAssignatura() throws OODBException {
        for (Assignatura2 a : assignatures) {
            if (!a.getCurs().equals(getCurs())) {
                throw new OODBException("ERROR: l'assignatura no coincideix");
            }
        }
    }

    // Afegeix el mètode equals a Curs.

    @Override
    public String toString() {
        return "Alumne3{" +
                "assignatures=" + assignatures +
                '}';
    }
}
