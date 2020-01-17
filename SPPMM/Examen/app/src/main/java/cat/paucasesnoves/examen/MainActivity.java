package cat.paucasesnoves.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListView listViewComprat;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Item> itemsComprats = new ArrayList<>();
    private int contador = 0;
    public static final int CODI_PETICIO = 1999;
    private ArrayItem itemsAdapter;
    private ArrayItem itemsAdapterComprats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // agafam el listView amb el seu id
        listView = (ListView) findViewById(R.id.listView);
        listViewComprat = (ListView) findViewById(R.id.listViewComprats);

        // emplenam l'ArrayList<Item> amb els valors corresponents
        items.add(new Item(contador++, "Pesols", "10"));
        items.add(new Item(contador++, "Maduixes", "5"));
        items.add(new Item(contador++, "Panades", "15"));

        // cream un ArrayAdapter a partir de la nostra classe que l'implementa
        itemsAdapter = new ArrayItem(this,R.layout.activity_main, items);
        // afegim l'ArrayAdapter a la nostra llista
        listView.setAdapter(itemsAdapter);

        // cream un ArrayAdapter a partir de la nostra classe que l'implementa
        itemsAdapterComprats = new ArrayItem(this,R.layout.activity_main, itemsComprats);
        // afegim l'ArrayAdapter a la nostra llista
        listViewComprat.setAdapter(itemsAdapterComprats);
    }

    // Han fet click al botó Afegeix
    public void afegirNouItem(View view) {
        //crear un intent
        Intent i = new Intent(this, NouItem.class);

        //cridar l'activitat
        startActivityForResult(i, CODI_PETICIO);
    }

    // Cuando le demos a atrás en la otra actividad el texto que hayamos cambiado se mostrará en un Toast y en el EditText
    // de MainActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == CODI_PETICIO) {
            if (data.hasExtra("Producte") && data.hasExtra("Quantitat")) {
                // Toast con la información
                Toast.makeText(this, data.getExtras().getString("Item Afegit"),
                        Toast.LENGTH_SHORT).show();
                // Cargar EditText con la información
                items.add(new Item(contador++, data.getExtras().getString("Producte"), data.getExtras().getString("Quantitat")));
                itemsAdapter.notifyDataSetChanged();
            }
        }
    }

    public void actualitza(Item item, boolean comprat) {
        if (comprat) {
            items.remove(item);
            itemsComprats.add(item);
        } else {
            itemsComprats.remove(item);
            items.add(item);
        }
        itemsAdapter.notifyDataSetChanged();
        itemsAdapterComprats.notifyDataSetChanged();
    }

}
