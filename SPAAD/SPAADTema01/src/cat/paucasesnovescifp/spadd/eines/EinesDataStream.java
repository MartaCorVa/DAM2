package cat.paucasesnovescifp.spadd.eines;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public abstract class EinesDataStream {

    public static void guardaArray(String desti, double[] dades) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(desti)))) {
            out.writeInt(dades.length);
            for (int i = 0; i < dades.length; i++) {
                out.writeDouble(dades[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesDataStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesDataStream.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static double[] recuperaArray(String origen) {
        double[] dades = null;
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(origen)))) {
                dades = new double[in.readInt()];
                for (int i = 0; i < dades.length; i++) {
                    dades[i] = in.readDouble();
                }
        } catch (IOException ex) {
            Logger.getLogger(EinesDataStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dades;
    }
}
