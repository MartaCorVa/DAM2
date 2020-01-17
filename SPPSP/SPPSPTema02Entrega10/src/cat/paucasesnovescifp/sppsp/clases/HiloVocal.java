package cat.paucasesnovescifp.sppsp.clases;

import java.io.IOException;

public class HiloVocal extends Thread{

    private Controlador controlador;
    private char vocalMinuscula;

    public HiloVocal(Controlador controlador, char vocalMinuscula){
        this.controlador = controlador;
        this.vocalMinuscula = vocalMinuscula;
    }

    public void run(){

        try {
            controlador.leer(vocalMinuscula);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
