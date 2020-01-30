package cat.paucasesnovescifp.swdws;

import cat.paucasesnovescifp.swdws.controller.Persistencia;
import cat.paucasesnovescifp.swdws.model.Autor;
import cat.paucasesnovescifp.swdws.model.Llibre;

import java.util.ArrayList;

public class Examen {
    public static void main(String[] args) {
        Persistencia pers=new Persistencia("./examen.db4o");
        String url = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPAAD\\SPAADExamenOODB\\src\\cat\\paucasesnovescifp\\swdws\\bbdd\\bbdd.bd";

        //Exercici 1
        /*pers.creaBaseDades(url);*/

        //Exercici 2
        /*ArrayList<Autor> autors = pers.tornaTotsAutors(url);
        for (Autor a : autors){
            System.out.println(a);
        }*/

        //Exercici 3
        /*Autor autor = pers.tornaAutorCN(url, 1);
        System.out.println(autor);*/

        //Exercici 4
        /*Llibre llibre = pers.tornaLlibreTitol(url, "LLIBRE D'AMIC E AMAT");
        System.out.println(llibre);*/

        //Exercici 5
        /*ArrayList<Llibre> llibres = pers.tornaLlibreNumEdicio(url);
        for (Llibre l : llibres) {
            System.out.println(l);
        }*/

        //Exercici 6
        /*pers.esborraAutor(url, 1);*/
    }
}
