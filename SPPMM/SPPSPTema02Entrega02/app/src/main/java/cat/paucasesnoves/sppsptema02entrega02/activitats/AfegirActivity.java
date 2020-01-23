package cat.paucasesnoves.sppsptema02entrega02.activitats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cat.paucasesnoves.sppsptema02entrega02.R;
import cat.paucasesnoves.sppsptema02entrega02.entitats.DBInterface;

public class AfegirActivity extends AppCompatActivity {

    private DBInterface bd;
    private EditText editNom;
    private EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir);

        editNom = findViewById(R.id.editTextNom);
        editEmail = findViewById(R.id.editTextEmail);
    }

    public void afegirUsuari(View view) {
        bd = new DBInterface(this);
        bd.obre();
        if (bd.insereixContacte(editNom.getText().toString(), editEmail.getText().toString()) != -1) {
            Toast.makeText(this, "Afegit correctament", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error a l’afegir", Toast.LENGTH_LONG).show();
        }
        bd.tanca();
        finish();
    }
}
