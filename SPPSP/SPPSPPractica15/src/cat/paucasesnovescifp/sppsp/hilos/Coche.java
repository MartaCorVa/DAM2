/*
package cat.paucasesnovescifp.sppsp.hilos;

import static cat.paucasesnovescifp.sppsp.hilos.Main.*;

public class Coche extends Thread{

    private boolean sentidoCoche;
    private int nombre;

    public Coche(int nombre) {
        this.nombre = nombre;
        sentidoCoche = getRandomBoolean();
    }

    // Elegir de manera random el sentido del coche.
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    @Override
    public void run() {
        try {
            permisoCruzar.acquire();
            System.out.println("El coche " + nombre + " ha entrado en el puente.");
            sleep(3000);
            System.out.println("El coche " + nombre + " ha salido del puente.");
            permisoCruzar.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public int getNombre() {
        return nombre;
    }
}
*/

package cat.paucasesnovescifp.sppsp.hilos;

public class Coche extends Thread{

    private boolean sentidoCoche;
    private int nombre;

    public Coche(int nombre, boolean sentidoCoche) {
        this.nombre = nombre;
        this.sentidoCoche = sentidoCoche;
    }

    @Override
    public void run() {
        try {
            System.out.println("El coche " + nombre + " se activa");
            if (sentidoCoche) {
                Main.carrilD.acquire();
                while(!Main.sentido){
                }
                Main.puente.acquire();
                System.out.println("El coche " + nombre + " ha entrado en el puente sentido Derecha.");
                sleep(100);
                Main.listacoches.acquire();
                Main.cochesD.pop();
                Main.contador++;
                System.out.println("El coche " + nombre + " ha salido del puente.");
                System.out.println("Han pasado " + Main.contador + " coches seguidos hacía la derecha.");
                cambiarSentido();
                Main.listacoches.release();
                Main.puente.release();
                Main.carrilD.release();
            }else {
                Main.carrilI.acquire();
                while(Main.sentido){}
                Main.puente.acquire();
                System.out.println("El coche " + nombre + " ha entrado en el puente sentido Izquierda.");
                sleep(100);
                Main.listacoches.acquire();
                Main.cochesI.pop();
                Main.contador++;
                System.out.println("El coche " + nombre + " ha salido del puente.");
                System.out.println("Han pasado " + Main.contador + " coches seguidos hacía la izquierda.");
                cambiarSentido();
                Main.listacoches.release();
                Main.puente.release();
                Main.carrilI.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getNombre() {
        return nombre;
    }

    private void cambiarSentido() {
        if(Main.contador >= 5) {
            Main.sentido = !Main.sentido;
            System.out.println("Cambio de sentido!");
            Main.contador = 0;
            try {
                Thread.sleep(3000);
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


