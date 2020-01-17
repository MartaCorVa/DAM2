package cat.paucasesnoves.activitat62;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String pais;
    Boolean checkPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        listView = (ListView) findViewById(R.id.listView);
        //Països definits a strings.xml
        String[] paisos = getResources().getStringArray(R.array.paisos_array);
        //Crearem l'ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.check, paisos);
        listView.setAdapter(arrayAdapter);
    }

    public void onCheckboxClicked(View view) {
        checkPais = ((CheckBox) view).isChecked();
        pais = ((CheckBox) view).getText().toString();

        if (checkPais) {
            Toast.makeText(getApplicationContext(), pais +
                    " marcat",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), pais +
                    " desmarcat",Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
        Intent b = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + pais));
        b.setPackage("com.google.android.apps.maps");
        startActivity(b);
    }

}
