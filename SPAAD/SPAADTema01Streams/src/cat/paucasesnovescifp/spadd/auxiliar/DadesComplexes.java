package cat.paucasesnovescifp.spadd.auxiliar;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author marta
 */
public class DadesComplexes implements Serializable {
    
    private String id;
    private Dades dades;

    public DadesComplexes(String id, Dades dades) {
        this.id = id;
        this.dades = dades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dades getDades() {
        return dades;
    }

    public void setDades(Dades dades) {
        this.dades = dades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.dades);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DadesComplexes other = (DadesComplexes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dades, other.dades)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DadesComplexes{" + "id=" + id + ", dades=" + dades + '}';
    }
    
}
