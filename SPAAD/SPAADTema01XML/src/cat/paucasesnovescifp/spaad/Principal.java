package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.model.Alumne;
import cat.paucasesnovescifp.spaad.model.Nota;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author marta
 */
public class Principal {

    public static void main(String[] args) {

        try {
            JAXBContext context = JAXBContext.newInstance(Alumne.class);
            Marshaller marshaller = context.createMarshaller();
            
            ArrayList<Nota> notes = new ArrayList<>();
            notes.add(new Nota("SPAAD", 7));
            notes.add(new Nota("SPPMM", 9));
            notes.add(new Nota("SPPSP", 10));
            notes.add(new Nota("EIE", 5));
            
            marshaller.marshal(new Alumne("454345", "Joselito", "Garcia", notes), new File("C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros\\alumne.xml"));
        }catch (JAXBException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Alumne joselito;
            JAXBContext context = JAXBContext.newInstance(Alumne.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            joselito = (Alumne) unmarshaller.unmarshal(new File("C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros\\alumne.xml"));
            System.out.println(joselito);
        } catch (JAXBException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

}
