package cat.paucasesnoves.activitat4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CODI_PETICIO = 1999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cridaSubaccio(View view) {
        EditText tx = (EditText) findViewById(R.id.editText);
        //agafar el text introduït
        String texte = tx.getText().toString();
        //crear un intent
        Intent i = new Intent(this, ResultatActivity.class);
        //passar un valor
        i.putExtra("Valor", texte);
        //cridar l'activitat
        //startActivity(i);
        startActivityForResult(i, CODI_PETICIO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == CODI_PETICIO) {
            if (data.hasExtra("Retorn1")) {
                Toast.makeText(this, data.getExtras().getString("Retorn1"),
                        Toast.LENGTH_SHORT).show();
                EditText tx = (EditText) findViewById(R.id.editText);
                tx.setText(data.getExtras().getString("Retorn1"));
            }
        }
    }

    public void compartir (View view) {
        Intent compartit = new Intent(Intent.ACTION_SEND);
        compartit.setType("text/plain");
        compartit.putExtra(android.content.Intent.EXTRA_TEXT,"ES MEU TEXT");
        startActivity(compartit);
    }

    public void abrirTercera(View view) {
        //crear un intent
        Intent i = new Intent(this, TerceraActivity.class);
        //cridar l'activitat
        startActivity(i);
    }

    public void abrirCuarta(View view) {
        //crear un intent
        Intent i = new Intent(this, QuartaActivity.class);
        //cridar l'activitat
        startActivity(i);
    }

}
