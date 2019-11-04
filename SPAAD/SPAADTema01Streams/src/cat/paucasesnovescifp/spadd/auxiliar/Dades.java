package cat.paucasesnovescifp.spadd.auxiliar;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author marta
 */
public class Dades implements Serializable {
    
    private int numeric;
    private String alfanumeric;

    public Dades(int numeric, String alfanumeric) {
        this.numeric = numeric;
        this.alfanumeric = alfanumeric;
    }

    public int getNumeric() {
        return numeric;
    }

    public void setNumeric(int numeric) {
        this.numeric = numeric;
    }

    public String getAlfanumeric() {
        return alfanumeric;
    }

    public void setAlfanumeric(String alfanumeric) {
        this.alfanumeric = alfanumeric;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numeric;
        hash = 37 * hash + Objects.hashCode(this.alfanumeric);
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
        final Dades other = (Dades) obj;
        if (this.numeric != other.numeric) {
            return false;
        }
        if (!Objects.equals(this.alfanumeric, other.alfanumeric)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dades{" + "numeric=" + numeric + ", alfanumeric=" + alfanumeric + '}';
    }    
    
}
