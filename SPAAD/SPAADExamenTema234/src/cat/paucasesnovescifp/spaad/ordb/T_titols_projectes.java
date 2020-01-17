package cat.paucasesnovescifp.spaad.ordb;

import org.postgresql.util.PGobject;

import java.sql.SQLException;

import static cat.paucasesnovescifp.spaad.auxiliars.EinesCadenes.parseValue;
import static cat.paucasesnovescifp.spaad.auxiliars.EinesCadenes.tanca;

public class T_titols_projectes extends PGobject {

    private String titol;

    public T_titols_projectes() {
    }

    public T_titols_projectes(String titol) {
        this.titol = titol;
    }

    public String getTitol() {
        return titol;
    }

    @Override
    public String toString() {
        return "T_titols_projectes{" +
                "titol='" + titol + '\'' +
                '}';
    }

    @Override
    public void setValue(String value) throws SQLException {
        super.setValue(value);

        String[] atributs = parseValue(value);
        titol =  atributs[0];
    }

    @Override
    public String getValue() {
        //return super.getValue();
        String resultat = "("+tanca(titol) + ")";
        return resultat;
    }

}
