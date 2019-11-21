package cat.paucasesnoves.activitat4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TerceraActivity extends AppCompatActivity {

    Button boto1;
    Button boto2;
    Button boto3;
    Button boto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceraactivity_layout);

        boto1 = findViewById(R.id.boto1);
        boto2 = findViewById(R.id.boto2);
        boto3 = findViewById(R.id.boto3);
        boto4 = findViewById(R.id.boto4);

        boto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraMissatge("Boton 1"); }
        } );

        boto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraMissatge("Boton 2"); }
        } );

        boto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraMissatge("Boton 3"); }
        } );

        boto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraMissatge("Boton 4"); }
        } );
    }

    public void mostraMissatge(String nomBoto) {
        Toast.makeText(getApplicationContext(), nomBoto, Toast.LENGTH_SHORT).show();
    }
}
