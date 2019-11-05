package cat.paucasesnovescifp.spaad.jdbc.dades;

import cat.paucasesnovescifp.spaad.jdbc.auxiliars.JDBCException;

/**
 *
 * @author marta
 */
public class Autor {
    
    private Integer id_aut;
    private String nom_aut;
    private String fk_nacionalitat;

    public Autor(Integer id_aut, String nom_aut, String fk_nacionalitat) throws JDBCException {
        if (nom_aut == null && ("").equals(nom_aut.trim())) {
            throw new JDBCException("Error: nom null o buit.");
        }
        if(id_aut == null && ("").equals(id_aut)) {
            throw new JDBCException("Error: id null o buit.");
        }
        if(("").equals(fk_nacionalitat)) {
            throw new JDBCException("Error: nacionalitat buida.");
        }      
        this.nom_aut = nom_aut;
        this.id_aut = id_aut;
        this.fk_nacionalitat = fk_nacionalitat;
    }

    public Integer getId_aut() {
        return id_aut;
    }

    public String getNom_aut() {
        return nom_aut;
    }

    public String getFk_nacionalitat() {
        return fk_nacionalitat;
    }

    @Override
    public String toString() {
        return "Autor{" + "id_aut=" + id_aut + ", nom_aut=" + nom_aut + ", fk_nacionalitat=" + fk_nacionalitat + '}';
    }
    
}
