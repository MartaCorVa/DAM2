package cat.paucasesnoves.sppsp.eines;

import java.util.Scanner;
/**
 *
 * @author marta
 */
public class Main {

    public static void main(String[] args) {
        String url = "C:\\Users\\marta\\Downloads";
        Eines.llegirFitxer(url + "\\dades");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el teu text: ");
        String text = sc.nextLine();
        try {
            Eines.escriuFitxer(text, url + "\\dades");
        } catch (BuitException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

}
