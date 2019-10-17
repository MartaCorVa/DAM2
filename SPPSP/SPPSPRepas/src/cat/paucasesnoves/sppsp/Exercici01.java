package cat.paucasesnoves.sppsp;

import java.util.Scanner;

/**
 *
 * @author marta
 */
public class Exercici01 {

    public double suma(double a, double b) {
        return a + b;
    }

    public double resta(double a, double b) {
        return a - b;
    }

    public double multiplicacio(double a, double b) {
        return a * b;
    }

    public double divisio(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Exercici01 exe = new Exercici01();
        //int a = 2;
        //int b = 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix un valor per a: ");
        double a = sc.nextDouble();
        System.out.println("Introdueix un valor per b: ");
        double b = sc.nextDouble();

        System.out.println("La suma de " + a + " i " + b + " és " + exe.suma(a, b));
        System.out.println("La resta de " + a + " i " + b + " és " + exe.resta(a, b));
        System.out.println("La multiplicacio de " + a + " i " + b + " és " + exe.multiplicacio(a, b));
        System.out.println("La divisio de " + a + " i " + b + " és " + exe.divisio(a, b));

    }

}
