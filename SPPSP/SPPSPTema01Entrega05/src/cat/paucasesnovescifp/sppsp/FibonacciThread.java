package cat.paucasesnovescifp.sppsp;

/**
 *
 * @author marta
 */
public class FibonacciThread extends Thread{
    
    //Creamos una variable de tipo int.
    private int num;

    public FibonacciThread(int num) {
        this.num = num;
    }
           
    // El método run() ejecutará el código para realizar la succesion
    // de Fibonacci.
    @Override
    public void run(){
        // Iniciamos Fibonacci con los números 0 y 1.
        int fibo01 = 0;
        int fibo02 = 1;

        // Creamos un bucle para ir sacando los números hasta que se ejecute las veces
        // que le hemos indicado.
        for (int i = 0; i <= num; i++) {
            // Controlamos con un if si el número és 0 o 1, ya que estos se tienen
            // que imprimir directamente hasta que nuestra variable fibo01 sea 1.
            if (i == 0 || i == 1) {
                System.out.print(fibo01 + ", ");
            } else {
                // Cuando fibo01 = 1 y fibo02 = 1 empezamos a calcular los siguientes
                // numeros usando la fórmula.
                System.out.print(fibo02 + ", ");
                fibo02 = fibo01 + fibo02;
                fibo01 = fibo02 - fibo01;
            }
        }
    }
    
}
