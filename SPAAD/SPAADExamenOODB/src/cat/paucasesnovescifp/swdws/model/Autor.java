/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.model;

import java.util.Objects;

/**
 *
 * @author alumne
 */
public class Autor {
    
    private int idAutor;
    private String nomAutor;

    public Autor(int idAutor, String nomAutor) {
        this.idAutor = idAutor;
        this.nomAutor = nomAutor;
    }

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @return the nomAutor
     */
    public String getNomAutor() {
        return nomAutor;
    }

    /**
     * @param nomAutor the nomAutor to set
     */
    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nomAutor=" + nomAutor + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return idAutor == autor.idAutor &&
                Objects.equals(nomAutor, autor.nomAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor, nomAutor);
    }
}
