package cat.paucasesnovescifp.sppsp;

import cat.paucasesnovescifp.sppsp.clases.Controlador;
import cat.paucasesnovescifp.sppsp.clases.HiloVocal;

public class Principal {
    public static void main(String[] args) {
        String entrada = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPTema02Entrega10\\src\\cat\\paucasesnovescifp\\sppsp\\recursos\\entrada";
        String salida = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPTema02Entrega10\\src\\cat\\paucasesnovescifp\\sppsp\\recursos\\vocales.txt";

        Controlador controladorHilos = new Controlador(entrada,salida);
        HiloVocal a = new HiloVocal(controladorHilos,'a');
        HiloVocal e = new HiloVocal(controladorHilos,'e');
        HiloVocal i = new HiloVocal(controladorHilos,'i');
        HiloVocal o = new HiloVocal(controladorHilos,'o');
        HiloVocal u = new HiloVocal(controladorHilos,'u');

        a.start();
        e.start();
        i.start();
        o.start();
        u.start();
    }
}
