package cat.paucasesnovescifp.spadd.eines;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public abstract class EinesBufferedStream {

    public static String[] mostraLine(String origen) {
        ArrayList<String> llista = new ArrayList<String>();
        String[] array = null;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(origen))) {
            while (inputStream.ready()) {
                llista.add(inputStream.readLine());
            }
            array = new String[llista.size()];
            for (int i = 0; i < llista.size(); i++) {
                array[i] = llista.get(i);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public static void escriuLine(String desti, String[] dades) {
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(desti))) {
            for (String a : dades) {
                outputStream.write(a);
                outputStream.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void copiaLine(String origen, String desti) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(origen));
                BufferedWriter outputStream = new BufferedWriter(new FileWriter(desti))) {
            while (inputStream.ready()) {
                outputStream.write(inputStream.readLine());
                outputStream.newLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void inutil(String origen) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(origen))) {
            while (inputStream.ready()) {
                inputStream.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesBufferedStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
