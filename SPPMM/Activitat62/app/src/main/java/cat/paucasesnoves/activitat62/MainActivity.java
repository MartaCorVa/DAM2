package cat.paucasesnoves.activitat62;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //Països definits a strings.xml
        String[] paisos = getResources().getStringArray(R.array.paisos_array);
        //Crearem l'ArrayAdapter
        ArrayAdapter<String> a = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,paisos);
        setListAdapter(a);
    }
}
