/*
 *  Marta Córcoles Valle
 * 
 */
package cat.paucasesnovescifp.spaad.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author marta
 */
@XmlRootElement
@XmlType(propOrder = {"nom", "moduls"})
public class Curs {
    
    private String codi;
    private String nom;
    private ArrayList<Modul> moduls;

    public Curs(String codi, String nom, ArrayList<Modul> moduls) {
        this.codi = codi;
        this.nom = nom;
        this.moduls = moduls;
    }

    public Curs() {
        codi = null;
        nom = null;
        moduls = null;
    }

    @XmlAttribute
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(name = "modul")
    public ArrayList<Modul> getModuls() {
        return moduls;
    }

    public void setModuls(ArrayList<Modul> moduls) {
        this.moduls = moduls;
    }

    @Override
    public String toString() {
        return "Curs{" + "codi=" + codi + ", nom=" + nom + ", moduls=" + moduls + '}';
    }
        
}
