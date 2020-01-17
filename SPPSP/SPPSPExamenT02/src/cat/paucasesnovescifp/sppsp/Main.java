package cat.paucasesnovescifp.sppsp;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    volatile static int semafor = 0;
    static long compte_bancari_A = 0;
    static long compte_bancari_B = 0;

    public static void main(String[] args) {
        int opcio;
        boolean correcte = true;
        Scanner sc = new Scanner(System.in);

        // creació d'un menu per escogir l'opció
        System.out.println("Escull una opció: ");
        System.out.println("Exercici 1 -> 1");
        System.out.println("Exercici 2 -> 2");

        do {
            // agafam l'opció per teclat i segons aquesta executam un exercici o l'altre
            opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    try {
                        Exercici01();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    Exercici02();
                    break;
                default:
                    correcte = false;
                    System.out.print("Opció incorrecte.");
                    break;
            }
        } while (correcte);
    }

    public static void Exercici02() {
        // fitxer entrada
        String fitxer = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPExamenT02\\src\\cat\\paucasesnovescifp\\sppsp\\recursos\\entrada.txt";
        // creació d'objectes Contable
        Contable a = new Contable('A',fitxer);
        Contable b = new Contable('B',fitxer);
        Contable f = new Contable('F',fitxer);

        // executam els fils
        a.start();
        b.start();
        f.start();
    }


    public static void Exercici01() throws InterruptedException {
        // contador per executar tan sols 10 vegades
        int contador = 0;
        // creació de fils
        FillTIC fillTIC = new FillTIC();
        FillTAC fillTAC = new FillTAC();
        FillTOC fillTOC = new FillTOC();

        // executam els fils fins que contador sigui 10
        // utilitzam la variable semafor per canviar de fil
        do {
            if (semafor == 0) {
                fillTIC.start();
                semafor++;
            } else if (semafor == 1) {
                fillTAC.start();
                semafor++;
            } else {
                fillTOC.start();
                semafor = 0;
            }
            contador++;
        } while (contador != 10);
    }

    // fil que imprimira tic
    public static class FillTIC extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("TIC");
                try {
                    FillTIC.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    // Fil que imprimira tac
    public static class FillTAC extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("    TAC");
                    FillTAC.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    // Fil que imprimira Toc
    public static class FillTOC extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("        TOC");
                    FillTOC.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
