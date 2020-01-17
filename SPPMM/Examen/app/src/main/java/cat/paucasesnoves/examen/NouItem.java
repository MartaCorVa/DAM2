package cat.paucasesnoves.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NouItem extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nou_item_layout);
    }

    // Han fet click al botó Afegeix
    public void afegirNouItem(View view) {
        finish();
    }

    @Override
    public void finish(){
        // Preparar intent
        EditText producte = (EditText) findViewById(R.id.nouProducte);
        EditText quantitat = (EditText) findViewById(R.id.novaQuantitat);

        //agafar el text introduït
        String textProducte = producte.getText().toString();
        String textQuantitat = quantitat.getText().toString();

        Intent data = new Intent();
        data.putExtra("Producte", textProducte);
        data.putExtra("Quantitat", textQuantitat);

        // Tornam un ok
        setResult(RESULT_OK, data);
        super.finish();
    }

}
