package cat.paucasesnoves.sppsptema02entrega02.activitats;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cat.paucasesnoves.sppsptema02entrega02.R;
import cat.paucasesnoves.sppsptema02entrega02.entitats.DBInterface;

public class ConsultaActivity extends AppCompatActivity {

    private DBInterface bd;
    private EditText editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        editId = findViewById(R.id.editTextId);

    }

    public void consultarUsuari(View view) {
        Cursor c;
        bd = new DBInterface(this.getApplicationContext());
        bd.obre();
        long id = Long.parseLong(editId.getText().toString());
        c = bd.obtenirContacte(id);
        if (c.getCount() != 0) {
            Toast.makeText(this, "ID: " + c.getString(0) + "\n" + "Nom: " +
                            c.getString(1) + "\n Email: " + c.getString(2),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ID inexistent!",
                    Toast.LENGTH_SHORT).show();
        }
        bd.tanca();
        finish();
    }

}
