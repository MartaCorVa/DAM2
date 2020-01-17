package cat.paucasesnovescifp.sppsp;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int numCajeras = 1;

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        // Coa1=C1,C3,C5,C7
        // Coa2=C2,C4,C6,C8
        // Coa1=C1,C2,C3,C4,C5,C6,C7,C8

//        clientes.add(new Cliente("Client 1", new int[] { 2, 2, 1, 5, 2, 3 }));
        clientes.add(new Cliente("Client 2", new int[] { 1, 3, 5, 1, 1 }));
//        clientes.add(new Cliente("Client 3", new int[] { 2, 3, 3, 1, 2, 6 }));
        clientes.add(new Cliente("Client 4", new int[] { 6, 2, 5, 9, 1 }));
//        clientes.add(new Cliente("Client 5", new int[] { 9, 2, 1, 1, 1 }));
        clientes.add(new Cliente("Client 6", new int[] { 1, 1, 1, 1, 1 }));
//        clientes.add(new Cliente("Client 7", new int[] { 3, 5, 3, 5, 6, 3 }));
        clientes.add(new Cliente("Client 8", new int[] { 1, 1, 1 }));


        long init = System.currentTimeMillis();  // Instante inicial del procesamiento

        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
        for (Cliente cliente: clientes) {
            Runnable cajera = new CajeraRunnable(cliente, init);
            executor.execute(cajera);
        }
        executor.shutdown();	// Cierro el Executor
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos
            // para pasar a las siguientes instrucciones
        }

        long fin = System.currentTimeMillis();	// Instante final del procesamiento
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
    }
}
