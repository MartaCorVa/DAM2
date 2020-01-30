package cat.paucasesnovescifp.spaad.dades;

import cat.paucasesnovescifp.spaad.utilitats.OODBException;

import java.util.ArrayList;
import java.util.Objects;

public class Alumne3 extends Alumne2{

    private ArrayList<Assignatura2> assignatures;

    public Alumne3(String dni, String nom, String llinatges, Curs curs) {
        super(dni, nom, llinatges, curs);
        assignatures = new ArrayList<>();
    }

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
    public void afegirAssignatura(Assignatura2 assignatura) throws OODBException {
        if (assignatura.getCurs().equals(this.getCurs())) {
            assignatures.add(assignatura);
        } else {
            throw new OODBException("ERROR: l'assignatura no coincideix");
        }
    }

    // Afegeix el mètode equals a Curs.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumne3 alumne3 = (Alumne3) o;
        return Objects.equals(assignatures, alumne3.assignatures);
    }

    @Override
    public String toString() {
        return "Alumne3{" +
                "assignatures=" + assignatures +
                "} " + super.toString();
    }
}
