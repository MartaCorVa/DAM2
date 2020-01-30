package cat.paucasesnoves.sppmmmaincra;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
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

        Crafteo crafteo = new Crafteo("Pico de hierro", getString(R.string.hierro), materiales);
        crafteos.add(crafteo);

    }

    public void inicializaLista() {
        CrafteoAdapter crafteoAdapter = new CrafteoAdapter(this, R.layout.list_crafteos, crafteos);
        listaCrafteos.setAdapter(crafteoAdapter);
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
