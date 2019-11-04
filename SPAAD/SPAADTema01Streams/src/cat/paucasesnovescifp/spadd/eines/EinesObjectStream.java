package cat.paucasesnovescifp.spadd.eines;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public abstract class EinesObjectStream {
    
    public static void escriuObjecte(String desti, Serializable objDades) {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)))) {
            out.writeObject(objDades); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Object llegeixObjecte(String origen) {
        Object objDades = null;
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)))) {
             objDades = in.readObject(); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EinesObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objDades;
    }
    
}
