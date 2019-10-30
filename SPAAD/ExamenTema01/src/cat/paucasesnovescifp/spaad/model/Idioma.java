package cat.paucasesnovescifp.spaad.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Idioma implements Serializable {

    private String nom;
    private String id;

    public Idioma(String nom, String id) {
        this.nom = nom;
        this.id = id;
    }

    public Idioma() {
        nom = null;
        id = null;
    }
    
    @XmlValue
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlAttribute(name = "idiomaId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Idioma{" + "nom=" + nom + ", id=" + id + '}';
    }

}
