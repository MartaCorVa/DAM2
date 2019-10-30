package cat.paucasesnovescifp.spaad.streams;

import cat.paucasesnovescifp.spaad.model.Film;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Fitxers {

    //Exercici02
    public static void escriuCharacters(String ruta, String film) throws IOException {
        try (FileWriter out = new FileWriter(ruta)) {
            out.write(film);
        }
    }

    public static String mostraCharacters(String ruta) throws FileNotFoundException, IOException {
        String cadena = "";
        try (FileReader in = new FileReader(ruta)) {
            while (in.ready()) {
                char d = (char) in.read();
                cadena += d;
            }
            return cadena;
        }
    }
    
    //Exercici03
    public static void escriuObjecte(String ruta, Serializable obj) throws FileNotFoundException, IOException, FileNotFoundException, IOException, IOException, IOException, FileNotFoundException, IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)))) {
            out.writeObject(obj); 
        } 
    }
        
    public static Object llegeixObjecte(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException {
        Film film = null;
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta)))) {
             film = (Film) in.readObject(); 
        } 
        return film;
    }
}
