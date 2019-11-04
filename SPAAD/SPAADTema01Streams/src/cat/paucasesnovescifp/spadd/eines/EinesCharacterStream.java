package cat.paucasesnovescifp.spadd.eines;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public abstract class EinesCharacterStream {

    public static void mostraCharacters(String origen) {
        try (FileReader in = new FileReader(origen)) {
            while (in.ready()) {
                char d = (char) in.read();
                System.out.print(d);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escriuCharacters(String desti, String dades) {
        try (FileWriter out = new FileWriter(desti)) {
            out.write(dades);
        } catch (IOException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void copiaCharacters(String origen, String desti) {
        try (FileReader in = new FileReader(origen);
                FileWriter out = new FileWriter(desti)) {
            while (in.ready()) {
                char d = (char) in.read();
                out.write(d);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void inutil(String origen) {
        try (FileReader in = new FileReader(origen)) {
            while (in.ready()) {
                char d = (char) in.read();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesCharacterStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
