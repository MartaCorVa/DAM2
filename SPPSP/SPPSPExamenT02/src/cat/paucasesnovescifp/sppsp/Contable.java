package cat.paucasesnovescifp.sppsp;

import java.io.*;

public class Contable extends Thread{

    private char lletra;
    private String fitxer;
    private long quantitat;

    public Contable(char lletra, String fitxer) {
        this.lletra = lletra;
        this.fitxer = fitxer;
    }

    public void run(){

        try {
            llegueix(lletra);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public synchronized void  llegueix(char lletra) throws IOException {
        quantitat = 0;
        String linia;
        String factura = "";
        //Leer el archivo
        BufferedReader archivo = new BufferedReader(new FileReader(fitxer));
        while(archivo.ready()){
            if(lletra == archivo.read()){
                while ((linia = archivo.readLine()) != null) {
                    if (lletra == 'A') {
                        Main.compte_bancari_A += Long.parseLong(linia.replaceAll("[^0-9.]", ""));
                    }
                    if (lletra == 'B') {
                        Main.compte_bancari_B += Long.parseLong(linia.replaceAll("[^0-9.]", ""));
                    }
                    if (lletra == 'F') {
                        factura = "Hem hagut de pagar: " + Long.parseLong(linia.replaceAll("[^0-9.]", ""));
                    }
                    escriure(lletra, factura);
                }
                quantitat++;
            }
        }
    }

    public void escriure(char lletra, String factura) throws IOException {
        String resultat = "";
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPExamenT02\\src\\cat\\paucasesnovescifp\\sppsp\\recursos\\sortida.txt"));

        resultat += "S'ha cobrat oficialment: " + Main.compte_bancari_A;
        resultat += "S'ha cobrat en negre: " + Main.compte_bancari_B;
        resultat += factura;
        resultat += "Al final l'empresa ha obtingut 75€ de beneficis.";
        bw.write(resultat);
        bw.close();
    }
}
