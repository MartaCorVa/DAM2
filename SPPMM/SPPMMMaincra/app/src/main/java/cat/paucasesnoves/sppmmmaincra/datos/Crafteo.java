package cat.paucasesnoves.sppmmmaincra.datos;

import android.view.View;

import java.util.ArrayList;

public class Crafteo {

    private int id;
    private String nombre;
    private String imagen;
    private ArrayList<Material> materiales;
    private View.OnClickListener requestBtnClickListener;
    private int requestsCount;

    public Crafteo(String nombre, String imagen, ArrayList<Material> materiales, int requestsCount) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.materiales = materiales;
        this.requestsCount = requestsCount;
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

    public int getRequestsCount() {
        return requestsCount;
    }

    public void setRequestsCount(int requestsCount) {
        this.requestsCount = requestsCount;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
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
