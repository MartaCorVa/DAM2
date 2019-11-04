package cat.paucasesnovescifp.sppsp;

/**
 *
 * @author marta
 */
public class FibonacciRunnable implements Runnable{

    // Creamos una variable de tipo Thread.
    Thread hilo;
    // Creamos una variable de tipo int.
    private int num;

    // Usamos el constructor de la clase para iniciar el hilo con el numero
    // que nos hayan introducido en el main.
    public FibonacciRunnable(int num) {
        // Inicializamos el hilo.
        hilo = new FibonacciThread(num);
        // Ejecutamos el hilo.
        hilo.start();
    }

    @Override
    public void run() {
        System.out.println("Runnable run()");
    }
    
}
