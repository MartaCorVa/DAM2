package cat.paucasesnoves.activitat6_2;

public class Joc {

    private int codi;
    private String nom;
    private String tipus;
    private String data;
    private String nota;
    private String preu;
    private String img;

    public Joc(int codi, String nom, String tipus, String data, String nota, String preu, String img) {
        this.codi = codi;
        this.nom = nom;
        this.tipus = tipus;
        this.data = data;
        this.nota = nota;
        this.preu = preu;
        this.img = img;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getPreu() {
        return preu;
    }

    public void setPreu(String preu) {
        this.preu = preu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
