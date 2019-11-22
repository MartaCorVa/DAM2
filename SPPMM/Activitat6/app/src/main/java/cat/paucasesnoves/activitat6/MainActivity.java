package cat.paucasesnoves.activitat6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Països definits a strings.xml
        String[] paisos = getResources().getStringArray(R.array.paisos_array);
        //Crearem l'ArrayAdapter
        ArrayAdapter<String> a = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,paisos);
        setListAdapter(a);
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        //Obtenim el nom del país de l'ítem seleccionat
        String pais = ((TextView) v).getText().toString();
        //Mostra el nom del país
        Toast.makeText(getApplicationContext(),pais,
                Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse("http://en.wikipedia.org/wiki/" + pais));
//        startActivity(i);

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        //Establim seleccions multiples
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //Mostra el nom del país
        if(parent.isItemChecked(position)) {
            Toast.makeText(getApplicationContext(), pais +
                    " marcat",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), pais +
                    " desmarcat",Toast.LENGTH_SHORT).show();
        }

        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
            Uri.parse("geo:0,0?q=" + pais));
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);

    }

}
