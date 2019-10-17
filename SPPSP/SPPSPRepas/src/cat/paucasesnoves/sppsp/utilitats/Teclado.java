package cat.paucasesnoves.sppsp.utilitats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marta
 */
public class Teclado {
    
    InputStreamReader fluxe = new InputStreamReader(System.in);
    BufferedReader teclat = new BufferedReader(fluxe);
    
    public String llegirString() {
        String cadena = null;
        
        try {
            cadena = teclat.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }         
        return cadena;
    }
    
    public int llegirSencer() {
        int numero = 0;
        
        try {
            numero = Integer.parseInt(teclat.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return numero;
    }
    
    public float llegirFloat() {
        float numero = 0;
        
        try {
            numero = Float.parseFloat(teclat.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return numero;
    }
    
    public double llegirDouble() {
        double numero = 0;
        
        try {
            numero = Double.parseDouble(teclat.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return numero;
    }
}
