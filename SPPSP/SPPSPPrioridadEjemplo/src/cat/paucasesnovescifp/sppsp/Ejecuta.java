package cat.paucasesnovescifp.sppsp;

import java.util.Scanner;

/**
 *
 * @author marta
 */
public class Ejecuta {

    public static void main(String[] args) {
        // Creamos un scanner para obtener el número que usaremos en el menú.
        Scanner sc = new Scanner(System.in);
        // Creamos la variable opcion que será utilizada en el menú.
        int opcion;
        // Imprimimos las opciones del menú.
        System.out.println("1. Ejecuta Fibonacci con la clase Thread.");
        System.out.println("2. Ejecuta Fibonacci con la clase Runnable.");
        System.out.println("3. Salir.");
        // Creamos un do while para ejecutar el programa hasta que el usuario
        // introduzca el número 3.
        do { 
            // Introducimos en la variable opción el número que nos introduzcan
            // por teclado.
            opcion = sc.nextInt();    
            // Hacemos un switch para controlar la variable opcion y ejecutar el caso correcto.
            switch (opcion) {
                // El caso 1 ejecutara Fibonacci usando la clase Thread.
                case 1:
                    System.out.print("Thread: ");
                    // Creamos un hilo de la clase FibonacciThread y iniciamos el proceso.
                    // Le pasamos el número que usaremos para determinar cuantas succesiones se harán.
                    new FibonacciThread(7).start();
                    break;
                // El caso 2 ejecutara Fibonacci usando la interfaz Runnable.
                case 2:
                    System.out.print("Runnable: ");
                    // Creamos un objeto de la clase FibonacciRunnable y le pasamos el número 
                    //que usaremos para determinar cuantas succesiones se harán.
                    new FibonacciRunnable(10);
                    break;
                // El caso 3 hará que salgamos del programa.
                case 3:
                    break;
            }
        } while (opcion != 3);
    }

}
