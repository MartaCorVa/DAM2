package cat.paucasesnoves.sppsp.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Menu {

    public void imprimeMenu() {
        System.out.println("1. Introduce tus datos.");
        System.out.println("2. Imprime el contenido del fichero.");
        System.out.println("3. Salir");
        System.out.println();
    }

    public String devolverString() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        return st;
    }

    public ArrayList<String> devolverDatos() {
        ArrayList<String> datos = new ArrayList<String>();
        System.out.println("Introduce tus apellidos: ");
        datos.add("Apellidos: " + devolverString());
        System.out.println("Introduce tu ciudad de nacimiento: ");
        datos.add("Ciudad de nacimiento: " + devolverString());
        return datos;
    }

    public void crearFichero(String destino, String nombre, ArrayList<String> datos) throws FicheroException {
        File fichero = new File(destino);
        if (!fichero.exists()) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(destino))) {
            out.write("Nombre: " + nombre);
            out.newLine();
            for (String a : datos) {
                out.write(a);
                out.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            throw new FicheroException("ERROR: El fichero ya existe.");
        }
        
    }

    public void leerFichero(String origen) throws FicheroException {
        File fichero = new File(origen);
        if (fichero.exists()) {
        try (BufferedReader in = new BufferedReader(new FileReader(origen))) {
            while (in.ready()) {
                System.out.println(in.readLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
        throw new FicheroException("ERROR: El fichero no existe.");
        }

    }
}
