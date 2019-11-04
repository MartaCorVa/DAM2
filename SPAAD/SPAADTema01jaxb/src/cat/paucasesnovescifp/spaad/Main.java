package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.controlador.Controller;
import cat.paucasesnovescifp.spaad.model.Curs;
import cat.paucasesnovescifp.spaad.model.CursV2;
import cat.paucasesnovescifp.spaad.model.Modul;
import java.util.ArrayList;

/**
 *
 * @author marta
 */
public class Main {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPAAD\\SPAADTema01jaxb\\src\\cat\\paucasesnovescifp\\spaad\\recursos";
        System.out.println(Controller.llegeixModul(ruta + "\\modul.xml"));
        Controller.escriuModul(ruta + "\\modul.xml", new Modul("sppsp", "Processos", 8));
        System.out.println(Controller.llegeixCurs(ruta + "\\curs.xml"));

        ArrayList<Modul> moduls = new ArrayList<Modul>();
        moduls.add(new Modul("sppsp", "Processos", 8));
        moduls.add(new Modul("eie", "Empreses", 3));
        Curs curs = new Curs("S2P", "DAM", moduls);
        Controller.escriuCurs(ruta + "\\curs.xml", curs);
        CursV2 cursv2 = new CursV2("S2P", "DAM", moduls);
        System.out.println(Controller.llegeixCursV2(ruta + "\\cursV2.xml"));
        Controller.escriuCursV2(ruta + "\\cursV2.xml", cursv2);

        Modul modul = (Modul) Controller.llegir(ruta + "\\modul.xml", Modul.class);
        System.out.println("modul = " + modul);
        Controller.escriure(ruta + "\\modul.xml", modul);

        Curs curs2 = (Curs) Controller.llegir(ruta + "\\curs.xml", Curs.class);
        System.out.println("curs = " + curs2);
        Controller.escriure(ruta + "\\curs.xml", curs2);
        
        CursV2 curs2V2 = (CursV2) Controller.llegir(ruta + "\\curs.xml", CursV2.class);
        System.out.println("curs = " + curs2V2);
        Controller.escriure(ruta + "\\curs.xml", curs2V2);
    }

}
