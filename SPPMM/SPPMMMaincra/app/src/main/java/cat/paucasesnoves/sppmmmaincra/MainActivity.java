package cat.paucasesnoves.sppmmmaincra;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import cat.paucasesnoves.sppmmmaincra.datos.Crafteo;
import cat.paucasesnoves.sppmmmaincra.datos.Material;
import cat.paucasesnoves.sppmmmaincra.utilidades.CrafteoAdapter;
import cat.paucasesnoves.sppmmmaincra.utilidades.DBInterface;

public class MainActivity extends Activity {

    private DBInterface bd;
    private ListView listaCrafteos;
    private ArrayList<Crafteo> crafteos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_crafteos);

        listaCrafteos = (ListView) findViewById(R.id.listaCrafteos);

        inicializaBBDD();
        inicializaLista();
    }

    public void inicializaBBDD() {
        // Crear Materiales
        Material palo = new Material("Palo", getString(R.string.palo), "Madera", 1);
        Material palo2 = new Material("Palo", getString(R.string.palo), "Madera", 4);
        Material hierro = new Material("Hierro", getString(R.string.hierro), "Mena", 6);
        Material hierro2 = new Material("Hierro", getString(R.string.hierro), "Mena", 7);
        Material hierro3 = new Material("Hierro", getString(R.string.hierro), "Mena", 8);

        ArrayList<Material> materiales = new ArrayList<>();
        materiales.add(palo);
        materiales.add(palo2);
        materiales.add(hierro);
        materiales.add(hierro2);
        materiales.add(hierro3);

        Crafteo crafteo = new Crafteo("Pico de hierro", getString(R.string.hierro), materiales, 3);
        crafteos.add(crafteo);

    }

    public void inicializaLista() {

        // add custom btn handler to first list item
        crafteos.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
            }
        });

        final CrafteoAdapter crafteoAdapter = new CrafteoAdapter(this, crafteos);

        crafteoAdapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });

        listaCrafteos.setAdapter(crafteoAdapter);

        listaCrafteos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                crafteoAdapter.registerToggle(pos);
            }
        });
    }

    /*public void afegirUsuari(View view) {
        bd = new DBInterface(this);
        bd.abre();
        if (bd.insertarMaterial(new Material(editNom.getText().toString(), getString(R.string.palo), editEmail.getText().toString())) != -1) {
            Toast.makeText(this, "Afegit correctament", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error a l’afegir", Toast.LENGTH_LONG).show();
        }
        bd.cierra();
        finish();
    }*/

   /* public void consultarUsuari(View view) {
        bd = new DBInterface(this);
        bd.abre();
        Cursor c = bd.obtenerDatos();
        c.moveToFirst();
        while (!c.isAfterLast()) {

            nombre.setText(c.getString(0));
            byte[] imageAsBytes = Base64.decode(c.getString(1).getBytes(), Base64.DEFAULT);
            imageFrame.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
            obtencion.setText(c.getString(2));

            c.moveToNext();
        }
        bd.cierra();
    }*/

}

