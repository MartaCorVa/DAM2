package cat.paucasesnovescifp.sppsp.hilos;/*package cat.paucasesnovescifp.sppsp.hilos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

    static Semaphore permisoCruzar = new Semaphore(1);
    static Semaphore modificarListaCoche = new Semaphore(1);
    static ArrayList<Coche> coches = new ArrayList<Coche>();
    static boolean sentidoEnCurso = true;
    private static int tiempo;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            crearCoche(i);
        }
        lanzaCoche();
    }

    private static void crearCoche(int nombre) {
        try {
            modificarListaCoche.acquire();
            coches.add(new Coche(nombre));
            modificarListaCoche.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void lanzaCoche() {
        for (Coche c : coches) {
            c.start();
        }
    }
}*/

/*
package cat.paucasesnovescifp.sppsp.hilos;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static LinkedList<Coche> cochesD = new LinkedList<>();
    public static LinkedList<Coche> cochesI = new LinkedList<>();
    public static Semaphore listacoches = new Semaphore(1);
    public static Semaphore puente = new Semaphore(3);
    public static int contador = 0;
    public static boolean sentido = false;

    public static void main(String[] args) {
        System.out.println("Se activa la cola");
        Cola cola = new Cola();
        cola.start();
        pruebaSacarCoches();
    }

    public static void pruebaSacarCoches(){
        while (true) {
            try {
                double tempsd = Math.random() * 15;
                long temps = (long) tempsd;
                Thread.sleep(temps);
                if(!sentido) {
                    if (cochesI.size() > 0) {
                        listacoches.acquire();
                        Coche c = cochesI.pop();
                        contador++;
                        if(contador >= 5)
                            sentido = !sentido;
                        System.out.println("Coche " + c.getNombre() + " ha salido del puente");
                        listacoches.release();
                    }
                }else{
                    if (cochesD.size() > 0) {
                        listacoches.acquire();
                        Coche c = cochesD.pop();
                        contador++;
                        if(contador >= 5)
                            sentido = !sentido;
                        System.out.println("Coche " + c.getNombre() + " ha salido del puente");
                        listacoches.release();
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}


class Cola extends Thread {
    int i = 0;
    public void run(){
        while(true){
            try {
                double tempsd = Math.random() * 10;
                long temps = (long)tempsd;
                Thread.sleep(temps);
                boolean direccion =  Math.random() < 0.5;
                Main.listacoches.acquire();
                i++;

                if(direccion){
                    System.out.println("Ha llegado el coche " + i + " con dirección derecha");
                    Main.cochesD.add(new Coche(i));
                }
                else {
                    System.out.println("Ha llegado el coche " + i + " con dirección izquierda");
                    Main.cochesI.add(new Coche(i));
                }
                Main.listacoches.release();
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
*/


import cat.paucasesnovescifp.sppsp.hilos.Coche;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static LinkedList<Coche> cochesD = new LinkedList<>();
    public static LinkedList<Coche> cochesI = new LinkedList<>();
    public static Semaphore listacoches = new Semaphore(1);
    public static Semaphore carrilD = new Semaphore(3);
    public static Semaphore carrilI= new Semaphore(3);
    public static Semaphore puente= new Semaphore(3);
    public static int contador = 0;
    public static boolean sentido = false;

    public static void main(String[] args) {
        System.out.println("Se activa la cola");
        Cola cola = new Cola();
        Lanzador lanzador = new Lanzador();
        cola.start();
        lanzador.start();
    }

    public static void pruebaSacarCoches(){
        while (true) {
            try {
                double tempsd = Math.random() * 15;
                long temps = (long) tempsd;
                Thread.sleep(temps);
                if(!sentido) {
                    if (cochesI.size() > 0) {
                        listacoches.acquire();
                        Coche c = cochesI.pop();
                        contador++;
                        if(contador >= 5)
                            sentido = !sentido;
                        System.out.println("Coche " + c.getNombre() + " ha salido del puente");
                        listacoches.release();
                    }
                }else{
                    if (cochesD.size() > 0) {
                        listacoches.acquire();
                        Coche c = cochesD.pop();
                        contador++;
                        if(contador >= 5)
                            sentido = !sentido;
                        System.out.println("Coche " + c.getNombre() + " ha salido del puente");
                        listacoches.release();
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}


class Cola extends Thread {
    int i = 0;
    public void run(){
        while(true){
            try {
                double tempsd = Math.random() * 100;
                long temps = (long)tempsd;
                Thread.sleep(temps);
                boolean direccion =  Math.random() < 0.5;
                Main.listacoches.acquire();
                i++;
                if(Main.cochesD.size() == 0) {
                    System.out.println("No hay nadie en el lado derecho");
                    if(Main.sentido) {
                        cambiarSentido();
                    }
                }
                if(Main.cochesI.size() == 0) {
                    System.out.println("No hay nadie en el lado izquierdo");
                    if(!Main.sentido) {
                        cambiarSentido();
                    }
                }

                if(direccion){
                    System.out.println("Ha llegado el coche " + i + " con dirección derecha");
                    Main.cochesD.add(new Coche(i, direccion));
                }
                else {
                    System.out.println("Ha llegado el coche " + i + " con dirección izquierda");
                    Main.cochesI.add(new Coche(i, direccion));
                }
                Main.listacoches.release();
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void cambiarSentido() {
        Main.sentido = !Main.sentido;
        if(Main.sentido)System.out.println("Cambio de sentido a la Derecha!");
        else System.out.println("Cambio de sentido a la Izquierda!");
        Main.contador = 0;
    }
}

class Lanzador extends Thread {
    public void run(){
        try {
            while(true){
                Main.listacoches.acquire();
                for(int i = 0; i < Main.cochesD.size(); i++) {
                    if(!Main.cochesD.get(i).isAlive())Main.cochesD.get(i).start();
                }
                Main.listacoches.release();
                sleep(100);
                Main.listacoches.acquire();
                for(int i = 0; i < Main.cochesI.size(); i++) {
                    if(!Main.cochesI.get(i).isAlive())Main.cochesI.get(i).start();
                }
                Main.listacoches.release();
                sleep(100);

            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

