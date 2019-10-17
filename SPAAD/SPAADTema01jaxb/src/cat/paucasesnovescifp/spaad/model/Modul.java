/*
 *  Marta Córcoles Valle
  Dins el package cat.paucasesnovescifp.spadd.model crea una classe que ha de poder 
  contenir tota la informació que trobareu al fitxer xml, als elements i als atributs.
  Programa els getters, els setters, un constructor sense paràmetres, un amb paràmetres
  per a tots els atributs i el toString.
 */
package cat.paucasesnovescifp.spaad.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author marta
 */

@XmlRootElement
@XmlType(propOrder = {"nom", "hores"})
public class Modul {
    
    private String codi;
    private String nom;
    private int hores;

    public Modul(String codi, String nom, int hores) {
        this.codi = codi;
        this.nom = nom;
        this.hores = hores;
    }

    public Modul() {
        codi = null;
        nom = null;
        hores = 0;
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

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    @Override
    public String toString() {
        return "Modul{" + "codi=" + codi + ", nom=" + nom + ", hores=" + hores + '}';
    }        
}
