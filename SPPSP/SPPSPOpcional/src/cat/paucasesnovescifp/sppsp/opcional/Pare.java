package cat.paucasesnovescifp.sppsp.opcional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Pare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcio;
        // Inicializamos Runtime
        Process p;
        BufferedReader br;

        System.out.println("Introduce un numero del menu: ");
        do {
            opcio = sc.nextInt();

            switch (opcio) {
                case 1: {
                    try {
                        p = Runtime.getRuntime().exec("C:\\Program Files\\Java\\jdk-11.0.3/bin/java -cp C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPOpcional\\dist\\SPPSPOpcional.jar cat.paucasesnoves.sppsp.opcional.Hijo1");
                        System.out.println(p.isAlive());
                        InputStreamReader isr = new InputStreamReader(p.getInputStream());
                        System.out.println(p.isAlive());
                        br = new BufferedReader(isr);
                        System.out.println(p.isAlive());
                    } catch (IOException ex) {
                        Logger.getLogger(Pare.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        } while (opcio != 4);

    }

}
