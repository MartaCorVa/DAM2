package cat.paucasesnovescifp.spaad.jdbc.dades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;

/**
 *
 * @author marta
 */
public class Llibre {
    
    private Integer id_llib;
    private String titol;
    private String fk_llengua;

    public Llibre(Integer id_llib, String titol, String fk_llengua) throws JDBCException {
        if (id_llib == null) {
            throw new JDBCException("Error: id null o buit.");
        }
        if (titol == null && ("").equals(titol.trim())) {
            throw new JDBCException("Error: titol null o buit.");
        }
        if (fk_llengua == null && ("").equals(fk_llengua.trim())) {
            throw new JDBCException("Error: nom null o buit.");
        }
        this.id_llib = id_llib;
        this.titol = titol;
        this.fk_llengua = fk_llengua;
    }

    public Integer getId_llib() {
        return id_llib;
    }

    public String getTitol() {
        return titol;
    }

    public String getFk_llengua() {
        return fk_llengua;
    }

    @Override
    public String toString() {
        return "Llibre{" + "id_llib=" + id_llib + ", titol=" + titol + ", fk_llengua=" + fk_llengua + '}';
    }
    
}
