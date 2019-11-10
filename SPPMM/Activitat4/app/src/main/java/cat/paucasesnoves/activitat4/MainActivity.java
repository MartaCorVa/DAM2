package cat.paucasesnoves.activitat4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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
        startActivity(i);
    }



}
