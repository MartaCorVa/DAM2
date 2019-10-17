package cat.paucasesnovescifp.spadd.eines;

import cat.paucasesnovescifp.spadd.ProvesStreams;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public abstract class EinesByteStream {

    public static void escriuByte(String desti, byte[] dades) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(desti);
            for (byte c : dades) {
                out.write(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void mostraBytes(String origen) {
        try (FileInputStream in = new FileInputStream(origen)) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.println((byte) c);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void copiaBytes(String origen, String desti) {
        try (FileOutputStream out = new FileOutputStream(desti);
                FileInputStream in = new FileInputStream(origen)) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static byte[] tornaBytes(String origen) {
        ArrayList<Byte> list = new ArrayList<Byte>();
        byte[] array = null;
        try (FileInputStream in = new FileInputStream(origen)) {
            int c;
            while ((c = in.read()) != -1) {
                list.add((byte) c);
            }
            array = new byte[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = (byte) list.get(i);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinesByteStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

}
