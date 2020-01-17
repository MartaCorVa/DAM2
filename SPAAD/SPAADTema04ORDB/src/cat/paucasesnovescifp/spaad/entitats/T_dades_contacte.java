package cat.paucasesnovescifp.spaad.entitats;

import org.postgresql.util.PGobject;

import java.sql.SQLException;

import static cat.paucasesnovescifp.spaad.auxiliars.EinesCadenes.*;

public class T_dades_contacte extends PGobject {

    private String telefon;
    private String correu_electronic;
    private String usuari_twitter;

    public T_dades_contacte() {
    }

    public T_dades_contacte(String telefon, String correu_electronic, String usuari_twitter) {
        this.telefon = telefon;
        this.correu_electronic = correu_electronic;
        this.usuari_twitter = usuari_twitter;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCorreu_electronic() {
        return correu_electronic;
    }

    public String getUsuari_twitter() {
        return usuari_twitter;
    }

    @Override
    public String toString() {
        return "T_dades_contacte{" +
                "telefon='" + telefon + '\'' +
                ", correu_electronic='" + correu_electronic + '\'' +
                ", usuari_twitter='" + usuari_twitter + '\'' +
                '}';
    }

    @Override
    public void setValue(String value) throws SQLException {
        super.setValue(value);

        String[] atributs = parseValue(value);
        telefon =  atributs[0];
        correu_electronic = atributs[1];
        usuari_twitter = atributs[2];
    }

    @Override
    public String getValue() {
        //return super.getValue();
        String resultat = "("+tanca(telefon) + ",";
        resultat += tanca(correu_electronic)+",";
        resultat += tanca(usuari_twitter)+")";
        return resultat;
    }

}
