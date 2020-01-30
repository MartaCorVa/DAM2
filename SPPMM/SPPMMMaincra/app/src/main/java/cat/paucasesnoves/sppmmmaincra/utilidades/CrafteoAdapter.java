package cat.paucasesnoves.sppmmmaincra.utilidades;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import cat.paucasesnoves.sppmmmaincra.R;
import cat.paucasesnoves.sppmmmaincra.datos.Crafteo;

public class CrafteoAdapter extends ArrayAdapter<Crafteo> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public CrafteoAdapter(Context context, List<Crafteo> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Cogemos el crafteo
        Crafteo crafteo = getItem(position);

        // Si el cell existe reutilizalo, sino crea uno nuevo
        FoldingCell cell = (FoldingCell) convertView;

        // Instanciamos un viewHolder
        ViewHolder viewHolder;

        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            // Asignar los elementos
            viewHolder.img = cell.findViewById(R.id.imgItem);
            viewHolder.text = cell.findViewById(R.id.textView);
            cell.setTag(viewHolder);
        } else {
            // Si existe reutiliza
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == crafteo) {
            return cell;
        }

        // Asignar la informacion
        viewHolder.text.setText(crafteo.getNombre());
        byte[] imageAsBytes = Base64.decode(crafteo.getImagen().getBytes(), Base64.DEFAULT);
        viewHolder.img.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        // set custom btn handler for list item from that item
        if (crafteo.getRequestBtnClickListener() != null) {
            viewHolder.text.setOnClickListener(crafteo.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.text.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
    }

    // Crear un viewHolder
    private static class ViewHolder {
        ImageView img;
        TextView text;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

}

    /*private Context context;
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

        // Añadir animacion
        // get our folding cell
        final FoldingCell fc = (FoldingCell) view.findViewById(R.id.folding_cell);

        // set custom parameters
        fc.initialize(1000, Color.DKGRAY, 2);
        // or with camera height parameter
        fc.initialize(30, 1000, Color.DKGRAY, 2);

        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Error a l’afegir", Toast.LENGTH_LONG).show();
                fc.toggle(false);
            }
        });

        return view;
    }*/