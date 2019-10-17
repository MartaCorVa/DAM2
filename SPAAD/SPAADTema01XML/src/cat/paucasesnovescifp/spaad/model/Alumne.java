package cat.paucasesnovescifp.spaad.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author marta
 */

@XmlRootElement
@XmlType(propOrder = {"llinatges", "notes"})
public class Alumne {  
    
   private String dni;
   private String nom;
   private String llinatges;
   private ArrayList<Nota> notes;
 
    public Alumne(String dni, String nom, String llinatges, ArrayList<Nota> notes) {
        this.dni = dni;
        this.nom = nom;
        this.llinatges = llinatges;
        this.notes = notes;
    }

    public Alumne() {
        dni = null;
        nom = null;
        llinatges = null;
        notes = null;
    }   

    @XmlAttribute
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    @XmlTransient
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(name = "apellidos", nillable = true)
    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }
    
    @XmlElementWrapper
    @XmlElement(name = "nota")
    public ArrayList<Nota> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Nota> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Alumne{" + "dni=" + dni + ", nom=" + nom + ", llinatges=" + llinatges + ", notes=" + notes + '}';
    }   
}
