package cat.paucasesnovescifp.sppsp;


/**
 *
 * @author marta
 */
public class Compara {

    public static void main(String[] args) {
        // Cream la variable num1 i l'hi afegim el primer argument
        int num1 = Integer.parseInt(args[0]);
        // Cream la variable num2 i l'hi afegim el segon argument
        int num2 = Integer.parseInt(args[1]);
                    
        // Feim un if() amb les tres condicions possibles
        if (num1 > num2) {
            System.out.println("Proces fill - El primer nombre " + num1 + " es major que el segon nombre " + num2);
        } else if (num1 < num2) {
            System.out.println("Proces fill - El primer nombre " + num1 + " es menor que el segon nombre " + num2);
        } else {
            System.out.println("Proces fill - El primer nombre " + num1 + " es igual que el segon nombre " + num2);
        }
    }
    
}
