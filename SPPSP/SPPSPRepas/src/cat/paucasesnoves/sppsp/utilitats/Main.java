package cat.paucasesnoves.sppsp.utilitats;

/**
 *
 * @author marta
 */
public class Main {

    public static void main(String[] args) {
        Teclado sc = new Teclado();

        System.out.println("String: ");
        System.out.println(sc.llegirString());
        System.out.println("Int: ");
        System.out.println(sc.llegirSencer());
        System.out.println("Float: ");
        System.out.println(sc.llegirFloat());
        System.out.println("Double: ");
        System.out.println(sc.llegirDouble());
    }

}
