/*
 *  Marta Córcoles Valle
 * 
 */
package cat.paucasesnovescifp.spaad.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author marta
 */
public class Nota {
    
    private String assignatura;
    private int puntuacio;

    public Nota(String assignatura, int puntuacio) {
        this.setAssignatura(assignatura);
        this.setPuntuacio(puntuacio);
    }

    public Nota() {
        this.assignatura = null;
        this.puntuacio = 0;
    }
  
    @XmlAttribute
    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }
    
    @XmlValue
    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    @Override
    public String toString() {
        return "Nota{" + "assignatura=" + assignatura + ", puntuacio=" + puntuacio + '}';
    }
        
}
