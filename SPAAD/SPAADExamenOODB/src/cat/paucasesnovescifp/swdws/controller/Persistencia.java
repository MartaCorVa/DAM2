package cat.paucasesnovescifp.swdws.controller;

import cat.paucasesnovescifp.swdws.model.Autor;
import cat.paucasesnovescifp.swdws.model.Llibre;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private ArrayList<Autor> autors;
    private ArrayList<Llibre> llibres;
    private String ruta;

    public Persistencia(String ruta) {
        this.ruta = ruta;
        autors = new ArrayList<>();
        llibres = new ArrayList<>();
        inicialitza();
    }

    private void inicialitza() {
        Autor a1 = new Autor(1, "LLULL, RAMON");
        autors.add(a1);
        Llibre l1 = new Llibre(1, "LLIBRE D'AMIC E AMAT", "PALMA DE MALLORCA", "2", 1991, "107 P.  20 CM", "84-273-051", "B.28.461", "CAT-LLU", a1);
        llibres.add(l1);
        Llibre l119 = new Llibre(119, "LLIBRE DE MERAVELLES.", "BARCELONA", "2", 1993, "140 P. :IL. 21 CM", "84-307-844", null, "CAT-LLU", a1);
        llibres.add(l119);
        Llibre l1236 = new Llibre(1236, "LLIBRE DE LES BESTIES.", "BARCELONA", null, 1991, "157 P. :IL. 21 CM", "84-7533-60", null, "CAT-LLULL", a1);
        llibres.add(l1236);
        Llibre l1427 = new Llibre(1427, "LLIBRE DE L'ORDE DE CAVALLERIA.", "BARCELONA", "2ª", 1981, "90 P. 18 CM", "84-297-163", null, "CAT-LLULL", a1);
        llibres.add(l1427);
        Llibre l1651 = new Llibre(1651, "LLIBRE DE MERAVELLES", "BARCELONA", null, 1980, "358 P. 18 CM", "84-297-160", null, "CAT-LLULL", a1);
        llibres.add(l1651);
        Llibre l1696 = new Llibre(1696, "LLIBRE D'EVAST E BLANQUERNA.", "BARCELONA", null, 1982, "354 P. 18 CM", "84-297-188", null, "CAT-LLULL", a1);
        llibres.add(l1696);
        Llibre l5095 = new Llibre(5095, "OBRES. VOL. 7. LLIBRE DE CONTEMPLACIO EN DÉU, TOM VI", "PALMA", null, 1999, "FACS. 480P. 21CM", "84-7967-035-5", null, "FIL LLU OBR", a1);
        llibres.add(l5095);
        Llibre l6358 = new Llibre(6358, "OBRES DE RAMON LLULL VOLUM I", "PALMA DE MALLORCA", "1", 1986, "20CM-475 PP", "84-86366-13-5", "PM.158-1986", "CAT-LLU-OBR", a1);
        llibres.add(l6358);
        Llibre l6359 = new Llibre(6359, "OBRES DE RAMON LLULL VOLUM II", "PALMA DE MALLORCA", "1", 1987, "20CM-380PP", "84-86366-32-1", "PM.203-1987", "CAT-LLU-OBR", a1);
        llibres.add(l6359);
        Llibre l6360 = new Llibre(6360, "OBRES DE RAMON LLULL VOLUM III", "PALMA DE MALLORCA", "1", 1989, "20CM- 274 PP", "84-86366-58-5", "PM.561-1989", "CAT-LLU-OBR", a1);
        llibres.add(l6360);
        Llibre l6361 = new Llibre(6361, "OBRES DE RAMON LLULL VOLUM IV", "PALMA DE MALLORCA", "1", 1992, "20CM- 423 PP", "84-86366-74-7", "PM.10-1992", "CAT-LLU-OBR", a1);
        llibres.add(l6361);
        Autor a2 = new Autor(2, "MAURA, GABRIEL");
        autors.add(a2);
        Llibre l2 = new Llibre(2, "AIGOFORTS", "PALMA DE MALLORCA", "2", 1991, "206 P. 20 CM", "84-273-051", "B.27.414", "CAT-GAB", a2);
        llibres.add(l2);
        Autor a3 = new Autor(3, "COSTA I LLOBERA, MIQUEL");
        autors.add(a3);
        Llibre l3 = new Llibre(3, "TRADICIONS I FANTASIES", "PALMA DE MALLORCA", "1", 1987, "158 P. 20 CM", "84-273-051", "B.15.326.8", "CAT-COS", a3);
        llibres.add(l3);
        Llibre l34 = new Llibre(34, "HORACIANES", "PALMA DE MALLORCA", null, 1990, "125 P. 20 CM", "84-273-063", "PM.409-199", "CAT-COS", a3);
        llibres.add(l34);
        Llibre l1701 = new Llibre(1701, "HORACIANES I ALTRES POEMES", "BARCELONA", null, 1982, "137 P. 18 CM", "84-297-180", null, "CAT-COS", a3);
        llibres.add(l1701);
        Llibre l5079 = new Llibre(5079, "DE L'AGRE DE LA TERRA. LA LLEGENDA DEL PUIG DE POLLENÇA", "PALMA", null, 1997, "IL COL. 226P. 16CM", "84-273-0774-8", null, "P CAT COS DEL", a3);
        llibres.add(l5079);
        Autor a4 = new Autor(4, "SANTS OLIVER, MIQUEL DELS");
        autors.add(a4);
        Llibre l4 = new Llibre(4, "CIUTAT DE MALLORQUES, LA", "PALMA DE MALLORCA", null, 1987, "131 P. 20 CM", "84-273-051", "B-1867087", "CAT-SAN", a4);
        llibres.add(l4);
        Llibre l6413 = new Llibre(6413, "HOJAS DEL SABADO. REVISIONES Y CENTENARIOS (II)", "PALMA", "1", 2001, "22 CM-207 PP", "84-88946-84-8", "PM-1221-1999", "SOC-OLI- HOJ", a4);
        llibres.add(l6413);
        Autor a5 = new Autor(5, "ALCANTARA PENYA, PERE DE");
        autors.add(a5);
        Llibre l5 = new Llibre(5, "TEATRE", "PALMA DE MALLORCA", null, 1987, "170 P. 20 CM", "84-273-051", "B-19.234.8", "CAT-ALC", a5);
        llibres.add(l5);
        Autor a6 = new Autor(6, "GALMES, SALVADOR");
        autors.add(a6);
        Llibre l6 = new Llibre(6, "DIDA I ALTRES NARRACIONS, LA", "PALMA DE MALLORCA", null, 1987, "149 P. 2OCM", "84-273-051", "B-19.235.8", "CAT-GAL", a6);
        llibres.add(l6);
        Llibre l5077 = new Llibre(5077, "DIDA, LA. VERSIO TEATRAL DE MARIA A. OLIVER", "PALMA", null, 1996, "120P. 16CM", "84-273-3154-1", null, "T CAT GAL DID", a6);
        llibres.add(l5077);
        Autor a7 = new Autor(7, "GINER, SALVADOR");
        autors.add(a7);
        Autor a8 = new Autor(8, "RIBER, LLORENÇ");
        autors.add(a8);
        Llibre l8 = new Llibre(8, "CAMINS DEL PARADIS PERDUT, ELS", "PALMA DE   MALLORCA", null, 1987, "191 P. 20 CMS", "84-273-051", "B-21.659.8", "CAT-RIB", a8);
        llibres.add(l8);
        Llibre l1483 = new Llibre(1483, "MINYONIA D'UN INFANT ORAT, LA", "MALLORCA", null, 1984, "140, 20 P. :IL. 25 CM", "84-398-035", null, "CAT-RIB", a8);
        llibres.add(l1483);
        Llibre l1765 = new Llibre(1765, "MINYONIA D'UN INFANT ORAT, LA", "PALMA DE MALLORCA", null, 1981, "123 P. 21 CM", "84-85354-62-3", "B-35735-1981", "CAT-RIB-MIN", a8);
        llibres.add(l1765);
        Autor a9 = new Autor(9, "ALCOVER, JOAN");
        autors.add(a9);
        Llibre l9 = new Llibre(9, "CAP AL TARD", "PALMA DE MALLORCA", null, 1987, "155 P. 20 CMS", "84-273-051", "B-21.660.8", "CAT-ALC", a9);
        llibres.add(l9);
        Llibre l21 = new Llibre(21, "HUMANITZACIO DE L'ART : I ALTRES ESCRITS", "PALMA DE MALLORCA", null, 1988, "139 P. 20 CM", "84-273-054", "B-6110-88", "CAT-ALC", a9);
        llibres.add(l21);
        Llibre l1387 = new Llibre(1387, "ANTOLOGIA : POESIA. ASSAIG.", "PALMA DE MALLORCA", null, 1976, "126 P. 15 CM", "84-400-193", null, "CAT-ALC", a9);
        llibres.add(l1387);
        Llibre l1670 = new Llibre(1670, "CAP AL TARD; POEMES BIBLICS", "BARCELONA", null, 1981, "150 P. 18 CM", "84-297-168", null, "CAT-ALC", a9);
        llibres.add(l1670);
        Llibre l4042 = new Llibre(4042, "CAP AL TARD; POEMES BIBLICS", "BARCELONA", "4", 1998, "150 P. 18 CM", "84-297-168", null, "CAT-ALC", a9);
        llibres.add(l4042);
        Autor a10 = new Autor(10, "FERRA, BARTOMEU");
        autors.add(a10);
        Llibre l10 = new Llibre(10, "TEATRE", "PALMA DE MALLORCA", null, 1987, "204 P. 20 CMS", "84-273-052", "B-24.634.8", "CAT-FER", a10);
        llibres.add(l10);
        Llibre l4868 = new Llibre(4868, "CIUTAT HA SEIXANTA ANYS 1850-1900", "PALMA", null, 1996, "IL. 158P. 21CM. DETERIORAT", "84-7967-056-8", null, "DIV FER CIU", a10);
        llibres.add(l4868);

    }

    // Exercici 01
    public void creaBaseDades(String url) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        for (Autor a : autors) {
            db.store(a);
        }
        for (Llibre l : llibres) {
            db.store(l);
        }
        db.close();
    }

    // Exercici 02
    public ArrayList<Autor> tornaTotsAutors(String url) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        ObjectSet<Autor> autors = db.queryByExample(new Autor(0,null));
        ArrayList<Autor> result = new ArrayList<>();
        for (Autor a : autors) {
            result.add(a);
        }
        db.close();
        return result;
    }

    // Exercici 03
    public Autor tornaAutorCN(String url, int codi) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        ObjectSet<Autor> autor  = db.query(new Predicate<Autor>() {
            @Override
            public boolean match(Autor autor1) {
                return codi == autor1.getIdAutor();
            }
        });
        Autor result = autor.next();
        db.close();
        return result;
    }

    // Exercici 04
    public Llibre tornaLlibreTitol(String url, String titol) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        ObjectSet<Llibre> llibre = db.queryByExample(new Llibre(0, titol, null,null,0, null, null,null,null, null));
        Llibre result = llibre.next();
        db.close();
        return result;
    }

    // Exercici 05
    public ArrayList<Llibre> tornaLlibreNumEdicio(String url) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        ObjectSet<Llibre> llibres = db.queryByExample(new Llibre(0, null, null,null,0, null, null,null,null, null));
        ArrayList<Llibre> result = new ArrayList<>();
        for (Llibre l : llibres) {
            if (l.getNumeroEdicio() == null) {
                result.add(l);
            }
        }
        db.close();
        return result;
    }

    // Exercici 06
    public void esborraAutor(String url, int id) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), url);
        ObjectSet<Autor> autor = db.queryByExample(new Autor(id,null));
        Autor autorResult = autor.next();
        ObjectSet<Llibre> llibres = db.queryByExample(new Llibre(0, null, null,null,0, null, null,null,null, autorResult));
        for (Llibre l : llibres) {
            db.delete(l);
        }
        db.delete(autorResult);
        db.close();
    }

}
