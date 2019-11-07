package cat.paucasesnovescifp.spaad.entitats;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "AUTORS", schema = "biblioteca", catalog = "")
public class Autor {
    private int idAut;
    private String nomAut;
    private Timestamp dnaixAut;

    @Id
    @Column(name = "ID_AUT", nullable = false)
    public int getIdAut() {
        return idAut;
    }

    public void setIdAut(int idAut) {
        this.idAut = idAut;
    }

    @Basic
    @Column(name = "NOM_AUT", nullable = true, length = 100)
    public String getNomAut() {
        return nomAut;
    }

    public void setNomAut(String nomAut) {
        this.nomAut = nomAut;
    }

    @Basic
    @Column(name = "DNAIX_AUT", nullable = true)
    public Timestamp getDnaixAut() {
        return dnaixAut;
    }

    public void setDnaixAut(Timestamp dnaixAut) {
        this.dnaixAut = dnaixAut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return idAut == autor.idAut &&
                Objects.equals(nomAut, autor.nomAut) &&
                Objects.equals(dnaixAut, autor.dnaixAut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAut, nomAut, dnaixAut);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAut=" + idAut +
                ", nomAut='" + nomAut + '\'' +
                ", dnaixAut=" + dnaixAut +
                '}';
    }
}
