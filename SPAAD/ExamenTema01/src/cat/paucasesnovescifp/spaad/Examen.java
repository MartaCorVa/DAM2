package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.jaxb.Jaxb;
import cat.paucasesnovescifp.spaad.model.Film;
import cat.paucasesnovescifp.spaad.streams.Fitxers;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

public class Examen {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\Examen\\src\\cat\\paucasesnovescifp\\spaad\\recursos";

        Film film = null;
        //Exercici01
        try {
            film = Jaxb.llegirXml(ruta + "\\001.xml");
            System.out.println(film);
        } catch (JAXBException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Exercici02
        try {
            film.setActors(null);
            film.setIdioma(null);
            Fitxers.escriuCharacters(ruta + "\\dades", film.toString());
            System.out.println(Fitxers.mostraCharacters(ruta + "\\dades"));
        } catch (IOException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Exercici03
        try {
            Fitxers.escriuObjecte(ruta + "\\dades", Jaxb.llegirXml(ruta + "\\001.xml"));
            System.out.println(Fitxers.llegeixObjecte(ruta + "\\dades"));
        } catch (IOException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
