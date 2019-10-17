
import cat.paucasesnovescifp.spadd.auxiliar.Dades;
import cat.paucasesnovescifp.spadd.eines.EinesBufferedStream;
import cat.paucasesnovescifp.spadd.eines.EinesObjectStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    
}
