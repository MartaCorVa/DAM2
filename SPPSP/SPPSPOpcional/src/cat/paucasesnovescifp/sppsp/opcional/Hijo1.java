package cat.paucasesnovescifp.sppsp.opcional;

import java.util.Scanner;

/**
 *
 * @author marta
 */
public class Hijo1 {
    
    public static void main(String[] args) {
        // Suma 2 valores que te den por pantalla.
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número: ");
        int a = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        int b = sc.nextInt();
        System.out.println(a+b);
    }
    
}
