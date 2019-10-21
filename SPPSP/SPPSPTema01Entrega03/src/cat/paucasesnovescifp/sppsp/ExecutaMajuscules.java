/*
 *  Marta Córcoles Valle
 * 
 */
package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class ExecutaMajuscules {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Process pare = null;
        String texto;

        do {
            texto = sc.nextLine();
            try (BufferedReader bw = new BufferedReader(new InputStreamReader(pare.getInputStream()))) {
                   System.out.println(bw.readLine());
            } catch (IOException ex) {
                Logger.getLogger(ExecutaMajuscules.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (!texto.equals("sortir"));
    }

}
