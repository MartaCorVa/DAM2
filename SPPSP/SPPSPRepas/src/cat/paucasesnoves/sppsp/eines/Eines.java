package cat.paucasesnoves.sppsp.eines;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public abstract class Eines {

    public static void llegirFitxer(String origen) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(origen))) {
            while (inputStream.ready()) {
                System.out.println(inputStream.readLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Eines.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escriuFitxer(String text, String desti) throws BuitException {
        if (text != null && !("").equals(text.trim())) {
            try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(desti, true))) {
                outputStream.newLine();
                outputStream.append(text);
            } catch (IOException ex) {
                Logger.getLogger(Eines.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new BuitException("ERROR: El text no por ser buit ni contenir tan sols espais.");
        }

    }
}
