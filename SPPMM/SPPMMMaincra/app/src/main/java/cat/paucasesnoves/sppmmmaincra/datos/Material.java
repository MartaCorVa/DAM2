package cat.paucasesnoves.sppmmmaincra.datos;

public class Material {

    private int id;
    private String nombre;
    private String imagen;
    private String obtencion;
    private int posicion;

    public Material(String nombre, String imagen, String obtencion, int posicion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.obtencion = obtencion;
        this.posicion = posicion;
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

    public String getObtencion() {
        return obtencion;
    }

    public int getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", obtencion='" + obtencion + '\'' +
                ", posicion=" + posicion +
                '}';
    }
}
