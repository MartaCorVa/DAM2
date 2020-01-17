package cat.paucasesnoves.examen;

public class Item {

    private int id;
    private String nom;
    private String quantitat;
    private boolean comprat = false;

    public Item(int id, String nom, String quantitat) {
        this.id = id;
        this.nom = nom;
        this.quantitat = quantitat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(String quantitat) {
        this.quantitat = quantitat;
    }

    public boolean isComprat() {
        return comprat;
    }

    public void setComprat(boolean comprat) {
        this.comprat = comprat;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantitat='" + quantitat + '\'' +
                '}';
    }
}
