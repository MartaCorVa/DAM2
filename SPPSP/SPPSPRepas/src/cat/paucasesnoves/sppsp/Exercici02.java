package cat.paucasesnoves.sppsp;

import java.util.Scanner;

/**
 *
 * @author marta
 */
public class Exercici02 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el teu nom: ");
        String nom = sc.nextLine();
        System.out.println("Introdueix la nota de la primera avaluació: ");
        double a = sc.nextDouble();
        System.out.println("Introdueix la nota de la segona avaluació: ");
        double b = sc.nextDouble();
        System.out.println("Introdueix la nota de la tercera avaluació: ");
        double c = sc.nextDouble();
        
        double mitjana = (a + b + c) / 3;
        System.out.println("La mitjana de " + nom + " és " + mitjana);
    }
    
}
