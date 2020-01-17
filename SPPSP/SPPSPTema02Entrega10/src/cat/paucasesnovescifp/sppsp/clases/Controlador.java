package cat.paucasesnovescifp.sppsp.clases;

import java.io.*;

public class Controlador {

    private String urlArchivoEntrada;
    private String urlArchivoSalida;
    private int contadorVocalIndividual;
    private String resultado = "";

    public Controlador(String urlArchivoEntrada, String urlArchivoSalida) {
        this.urlArchivoEntrada = urlArchivoEntrada;
        this.urlArchivoSalida = urlArchivoSalida;
    }

    public synchronized void  leer(char vocalMinuscula) throws IOException {
        contadorVocalIndividual = 0;
        //Leer el archivo
        FileReader archivo = new FileReader(urlArchivoEntrada);
        //leemos mientras haya caracteres
        while(archivo.ready()){
            //si es una vocal incrementamos el contador
            if(vocalMinuscula == archivo.read()){
                contadorVocalIndividual++;
            }
        }
        escribir(vocalMinuscula);
    }

    public void escribir(char vocal) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(urlArchivoSalida));
        resultado += "La vocal " + vocal + " " + contadorVocalIndividual + "\n";
        bw.write(resultado);
        bw.close();
    }
}
