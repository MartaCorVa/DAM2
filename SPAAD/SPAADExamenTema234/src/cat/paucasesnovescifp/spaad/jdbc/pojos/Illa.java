package cat.paucasesnovescifp.spaad.jdbc.pojos;

import cat.paucasesnovescifp.spaad.auxiliars.SPAADException;

import java.util.ArrayList;

public class Illa {

    private String idIlla;
    private String nomIlla;
    private ArrayList<Localitat> localitats;

    public Illa(String idIlla, String nomIlla, ArrayList<Localitat> localitats) throws SPAADException {
        if (idIlla == null && ("").equals(idIlla.trim())) {
            throw new SPAADException("Error: ID null o buit.");
        }
        if (nomIlla == null && ("").equals(nomIlla.trim())) {
            throw new SPAADException("Error: nom null o buit.");
        }
        this.idIlla = idIlla;
        this.nomIlla = nomIlla;
        this.localitats = localitats;
    }

    public String getIdIlla() {
        return idIlla;
    }

    public String getNomIlla() {
        return nomIlla;
    }

    public ArrayList<Localitat> getLocalitats() {
        return localitats;
    }

    @Override
    public String toString() {
        return "Illa{" +
                "idIlla='" + idIlla + '\'' +
                ", nomIlla='" + nomIlla + '\'' +
                ", localitats=" + localitats +
                '}';
    }
}
