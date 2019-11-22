package cat.paucasesnoves.activitat5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botoObrirWeb;
    Button botoMapa;
    Button botoContactes;
    Button botoCrida;
    private final int CODI_CONTACTES = 1999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoObrirWeb = findViewById(R.id.botoObrirWeb);
        botoMapa = findViewById(R.id.botoMapa);
        botoContactes = findViewById(R.id.botoContactes);
        botoCrida = findViewById(R.id.botoCrida);

        botoObrirWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.iespaucasesnoves.cat"));
                startActivity(i);
            }
        });

        botoMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri map = Uri.parse("google.streetview:cbll=39.7261541,2.9111075");
                Intent i = new Intent(Intent.ACTION_VIEW, map);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
            }
        });

        botoContactes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_PICK);
                i.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivityForResult(i, CODI_CONTACTES);
            }
        });

        botoCrida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:+971881710"));
                startActivity(i);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODI_CONTACTES) {
            //Si el resultat ha sigutpositiu
            if (resultCode == RESULT_OK) { //Mostrem l'URL del contacte
                Toast.makeText(this, data.getData().toString(),
                        Toast.LENGTH_LONG).show();
                //Obrim una altra activitat per veure el contacte
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(data.getData().toString()));
                startActivity(i);
            }
        }
    }

}
