package cat.paucasesnovescifp.spadd;

import cat.paucasesnovescifp.spadd.auxiliar.Cronometre;
import cat.paucasesnovescifp.spadd.auxiliar.Dades;
import cat.paucasesnovescifp.spadd.auxiliar.DadesComplexes;
import cat.paucasesnovescifp.spadd.eines.EinesBufferedStream;
import cat.paucasesnovescifp.spadd.eines.EinesByteStream;
import cat.paucasesnovescifp.spadd.eines.EinesCharacterStream;
import cat.paucasesnovescifp.spadd.eines.EinesDataStream;
import cat.paucasesnovescifp.spadd.eines.EinesObjectStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class ProvesStreams {

    public void provesByte() {
        // url
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio";
        // array de bytes
        byte[] arrayBytes = {1, 2, 3, 4};
        try {
            EinesByteStream.escriuByte(url + "\\dades", arrayBytes);
        } catch (IOException ex) {
            Logger.getLogger(ProvesStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            EinesByteStream.escriuByte(url + "\\string", "Joselito".getBytes());
        } catch (IOException ex) {
            Logger.getLogger(ProvesStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        EinesByteStream.mostraBytes(url + "\\dades");
        EinesByteStream.mostraBytes(url + "\\string");
        EinesByteStream.copiaBytes("C:\\Users\\marta\\Downloads\\logo.jpg", url + "\\logo.jpg");
        byte[] array = EinesByteStream.tornaBytes(url + "\\string");
        for (byte c : array) {
            System.out.print(c + " ");
        }
    }

    public void provesCharacter() {
        //url
        String url = "C:\\Users\\marta\\Downloads";
        EinesCharacterStream.mostraCharacters(url + "\\Himne dels pirates.txt");
        EinesCharacterStream.escriuCharacters(url + "\\dades", "Hola soy Joselito.");
        EinesCharacterStream.copiaCharacters(url + "\\dades", url + "\\hola");
        Cronometre cro = new Cronometre();
        cro.start();
        EinesCharacterStream.inutil(url + "\\Tirant lo Blanc - Joanot Martorell.txt");
        cro.stop();
        System.out.println("Cronometre: " + cro.temps());
    }

    public void provesBuffered() {
        String url = "C:\\Users\\marta\\Downloads";
        String[] array = EinesBufferedStream.mostraLine(url + "\\Himne dels pirates.txt");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        EinesBufferedStream.escriuLine(url + "\\dades", array);
        EinesBufferedStream.copiaLine(url + "\\dades", url + "\\origen");
        Cronometre cro = new Cronometre();
        cro.start();
        EinesBufferedStream.inutil(url + "\\dades");
        cro.stop();
        System.out.println("Cronometre Buffer: " + cro.temps());
    }

    public void provesDataStream() {
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros";
        double[] dades = {1.2, 2.3, 3.4, 4.5};
        EinesDataStream.guardaArray(url + "\\dadesDouble", dades);
        double[] array = EinesDataStream.recuperaArray(url + "\\dadesDouble");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Java heap es queda sense espai.");
    }

    public void provesObjecteSimple() {
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros";
        Dades objDades = new Dades(2, "Hola");
        EinesObjectStream.escriuObjecte(url + "\\dades", objDades);
        System.out.println(EinesObjectStream.llegeixObjecte(url + "\\dades"));
        System.out.println("Són iguals? " + objDades.equals(EinesObjectStream.llegeixObjecte(url + "\\dades")));
    }

    public void provesObjecteComplexe() {
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros";
        Dades objDades = new Dades(2, "Hola");
        DadesComplexes dadesComplexes = new DadesComplexes("Joselito", objDades);
        EinesObjectStream.escriuObjecte(url + "\\dadesComplexes", dadesComplexes);
        System.out.println(EinesObjectStream.llegeixObjecte(url + "\\dadesComplexes"));
        System.out.println("Són iguals? " + dadesComplexes.equals(EinesObjectStream.llegeixObjecte(url + "\\dadesComplexes")));
    }

    public void provesObjectLlista() {
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros";
        ArrayList<Dades> llistaDades = new ArrayList<Dades>();
        for (int i = 0; i < 10; i++) {
            llistaDades.add(new Dades(i, "Som l'objecte " + i));
        }
        EinesObjectStream.escriuObjecte(url + "\\llista", llistaDades);
        ArrayList<Dades> objLlegit = (ArrayList<Dades>) EinesObjectStream.llegeixObjecte(url + "\\llista");
        System.out.println(llistaDades);
        System.out.println(objLlegit);
        
        if (llistaDades.size() == objLlegit.size()) {
            System.out.println("Són iguals");
        } else {
            System.out.println("No són iguals.");
        }
    }

    public void provesMantenirReferencies() {        
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros";
        ArrayList<Dades> llistaDades = new ArrayList<Dades>();
        Dades original = new Dades(1, "original");
        llistaDades.add(original);
        llistaDades.add(original);
        original.setNumeric(3);
        System.out.println(llistaDades);
        EinesObjectStream.escriuObjecte(url + "\\llistaDades", llistaDades);
        ArrayList<Dades> recuperada = (ArrayList<Dades>) EinesObjectStream.llegeixObjecte(url + "\\llistaDades");
        System.out.println(llistaDades);
        System.out.println(recuperada);      
        llistaDades.get(0).setNumeric(2);
        System.out.println(llistaDades); 
        // Es mantenen les referències
    }

    public static void main(String[] args) {
        ProvesStreams exe = new ProvesStreams();
        //exe.provesByte();
        //exe.provesCharacter();
        //exe.provesBuffered();
        //exe.provesDataStream();
        //exe.provesObjecteSimple();
        //exe.provesObjecteComplexe();
        //exe.provesObjectLlista();
        exe.provesMantenirReferencies();
    }

}
