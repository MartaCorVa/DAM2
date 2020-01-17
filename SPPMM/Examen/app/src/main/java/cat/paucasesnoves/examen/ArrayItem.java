package cat.paucasesnoves.examen;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArrayItem extends ArrayAdapter<Item> {

    private Context context;
    private List<Item> items;
    Item item;

    //constructor
    public ArrayItem(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    //es crida a l'hora de representar la llista
    public View getView(int position, View convertView, ViewGroup parent) {
        //agafam l'item per posició a l'Array
        item = items.get(position);

        //agafam "l'inflater" per "inflar" el layout per a cada item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_llista, null);

        //instanciam cada element del layout a utilitzar
        TextView nom = (TextView) view.findViewById(R.id.nom);
        TextView quantitat = (TextView) view.findViewById(R.id.quantitat);

        //omplim les dades dels atributs que utilitzam
        nom.setText(item.getNom());
        quantitat.setText(item.getQuantitat());

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        checkBox.setChecked(item.isComprat());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof MainActivity) {
                    boolean comprat = item.isComprat();
                    if (comprat) {
                        comprat = false;
                        item.setComprat(false);
                    } else {
                        comprat = true;
                        item.setComprat(true);
                    }
                    ((MainActivity)context).actualitza(item, comprat);
                }
            }
        });

        return view;
    }
}
