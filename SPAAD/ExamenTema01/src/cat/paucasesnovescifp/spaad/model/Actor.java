package cat.paucasesnovescifp.spaad.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"nom", "llinatges"})
public class Actor implements Serializable {

    private String id;
    private String nom;
    private String llinatges;

    public Actor(String id, String nom, String llinatges) {
        this.id = id;
        this.nom = nom;
        this.llinatges = llinatges;
    }

    public Actor() {
        id = null;
        nom = null;
        llinatges = null;
    }

    @XmlAttribute(name = "actorId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    @Override
    public String toString() {
        return "Actor{" + "id=" + id + ", nom=" + nom + ", llinatges=" + llinatges + '}';
    }

}
