package cat.paucasesnovescifp.spaad.controlador;

import cat.paucasesnovescifp.spaad.Main;
import cat.paucasesnovescifp.spaad.model.Curs;
import cat.paucasesnovescifp.spaad.model.CursV2;
import cat.paucasesnovescifp.spaad.model.Modul;
import java.io.File;
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
public abstract class Controller {
    
    public static Modul llegeixModul(String ruta) {    
         Modul modul = null;
         try {           
            JAXBContext context = JAXBContext.newInstance(Modul.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            modul = (Modul) unmarshaller.unmarshal(new File(ruta));
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return modul;
    }
    
    public static void escriuModul(String ruta, Modul modul) {
        try {
            JAXBContext context = JAXBContext.newInstance(Modul.class);
            Marshaller marshaller = context.createMarshaller();            
            marshaller.marshal((modul), new File(ruta));
        }catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Curs llegeixCurs(String ruta) {    
         Curs curs = null;
         try {           
            JAXBContext context = JAXBContext.newInstance(Curs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            curs = (Curs) unmarshaller.unmarshal(new File(ruta));
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return curs;
    }
    
     public static void escriuCurs(String ruta, Curs curs) {
        try {
            JAXBContext context = JAXBContext.newInstance(Curs.class);
            Marshaller marshaller = context.createMarshaller();            
            marshaller.marshal((curs), new File(ruta));
        }catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static CursV2 llegeixCursV2(String ruta) {    
         CursV2 cursv2 = null;
         try {           
            JAXBContext context = JAXBContext.newInstance(CursV2.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            cursv2 = (CursV2) unmarshaller.unmarshal(new File(ruta));
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }          
        return cursv2;
    }
    
     public static void escriuCursV2(String ruta, CursV2 cursv2) {
        try {
            JAXBContext context = JAXBContext.newInstance(CursV2.class);
            Marshaller marshaller = context.createMarshaller();            
            marshaller.marshal((cursv2), new File(ruta));
        }catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static Object llegir(String ruta, Class classe){
         Object result = null;
         try {           
            JAXBContext context = JAXBContext.newInstance(classe);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            result = (Object) unmarshaller.unmarshal(new File(ruta));
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }    
         return result;
     }
     
     public static void escriure(String ruta, Object dades) {
           try {
            JAXBContext context = JAXBContext.newInstance(dades.getClass());
            Marshaller marshaller = context.createMarshaller();            
            marshaller.marshal(dades, new File(ruta));
        }catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
