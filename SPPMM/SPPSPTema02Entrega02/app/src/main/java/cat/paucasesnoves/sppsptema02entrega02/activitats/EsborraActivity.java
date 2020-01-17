package cat.paucasesnoves.sppsptema02entrega02.activitats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cat.paucasesnoves.sppsptema02entrega02.R;
import cat.paucasesnoves.sppsptema02entrega02.entitats.DBInterface;

public class EsborraActivity extends AppCompatActivity {

    private DBInterface bd;
    private EditText editID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esborra);

        editID = findViewById(R.id.editTextId);
    }

    public void esborrarUsuari(View view) {
        bd = new DBInterface(this.getApplicationContext());
        bd.obre();
        long id = Long.parseLong(editID.getText().toString());
        boolean result = bd.esborraContacte(id);
        if (result) {
            Toast.makeText(this, "Element esborrat",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No s’ha pogut esborrar l’element",
                    Toast.LENGTH_SHORT).show();
        }
        bd.tanca();
        finish();
    }

}
