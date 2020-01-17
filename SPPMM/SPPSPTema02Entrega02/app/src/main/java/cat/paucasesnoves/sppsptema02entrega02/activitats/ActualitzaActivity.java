package cat.paucasesnoves.sppsptema02entrega02.activitats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cat.paucasesnoves.sppsptema02entrega02.R;
import cat.paucasesnoves.sppsptema02entrega02.entitats.DBInterface;

public class ActualitzaActivity extends AppCompatActivity {

    private DBInterface bd;
    private EditText editID;
    private EditText editNom;
    private EditText editEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualitza);

        editID = findViewById(R.id.editTextId);
        editNom = findViewById(R.id.editTextNom);
        editEmail = findViewById(R.id.editTextEmail);
    }

    public void actualitzarUsuari(View view) {
        long id;
        bd = new DBInterface(this.getApplicationContext());
        bd.obre();
        id = Long.parseLong(editID.getText().toString());
        boolean result = bd.actualitzarContacte(id,
                editNom.getText().toString(), editEmail.getText().toString());
        if (result)
            Toast.makeText(this, "Element modificat",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No s’ha pogut modificar l’element",
                    Toast.LENGTH_SHORT).show();
        bd.tanca();
        finish();
    }

}
