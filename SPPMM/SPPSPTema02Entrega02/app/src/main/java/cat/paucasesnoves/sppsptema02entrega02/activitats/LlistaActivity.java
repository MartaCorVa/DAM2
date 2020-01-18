package cat.paucasesnoves.sppsptema02entrega02.activitats;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import cat.paucasesnoves.sppsptema02entrega02.R;
import cat.paucasesnoves.sppsptema02entrega02.entitats.DBInterface;

public class LlistaActivity extends AppCompatActivity {

    private DBInterface bd;
    private ListAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);

        listView = findViewById(R.id.llista);
        llistaContactes();
    }

    public void llistaContactes() {
        bd = new DBInterface(this);
        bd.obre();
        Cursor c = bd.obtenirTotsElsContactes();
        c.moveToFirst();
        ArrayList<HashMap<String, String>> llista = new ArrayList<HashMap<String, String>>();
        while (!c.isAfterLast()) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id",c.getString(0));
            map.put("nom",c.getString(1));
            map.put("email",c.getString(2));
            llista.add(map);
            c.moveToNext();
        }
        bd.tanca();
        adapter = new SimpleAdapter(this, llista,R.layout.list_item,
                new String[] { "id", "nom","email" }, new int[] {R.id.id,
                R.id.nom, R.id.email});
        listView.setAdapter(adapter);
    }

}
