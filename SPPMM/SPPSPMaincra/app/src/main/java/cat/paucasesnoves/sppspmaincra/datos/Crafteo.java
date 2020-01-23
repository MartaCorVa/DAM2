package cat.paucasesnoves.sppspmaincra.datos;

import android.media.Image;

import java.util.ArrayList;

public class Crafteo {

    private int id;
    private String nombre;
    private Image imagen;
    private int cantidad;
    private ArrayList<Material> materiales;

    public Crafteo(int id, String nombre, Image imagen, int cantidad, ArrayList<Material> materiales) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.materiales = materiales;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public int getCantidad() {
        return cantidad;
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
                ", cantidad=" + cantidad +
                ", materiales=" + materiales +
                '}';
    }
}
