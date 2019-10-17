package cat.paucasesnovescifp.sppsp.programa;

/**
 *
 * @author marta
 */
public class Numeros {
       
    // método suma, devuelve la suma de dos numeros
    public int suma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Numeros exe = new Numeros();
        System.out.println(exe.suma(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
    
}
