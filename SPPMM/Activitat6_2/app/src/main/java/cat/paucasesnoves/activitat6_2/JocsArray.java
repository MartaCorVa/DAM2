package cat.paucasesnoves.activitat6_2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JocsArray extends ArrayAdapter<Joc> {

    private Context context;
    private List<Joc> jocs;
    //constructor
    public JocsArray(Context context, int resource, ArrayList<Joc> objects) {
        super(context, resource, objects);
        this.context = context;
        this.jocs = objects;
    }

    //es crida a l'hora de representar la llista
    public View getView(int position, View convertView, ViewGroup parent) {
        //agafam el Joc per posició a l'Array
        Joc joc = jocs.get(position);
        //agafam "l'inflater" per "inflar" el layout per a cada item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.llista_jocs, null);
        //instanciam cada element del layout a utilitzar
        TextView nom = (TextView) view.findViewById(R.id.nom);
        TextView tipus = (TextView) view.findViewById(R.id.tipus);
        TextView data = (TextView) view.findViewById(R.id.data);
        TextView nota = (TextView) view.findViewById(R.id.nota);
        TextView preu = (TextView) view.findViewById(R.id.preu);
        ImageView imatge = (ImageView) view.findViewById(R.id.imatge);
        //omplim les dades
        nom.setText(joc.getNom());
        tipus.setText(joc.getTipus());
        data.setText(joc.getData());
        nota.setText(joc.getNota());
        preu.setText(String.valueOf(joc.getPreu()) + "€");
        //agafam la imatge
        int imageID = context.getResources().getIdentifier(joc.getImg(),
                "drawable",
                context.getPackageName());
        imatge.setImageResource(imageID);
        return view;
    }

}
