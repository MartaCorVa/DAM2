package cat.paucasesnovescifp.spaad.entitats;

import cat.paucasesnovescifp.spaad.auxiliars.ORDBException;

import java.util.Arrays;

public class Matricula {

    private Alumne alumnes_nif;
    private Assignatura assignatura_codi;
    private Integer[] notes;

    public Matricula(Alumne alumnes_nif, Assignatura assignatura_codi, Integer[] notes) throws ORDBException {
        if (assignatura_codi == null) {
            throw new ORDBException("Error: codi null o buit.");
        }
        if(alumnes_nif == null) {
            throw new ORDBException("Error: nom null o buit.");
        }
        this.alumnes_nif = alumnes_nif;
        this.assignatura_codi = assignatura_codi;
        this.notes = notes;
    }

    public Alumne getAlumnes_nif() {
        return alumnes_nif;
    }

    public Assignatura getAssignatura_codi() {
        return assignatura_codi;
    }

    public Integer[] getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "alumnes_nif=" + alumnes_nif +
                ", assignatura_codi=" + assignatura_codi +
                ", notes=" + Arrays.toString(notes) +
                '}';
    }
}
