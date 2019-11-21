package cat.paucasesnoves.activitat4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultatactivity_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            EditText text = findViewById(R.id.editTextRA);
            text.setText(extras.getString("Valor"));
        }
    }

    @Override
    public void finish(){
        // Preparar intent
        EditText text = findViewById(R.id.editTextRA);
        String valor = text.getText().toString();
        Intent data = new Intent();
        data.putExtra("Retorn1", valor);
        // Tornam un ok
        setResult(RESULT_OK, data);
        super.finish();
    }
}
