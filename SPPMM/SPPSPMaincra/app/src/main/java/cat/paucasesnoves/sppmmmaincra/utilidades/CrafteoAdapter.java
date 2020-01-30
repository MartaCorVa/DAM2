package cat.paucasesnoves.sppmmmaincra.utilidades;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cat.paucasesnoves.sppmmmaincra.R;
import cat.paucasesnoves.sppmmmaincra.datos.Crafteo;

public class CrafteoAdapter extends ArrayAdapter<Crafteo> {

    private Context context;
    private List<Crafteo> crafteos;

    //constructor
    public CrafteoAdapter(Context context, int resource, ArrayList<Crafteo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.crafteos = objects;
    }

    //es crida a l'hora de representar la llista
    public View getView(int position, View convertView, ViewGroup parent) {
        // Cogemos un crafteo
        Crafteo crafteo = crafteos.get(position);

        // Usamos el inflator para cada item del layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_crafteo, null);

        // Instanciamos cada elemento
        ImageView img = (ImageView) view.findViewById(R.id.imgItem);
        TextView text = (TextView) view.findViewById(R.id.textView);

        // Convertimos la imagen
        byte[] imageAsBytes = Base64.decode(crafteo.getImagen().getBytes(), Base64.DEFAULT);
        img.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        // Colocamos los datos
        text.setText(crafteo.getNombre());

        return view;
    }
}
