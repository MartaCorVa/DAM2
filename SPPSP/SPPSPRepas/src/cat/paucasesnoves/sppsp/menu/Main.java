package cat.paucasesnoves.sppsp.menu;

import java.util.Scanner;

/**
 *
 * @author marta
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int opcion = 0;
        boolean cerrar = false;
        String nombre;

        do {
            menu.imprimeMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Introduce tu nombre: ");
                        nombre = menu.devolverString();
                        menu.crearFichero("C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros\\" + nombre, nombre, menu.devolverDatos());
                    } catch (FicheroException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Introduce tu nombre: ");
                        nombre = menu.devolverString();
                        menu.leerFichero("C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros\\" + nombre);
                    } catch (FicheroException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    cerrar = true;
                    break;
            }
        } while (cerrar == false);

    }

}
