package cat.paucasesnovescifp.spaad.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"titol", "descripcio", "idioma", "durada", "actors"})
public class Film implements Serializable {

    private String id;
    private String titol;
    private String descripcio;
    private Idioma idioma;
    private int durada;
    private ArrayList<Actor> actors;

    public Film(String id, String titol, String descripcio, Idioma idioma, int durada, ArrayList<Actor> actors) {
        this.id = id;
        this.titol = titol;
        this.descripcio = descripcio;
        this.idioma = idioma;
        this.durada = durada;
        this.actors = actors;
    }

    public Film() {
        id = null;
        titol = null;
        descripcio = null;
        idioma = null;
        durada = 0;
        actors = null;
    }
    
    @XmlAttribute(name = "filmId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    @XmlElementWrapper
    @XmlElement(name = "actor")
    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", titol=" + titol + ", descripcio=" + descripcio + ", idioma=" + idioma + ", durada=" + durada + ", actors=" + actors + '}';
    }

}
