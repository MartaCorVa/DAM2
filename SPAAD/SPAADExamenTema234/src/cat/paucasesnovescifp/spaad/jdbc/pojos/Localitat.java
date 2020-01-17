package cat.paucasesnovescifp.spaad.jdbc.pojos;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;

public class Localitat {

    private String idLocalitat;
    private String nomLocalitat;

    public Localitat(String idLocalitat, String nomLocalitat) throws SPAADException {
        if (idLocalitat == null && ("").equals(idLocalitat.trim())) {
            throw new SPAADException("Error: ID null o buit.");
        }
        if (nomLocalitat == null && ("").equals(nomLocalitat.trim())) {
            throw new SPAADException("Error: nom null o buit.");
        }
        this.idLocalitat = idLocalitat;
        this.nomLocalitat = nomLocalitat;
    }

    public String getIdLocalitat() {
        return idLocalitat;
    }

    public String getNomLocalitat() {
        return nomLocalitat;
    }

    @Override
    public String toString() {
        return "Localitat{" +
                "idLocalitat='" + idLocalitat + '\'' +
                ", nomLocalitat='" + nomLocalitat + '\'' +
                '}';
    }
}
