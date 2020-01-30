package cat.paucasesnoves.sppmmmaincra.datos;

import java.util.ArrayList;

public class Crafteo {

    private int id;
    private String nombre;
    private String imagen;
    private ArrayList<Material> materiales;

    public Crafteo(String nombre, String imagen, ArrayList<Material> materiales) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.materiales = materiales;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    @Override
    public String toString() {
        return "Crafteo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen=" + imagen +
                ", materiales=" + materiales +
                '}';
    }
}
